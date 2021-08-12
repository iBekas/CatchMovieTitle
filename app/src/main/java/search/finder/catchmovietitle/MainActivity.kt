package search.finder.catchmovietitle

import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import search.finder.catchmovietitle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MovieTitleLoad {

    private lateinit var binding: ActivityMainBinding
    private val receiver = MovieTitleReceiver(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerReceiver(receiver, IntentFilter(SEND_MOVIE_TITLE))
    }

    override fun onLoad(movieTitle: String) {
        Log.d("myLogs", movieTitle+"onLoad")
        binding.catchMovie.text = movieTitle
        recreate()
    }
}