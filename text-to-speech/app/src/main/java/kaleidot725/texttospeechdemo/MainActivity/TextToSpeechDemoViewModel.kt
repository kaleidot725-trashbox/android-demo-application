package kaleidot725.texttospeechdemo.MainActivity

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.speech.tts.TextToSpeech
import java.io.Console

class TextToSpeechDemoViewModel(tts : TextToSpeech) : ViewModel() {
    val tts : TextToSpeech = tts
    val text: MutableLiveData<String> = MutableLiveData()

    init {
        text.value = "サンプルテキスト"
    }

    fun speech(){
        tts.speak(text.value, TextToSpeech.QUEUE_FLUSH,null)
    }
}