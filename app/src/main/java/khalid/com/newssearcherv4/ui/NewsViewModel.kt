package khalid.com.newssearcherv4.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import khalid.com.newssearcherv4.network.NewsApiService
import khalid.com.newssearcherv4.network.models.Article
import khalid.com.newssearcherv4.repositories.NewsRepo
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Created by  on 4/13/2019.
 */
class NewsViewModel : ViewModel(){
    private val parentJob = Job()
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val newsRepository : NewsRepo = NewsRepo(NewsApiService.newsApi)
     val newsLiveData = MutableLiveData<MutableList<Article>>()
    fun getLatestNews() {
        scope.launch {
            val latestNews = newsRepository.getLatestNews()
            newsLiveData.postValue(latestNews)

        }
    }
    fun cancelRequests() = coroutineContext.cancel()
}