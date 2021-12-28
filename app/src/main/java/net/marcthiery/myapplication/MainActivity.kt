package net.marcthiery.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    //private var counter : Int = 0
    private var calculationResult : Int = 0
    private var score : Int = 0

    private lateinit var adapter : OperationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val title: String = "Hello Kotlin"
        var age: Int = 55
        var size : Float = 1.78F
        var pi : Double = 3.14619
        var date : Long = Date().time
        var caractere : Char = 'a'*/
        //val firstNumber: Int = Random().nextInt(100)
        //val secondNumber : Int = Random().nextInt(100)
        //calculationResult = firstNumber + secondNumber

        //findViewById<TextView>(R.id.mainTitle).text = "title : $title \n age : $age \n size : $size \n pi : $pi \n date : $date \n caractére : $caractere"
        //findViewById<TextView>(R.id.mainTitle).text = resources.getString(R.string.title, title, age, size, pi)
        //findViewById<TextView>(R.id.mainTitle).text = "$firstNumber + $secondNumber"
        generateCalculation("First calcul")
        findViewById<TextView>(R.id.scoreTv).text = "Score : $score"

        adapter = OperationAdapter()
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.validateButton).setOnClickListener {
            //counter++
            //findViewById<TextView>(R.id.mainTitle).text = counter.toString()
            var answer : String = findViewById<EditText>(R.id.answer).text.toString()
            if (answer == calculationResult.toString()) {
                score++
                adapter.add(mainTitle.text.toString() + " = " + answer)
                findViewById<TextView>(R.id.scoreTv).text = "Score : $score"
                generateCalculation("Other calcul")
                Toast.makeText(this, "Right answer", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show()
            }
        }
    }

     private fun generateCalculation(prefix : String) {
        val firstNumber: Int = Random().nextInt(100)
        val secondNumber : Int = Random().nextInt(100)
        calculationResult = firstNumber + secondNumber
        findViewById<TextView>(R.id.mainTitle).text = "$prefix: $firstNumber + $secondNumber"
    }

    class OperationAdapter : RecyclerView.Adapter<OperationAdapter.OperationViewHolder>() {
        private val operations : ArrayList<String> = arrayListOf<String>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationViewHolder {
            TODO("Not yet implemented")
            return OperationViewHolder(LayoutInflater.from(parent.context), parent)
        }

        override fun onBindViewHolder(holder: OperationViewHolder, position: Int) {
            TODO("Not yet implemented")
            holder.bind(operations[position],)
        }

        override fun getItemCount(): Int = operations.size

        fun addAll(operation : String) {
            operations.add(0, operation)
            notifyItemInserted(0)
        }

        class OperationViewHolder(inflater: LayoutInflater, viewGroup : ViewGroup) :
            RecyclerView.ViewHolder(inflater.inflate(R.layout.item_operation, viewGroup, false)) {
            fun bind(operation : String) {
                itemView.operationTV.text = operation
            }
        }


    }


}