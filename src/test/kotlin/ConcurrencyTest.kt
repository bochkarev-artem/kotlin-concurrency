import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.junit.Assert
import org.junit.Test

@UseExperimental(ExperimentalCoroutinesApi::class)
class ConcurrencyTest {
    @Test
    fun testConcurrent(): Unit = runBlockingTest {
        val startTime = currentTime
        val user = getUserWithPosts(MockService, Json(JsonConfiguration.Stable))
        val totalTime = currentTime - startTime
        Assert.assertEquals(
            "Virtual time should be max(500, 200)",
            500, totalTime
        )
        Assert.assertEquals(
            "User data",
            "User(id=1, name=Leanne Graham, username=Bret, email=Sincere@april.biz, address=Address(street=Kulas Light, suite=Apt. 556, city=Gwenborough, zipcode=92998-3874, geo=Geo(lat=-37.3159, lng=81.1496)), phone=1-770-736-8031 x56442, website=hildegard.org, company=Company(name=Romaguera-Crona, catchPhrase=Multi-layered client-server neural-net, bs=harness real-time e-markets), posts=[Post(userId=1, id=1, title=sunt aut facere repellat provident occaecati excepturi optio reprehenderit, body=quia et suscipit\n" +
                    "suscipit recusandae consequuntur expedita et cum\n" +
                    "reprehenderit molestiae ut ut quas totam\n" +
                    "nostrum rerum est autem sunt rem eveniet architecto), Post(userId=1, id=2, title=qui est esse, body=est rerum tempore vitae\n" +
                    "sequi sint nihil reprehenderit dolor beatae ea dolores neque\n" +
                    "fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\n" +
                    "qui aperiam non debitis possimus qui neque nisi nulla)])", user.toString()
        )
    }
}