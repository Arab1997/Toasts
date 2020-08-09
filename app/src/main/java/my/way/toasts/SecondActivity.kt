package my.way.toasts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_second.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.email
import org.jetbrains.anko.share

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnBrowseUrl.setOnClickListener {
            browse("https://www.androidly.net")
        }
        btnSendEmail.setOnClickListener {
            email("anupamchugh@gmail.com (mailto:anupamchugh@gmail.com)", "Test Androidly", "Message text From Androidly Application")
        }
        btnShare.setOnClickListener {
            val number = 123
            share("Hello $number", "Copy")
        }
    }
}