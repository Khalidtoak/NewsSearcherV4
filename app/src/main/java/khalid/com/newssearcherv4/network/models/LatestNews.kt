package khalid.com.newssearcherv4.network.models

data class LatestNews(
        val articles: List<Article>,
        val status: String,
        val totalResults: Int
)