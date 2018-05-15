package kaleidot725.texttospeechdemo.MainActivity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kaleidot725.texttospeechdemo.R
import kaleidot725.texttospeechdemo.ViewModelFactory
import java.util.*

class TextToSpeechDemoActivity : AppCompatActivity() {
    var tts : TextToSpeech? = null
    var viewModel : TextToSpeechDemoViewModel? = null
    var viewModelFactory : ViewModelFactory? = null
    var tag : String = "TextToSpeechDemoFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_to_speech_demo)

        tts = android.speech.tts.TextToSpeech(applicationContext, object : TextToSpeech.OnInitListener{
            override fun onInit(p0: Int) {
                if(p0 != android.speech.tts.TextToSpeech.ERROR)
                    tts?.language = Locale.JAPANESE
            }
        })

        viewModelFactory = ViewModelFactory(tts as TextToSpeech)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TextToSpeechDemoViewModel::class.java)

        val transaction = supportFragmentManager.beginTransaction()
        val fragment = TextToSpeechDemoFragment() as Fragment
        transaction.add(R.id.container, fragment)
        transaction.commit()
    }
}
