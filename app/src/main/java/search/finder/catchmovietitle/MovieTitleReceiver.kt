package search.finder.catchmovietitle

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.util.Log
import android.widget.Toast

const val SEND_MOVIE_TITLE = "MOVIE TITLE"

class MovieTitleReceiver(private val listener: MovieTitleLoad? = null) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val handler = Handler()
        Thread {
            val movieTitle = intent.getStringExtra(SEND_MOVIE_TITLE)
            Log.d("myLogs", movieTitle?:"666")
            handler.post(Runnable {
                movieTitle?.let{ listener?.onLoad(it) }
            })
        }.start()
    }
}