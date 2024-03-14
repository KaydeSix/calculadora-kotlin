import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.R

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var resultTextView: TextView
    private val number2 = 2.0 // é possivel alterar o valor ou pega-lo de outro editText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        resultTextView = findViewById(R.id.resultTextView)
    }

    fun performOperation(view: View) {
        val number1 = editText.text.toString().toDoubleOrNull()
        val result = when (view.id) {
            R.id.btnAdd -> number1?.plus(number2)
            R.id.btnSubtract -> number1?.minus(number2)
            R.id.btnMultiply -> number1?.times(number2)
            R.id.btnDivide -> number1?.div(number2)
            else -> null
        }

        if (view.id == R.id.btnDivide && number2 == 0.0) {
            displayResult(null, "Não é possível dividir por zero")
        } else {
            displayResult(result, null)
        }
    }

    private fun displayResult(result: Double?, error: String?) {
        if (error != null) {
            resultTextView.text = error
        } else {
            resultTextView.text = "Resultado: ${result ?: "Entrada inválida"}"
        }
    }
}
