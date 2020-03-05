import java.net.URL

interface Service {
    suspend fun getUserById(id: Int): String
    suspend fun getPostsByUser(userId: Int): String
}

class RestService: Service {
    override suspend fun getUserById(id: Int): String {
        return URL("https://jsonplaceholder.typicode.com/users/$id").readText()
    }

    override suspend fun getPostsByUser(userId: Int): String {
        return URL("https://jsonplaceholder.typicode.com/posts?userId=$userId").readText()
    }
}
