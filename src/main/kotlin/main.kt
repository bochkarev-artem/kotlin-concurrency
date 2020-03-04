import kotlinx.coroutines.*
import kotlinx.serialization.json.*
import kotlinx.serialization.list
import java.net.URL
import model.*

fun main() {
    val json = Json(JsonConfiguration.Stable)
    val deferredPosts: Deferred<List<Post>> = GlobalScope.async {
        delay(5000L)
        val postResponse = URL("https://jsonplaceholder.typicode.com/posts?userId=1").readText()
        println("now parse posts")
        json.parse(Post.serializer().list, postResponse)
    }

    val deferredUser: Deferred<User> = GlobalScope.async {
        delay(6000L)
        val userResponse = URL("https://jsonplaceholder.typicode.com/users/1").readText()
        println("now parse users")
        json.parse(User.serializer(), userResponse)
    }

    runBlocking {
        val user = deferredUser.await()
        val posts = deferredPosts.await()
        user.posts = posts
        println(user)
    }
}