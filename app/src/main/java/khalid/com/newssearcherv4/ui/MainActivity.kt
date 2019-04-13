package khalid.com.newssearcherv4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import khalid.com.newssearcherv4.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModelFactory = NewsViewModelFactory()
        newsViewModel =  ViewModelProviders.of(this@MainActivity, viewModelFactory)
                .get(NewsViewModel::class.java)
        newsViewModel.getLatestNews()
        newsViewModel.newsLiveData.observe(this, Observer {
            //bind your ui here

        })

        }
    }
