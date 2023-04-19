
import android.os.Handler
import android.os.Looper

interface Runnable1 {
    fun run()
}
interface ran {
    fun mun()
}
open class tbo:ran {
    override fun mun() {

    }

}
class abc{
lateinit var handler: Handler
lateinit var runnable: Runnable
lateinit var muno: ran
fun main(){
    handler=Handler(Looper.getMainLooper())
    loop()
}
fun loop(){
        runnable= Runnable{
            handler.postDelayed(runnable,1000)
        }
        println("hello world")
        val muno=object : ran{
            override fun mun() {

            }
        }
}
}