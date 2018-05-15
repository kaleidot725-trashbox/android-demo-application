package kaleidot725.texttospeechdemo

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.speech.tts.TextToSpeech
import kaleidot725.texttospeechdemo.MainActivity.TextToSpeechDemoViewModel
import java.lang.Class

class ViewModelFactory(tts : TextToSpeech) : ViewModelProvider.Factory{
    val tts : TextToSpeech = tts

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == TextToSpeechDemoViewModel::class.java)
            return TextToSpeechDemoViewModel(tts) as T

        throw IllegalArgumentException("Unknown ViewModel class : ${modelClass.name}")
    }
}
