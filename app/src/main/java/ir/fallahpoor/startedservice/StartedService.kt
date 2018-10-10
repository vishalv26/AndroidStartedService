package ir.fallahpoor.startedservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

class StartedService : Service() {

    private val tag = StartedService::class.java.simpleName
    private val timeToSleepInMillis = 5000L

    override fun onCreate() {
        log("onCreate")
    }

    private fun log(message: String) {
        Log.d(tag, message + " (thread = " + Thread.currentThread().name.toUpperCase() + ")")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        log("onStartCommand")
        /* Spawn a thread to run your long running operation here.
         * The following block of code uses 'thread construct' to launch a worker thread to run
         * a simulated long running operation */
        thread {
            longRunningOperation()
        }

        return Service.START_NOT_STICKY
    }

    private fun longRunningOperation() {
        log("longRunningOperation")
        Thread.sleep(timeToSleepInMillis)
    }

    override fun onBind(intent: Intent?): IBinder? {
        // Simple return null because we have a 'started service' not a 'bound service'
        return null
    }

    override fun onDestroy() {
        log("onDestroy")
    }

}