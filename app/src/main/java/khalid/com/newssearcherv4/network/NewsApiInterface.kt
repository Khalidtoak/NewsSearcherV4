package khalid.com.newssearcherv4.network

import khalid.com.newssearcherv4.network.models.LatestNews
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by  on 4/13/2019.
 */
interface  NewsApiInterface{
    @GET("v2/everything")
    fun fetchLatestNewsAsync(@Query("q") query: String,
                             @Query("sortBy") sortBy : String) : Deferred<Response<LatestNews>>
}