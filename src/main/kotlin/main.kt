import kotlinx.serialization.json.*
import kotlinx.serialization.list
import java.net.URL
import model.*

fun main() {
    val userResponse = URL("https://jsonplaceholder.typicode.com/users/1").readText()
    val postResponse = URL("https://jsonplaceholder.typicode.com/posts?userId=1").readText()

    val json = Json(JsonConfiguration.Stable)
    val user = json.parse(User.serializer(), userResponse)
    val list: List<Post> = json.parse(Post.serializer().list, postResponse)

    println(user)
    println(list)
}