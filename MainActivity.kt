package www.abhishek.com.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


/** * Created by abhishek * https://abhiandroidknowledge.blogspot.com/2018/04/login-screen-handle-with-text-watcher.html
 * */
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialise()
    }

    fun initialise() {
        et_username.addTextChangedListener(Textwatcher(et_username))
        et_password.addTextChangedListener(Textwatcher(et_password))
    }

    fun login(v: View) {
        validate()
    }

    fun validate() {
        var userName = et_username.text.toString()
        var password = et_password.text.toString()


if (userName.equals("") || userName.equals(null)) {
usernamewrapper.error = "Username is not null"            

usernamewrapper.isErrorEnabled = true        

} else if (password.equals("") || password.equals(null)) {
passwordwrapper.error = " Password is not null"            

passwordwrapper.isErrorEnabled = true        

} else {
usernamewrapper.isErrorEnabled = false            

passwordwrapper.isErrorEnabled = false            

Toast.makeText(this, " Login successfully : username-> " 

+ userName + " password-> " 

+ password, 

Toast.LENGTH_SHORT).show()
        }
    }

    inner class Textwatcher(var v: View) : TextWatcher {

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //do something        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //do something        }

        override fun afterTextChanged(s: Editable?) {
            when (v.getId()) {
                R.id.et_username -> if (!s.isNullOrEmpty()) {
                    usernamewrapper.setErrorEnabled(false)
                }

                R.id.et_password -> if (!s.isNullOrEmpty()) {
                    passwordwrapper.setErrorEnabled(false)
                }
            }
        }

    }

}


