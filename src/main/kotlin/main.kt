import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.list
import model.Post
import model.User

fun main() {
    val json = Json(JsonConfiguration.Stable)
    val restService = RestService()
    runBlocking {
        val user = getUserWithPosts(restService, json)
        println(user)
    }
}

suspend fun getUserWithPosts(restService: Service, json: Json): User = coroutineScope {
    val deferredUser = async {
        json.parse(User.serializer(), restService.getUserById(1))
    }
    val deferredPosts = async {
        json.parse(Post.serializer().list, restService.getPostsByUser(1))
    }

    val user = deferredUser.await()
    val posts = deferredPosts.await()
    user.posts = posts
    user
}