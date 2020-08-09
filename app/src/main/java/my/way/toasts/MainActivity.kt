package my.way.toasts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        info("Info log")
        debug(5)
        debug { "Each log can be written in either of these forms" }
        warn(null)
        verbose { "Verbose" }
        wtf("Kotlin Androidly Tutorial")



        btnShortToast.setOnClickListener {
            toast("Hello Anko Commons")
            toast(R.string.app_name)
        }

        btnLongToast.setOnClickListener {
            longToast("Long!")
        }

        btnSimpleAlertDialog.setOnClickListener {
            alert("You have a message!", "Android Anko Alert") {
                yesButton { toast("Yes") }
                noButton {}
                neutralPressed("Maybe") {}
            }.show()
        }

        btnAdvAlertDialog.setOnClickListener {

            alert("Anko Common Alert") {
                title = "Title"
                yesButton { toast("Yes") }
                noButton { }
                icon = ContextCompat.getDrawable(this@MainActivity, R.mipmap.ic_launcher)!!
                onCancelled {
                    val dialog = alert(Appcompat) {
                        title = "Anko Alerts"
                        message = "Don't press outside the dialog to cancel me again :)"
                        okButton { toast(android.R.string.ok) }

                    }.build()

                    with(dialog)
                    {
                        show()
                        getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                    }
                }

            }.show()
        }


        btnAlertDialogWithList.setOnClickListener {

            val languages = listOf("Java", "Python", "Kotlin", "Swift")
            selector("Your favourite programming language?", languages) { dialogInterface, i ->
                toast("You're favourite language is ${languages[i]}, right?")
            }


        }

        btnDoAsync.setOnClickListener {

            doAsync {

                Thread.sleep(2000)

                uiThread {
                    toast("This work is done after 2 seconds")
                }
            }
        }


        btnIntent.setOnClickListener {

            startActivity<SecondActivity>("name" to "Androidly", "age" to 1)

        }


    }
}

