package ir.fallahpoor.startedservice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.start_service_button).setOnClickListener {
            startService(Intent(this, StartedService::class.java))
            showToast("Service started")
        }

        findViewById<Button>(R.id.stop_service_button).setOnClickListener {
            stopService(Intent(this, StartedService::class.java))
            showToast("Service stopped")
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

}
