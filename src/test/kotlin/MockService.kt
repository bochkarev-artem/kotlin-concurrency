import kotlinx.coroutines.delay

object MockService: Service {
    override suspend fun getUserById(id: Int): String {
        delay(200L)
        return "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"Leanne Graham\",\n" +
                "  \"username\": \"Bret\",\n" +
                "  \"email\": \"Sincere@april.biz\",\n" +
                "  \"address\": {\n" +
                "    \"street\": \"Kulas Light\",\n" +
                "    \"suite\": \"Apt. 556\",\n" +
                "    \"city\": \"Gwenborough\",\n" +
                "    \"zipcode\": \"92998-3874\",\n" +
                "    \"geo\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"lng\": \"81.1496\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"phone\": \"1-770-736-8031 x56442\",\n" +
                "  \"website\": \"hildegard.org\",\n" +
                "  \"company\": {\n" +
                "    \"name\": \"Romaguera-Crona\",\n" +
                "    \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                "    \"bs\": \"harness real-time e-markets\"\n" +
                "  }\n" +
                "}"
    }

    override suspend fun getPostsByUser(userId: Int): String {
        delay(500L)
        return "[\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 2,\n" +
                "    \"title\": \"qui est esse\",\n" +
                "    \"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\n" +
                "  }\n" +
                "]"
    }
}