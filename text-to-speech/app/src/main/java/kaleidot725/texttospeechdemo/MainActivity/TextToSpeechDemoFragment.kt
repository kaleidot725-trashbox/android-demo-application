package kaleidot725.texttospeechdemo.MainActivity

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kaleidot725.texttospeechdemo.R
import kaleidot725.texttospeechdemo.databinding.FragmentTextToSpeechDemoBinding

class TextToSpeechDemoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_text_to_speech_demo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        val viewModel = ViewModelProviders.of(activity as TextToSpeechDemoActivity).get(TextToSpeechDemoViewModel::class.java)
        val binding : FragmentTextToSpeechDemoBinding = DataBindingUtil.setContentView(activity as Activity, R.layout.fragment_text_to_speech_demo)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        activity?.findViewById<Button>(R.id.SpeechButton)?.setOnClickListener {
            viewModel.speech()
        }

        activity?.findViewById<EditText>(R.id.SpeechText)?.addTextChangedListener (
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    viewModel.text.postValue(p0.toString())
                }

                override fun afterTextChanged(editable: Editable?) {

                }
            }
        )

        super.onActivityCreated(savedInstanceState)
    }
}
