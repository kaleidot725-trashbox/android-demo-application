package kaleidot725.classicclock

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    var mClockViewModel : ClockViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mClockViewModel = ViewModelProviders.of(this).get(ClockViewModel::class.java)
        mClockViewModel?.mLocalDateTime?.observe(this, object : Observer<LocalDateTime>{
            override fun onChanged(t: LocalDateTime?) {
                val clockTextView = findViewById<TextView>(R.id.ClockText)
                clockTextView.text = t.toString()
            }
        })
    }
}
