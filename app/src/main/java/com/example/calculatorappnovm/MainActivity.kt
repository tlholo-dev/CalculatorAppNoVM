package com.example.calculatorappnovm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.calculatorappnovm.utils.Operations

class MainActivity : AppCompatActivity() {

    private var result: String = ""
    //private var resultString: String = ""
    private var firstNum: Double = 0.0
    private var secondNum: Double = 0.0
    private var firstNumericValueClicked = 0.0
    private var secondNumericValueClicked = 0.0

    private var operationToPerform: Char = '0'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enteredTextView = findViewById<TextView>(R.id.textView3)
        enteredTextView.text = ""

        val resultTextView = findViewById<TextView>(R.id.textViewResult)
        resultTextView.text = ""

        val allClearButton = findViewById<Button>(R.id.allClearButton)
        allClearButton?.setOnClickListener {
            enteredTextView.text = ""

            firstNum = 0.0
            secondNum = 0.0
            resultTextView.text = ""
        }

        val backspaceButton = findViewById<Button>(R.id.backspaceButton)
        backspaceButton?.setOnClickListener {
            enteredTextView.text.removeRange(enteredTextView.text.lastIndex, enteredTextView.text.lastIndex)
        }

        val divideButton = findViewById<Button>(R.id.divideButton)
        divideButton?.setOnClickListener {
            operationToPerform = '/'

            operationToPerform(enteredTextView)
        }

        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        multiplyButton?.setOnClickListener {
            operationToPerform = 'X'

            operationToPerform(enteredTextView)
        }

        val addButton = findViewById<Button>(R.id.plusButton)
        addButton?.setOnClickListener {
            operationToPerform = '+'

            operationToPerform(enteredTextView)
        }

        val minusButton = findViewById<Button>(R.id.minusButton)
        minusButton?.setOnClickListener {
            operationToPerform = '-'

            operationToPerform(enteredTextView)
        }

        val sevenButton = findViewById<Button>(R.id.sevenButton)
        sevenButton?.setOnClickListener {
            firstNumericValueClicked = 7.0
            enteredTextView.append(firstNumericValueClicked.toString())

            firstOrSecondNum()
        }

        val eightButton = findViewById<Button>(R.id.eightButton)
        eightButton?.setOnClickListener {
            firstNumericValueClicked = 8.0
            enteredTextView.append(firstNumericValueClicked.toString())

            firstOrSecondNum()
        }

        val nineButton = findViewById<Button>(R.id.nineButton)
        nineButton?.setOnClickListener {
            firstNumericValueClicked = 9.0
            enteredTextView.append(firstNumericValueClicked.toString())

            firstOrSecondNum()
        }

        val fourButton = findViewById<Button>(R.id.fourButton)
        fourButton?.setOnClickListener {
            firstNumericValueClicked = 4.0
            enteredTextView.append(firstNumericValueClicked.toString())

            firstOrSecondNum()
        }

        val fiveButton = findViewById<Button>(R.id.fiveButton)
        fiveButton?.setOnClickListener {
            firstNumericValueClicked = 5.0
            enteredTextView.append(firstNumericValueClicked.toString())

            firstOrSecondNum()
        }

        val sixButton = findViewById<Button>(R.id.sixButton)
        sixButton?.setOnClickListener {
            firstNumericValueClicked = 6.0
            enteredTextView.append(firstNumericValueClicked.toString())

            firstOrSecondNum()
        }

        val threeButton = findViewById<Button>(R.id.threeButton)
        threeButton?.setOnClickListener {
            firstNumericValueClicked = 3.0
            enteredTextView.append(firstNumericValueClicked.toString())

            firstOrSecondNum()
        }

        val twoButton = findViewById<Button>(R.id.twoButton)
        twoButton?.setOnClickListener {
            firstNumericValueClicked = 2.0
            enteredTextView.append(firstNumericValueClicked.toString())

            firstOrSecondNum()
        }

        val oneButton = findViewById<Button>(R.id.oneButton)
        oneButton?.setOnClickListener {
            firstNumericValueClicked = 1.0
            enteredTextView.append(firstNumericValueClicked.toString())

            firstOrSecondNum()
        }

        val equalsButton = findViewById<Button>(R.id.equalsButton)
        equalsButton?.setOnClickListener {
          switch(enteredTextView, resultTextView)
        }
    }

    private fun switch(showOperation: TextView, showResult: TextView){
        when(operationToPerform){
            Operations.ADD.operation -> {

                result = (firstNum + secondNum).toString()

                showResult.text = result
            }

            Operations.SUBTRACT.operation ->{

                result = (firstNum - secondNum).toString()

                showResult.text = result
            }

            Operations.DIVIDE.operation -> {
                result = (firstNum / secondNum).toString()

                showResult.text = result
            }

            Operations.MULTIPLY.operation -> {
                result = (firstNum * secondNum).toString()

                showResult.text = result
            }
        }
    }

    private fun operationToPerform(textView: TextView)
    {
        if(operationToPerform == Operations.ADD.operation){
            result = (firstNum + secondNum).toString()

            textView.append(Operations.ADD.operation.toString())
        }
        if(operationToPerform == Operations.SUBTRACT.operation){
            result = (firstNum - secondNum).toString()

            textView.append(Operations.SUBTRACT.operation.toString())
        }
        if(operationToPerform == Operations.DIVIDE.operation){
            result = (firstNum / secondNum).toString()

            textView.append(Operations.DIVIDE.operation.toString())
        }
        if(operationToPerform == Operations.MULTIPLY.operation){
            result = (firstNum * secondNum).toString()

            textView.append(Operations.MULTIPLY.operation.toString())
        }
    }

    private fun firstOrSecondNum(){
        if(firstNum == 0.0){
            firstNum = firstNumericValueClicked
            secondNum = 0.0
        } else{
            secondNum = firstNumericValueClicked
        }

        if (firstNum != 0.0 && secondNum == 0.0)
        {
            secondNum = secondNumericValueClicked
        }
    }

    private fun resultTextView(textView: TextView){

    }
}