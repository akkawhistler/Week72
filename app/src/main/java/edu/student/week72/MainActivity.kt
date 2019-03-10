package edu.student.week72
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bind objects
        var txtMessage = findViewById<EditText>(R.id.txtMessage)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        //focus on txtMessage
        txtMessage.requestFocus()
        //submit button action
        btnSubmit.setOnClickListener {
            //show message by concatenating string and ${varible}
            //add toast mssg
            Toast.makeText(this,"The Message is: ${txtMessage.text.toString()}",Toast.LENGTH_LONG) .show()
            //hide keyboard
            hideKeyboard()
            //clear txtMessage
            txtMessage.setText("")
            //set focus back on txtMesssage
            txtMessage.requestFocus()
        }
        //fire hidekeyboard when taps blank canvas
        //place before end fun onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }
    }
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            //TODO: handle exception
        }
    }
}
