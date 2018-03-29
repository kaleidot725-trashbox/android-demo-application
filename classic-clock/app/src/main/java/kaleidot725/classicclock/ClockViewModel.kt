package kaleidot725.classicclock
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.time.LocalDateTime
import java.util.*

/**
 * Created by kaleidot725 on 2018/03/14.
 */
class ClockViewModel : ViewModel {
    public val mLocalDateTime: MutableLiveData<LocalDateTime> = MutableLiveData()
    val mTimer : Timer = Timer()

    constructor() {
        mTimer.schedule(object : TimerTask() {
           override  fun run() {
                mLocalDateTime.postValue(LocalDateTime.now())
           }
        }, 1, 1)
    }
}