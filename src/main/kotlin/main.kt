import kotlinx.coroutines.*
import kotlinx.serialization.json.*
import kotlinx.serialization.list
import model.*

fun main() {
    val json = Json(JsonConfiguration.Stable)
    val restService = RestService()
    runBlocking {
        val user = getUserWithPosts(restService, json)
        println(user)
    }
}

suspend fun getUserWithPosts(restService: Service, json: Json): User {
    val deferredUser = getUser(restService, json)
    val deferredPosts = getPosts(restService, json)
    val user = deferredUser.await()
    val posts = deferredPosts.await()
    user.posts = posts

    return user
}

fun getUser(restService: Service, json: Json): Deferred<User> {
    return GlobalScope.async {
        json.parse(User.serializer(), restService.getUserById(1))
    }
}

fun getPosts(restService: Service, json: Json): Deferred<List<Post>> {
    return GlobalScope.async {
        json.parse(Post.serializer().list, restService.getPostsByUser(1))
    }
}
