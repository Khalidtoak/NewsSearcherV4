package khalid.com.newssearcherv4.repositories

import android.util.Log
import khalid.com.newssearcherv4.network.Output
import retrofit2.Response
import java.io.IOException

/**
 * Created by  on 4/13/2019.
 */
open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call : suspend()-> Response<T>, error : String) :  T?{
        val result = newsApiOutput(call, error)
        var output : T? = null
        when(result){
            is Output.Success ->
                output = result.output
           is Output.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output

    }
    private suspend fun<T : Any> newsApiOutput(call: suspend()-> Response<T> , error: String) : Output<T>{
        val response = call.invoke()
        return if (response.isSuccessful)
            Output.Success(response.body()!!)
        else
            Output.Error(IOException("OOps .. Something went wrong due to  $error"))
    }
}