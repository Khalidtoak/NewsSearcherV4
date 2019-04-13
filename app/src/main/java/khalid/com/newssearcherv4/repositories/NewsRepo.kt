package khalid.com.newssearcherv4.repositories

import khalid.com.newssearcherv4.network.NewsApiInterface
import khalid.com.newssearcherv4.network.models.Article

/**
 * Created by  on 4/13/2019.
 */
class NewsRepo(private val apiInterface: NewsApiInterface) : BaseRepository() {
    suspend fun getLatestNews() :  MutableList<Article>?{
        return safeApiCall(
                call = {apiInterface.fetchLatestNewsAsync("Nigeria", "publishedAt").await()},
                error = "Error fetching news"
        )?.articles?.toMutableList()
    }
}