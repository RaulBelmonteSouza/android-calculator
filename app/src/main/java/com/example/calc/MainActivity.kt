package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    internal lateinit var zeroBtn: AppCompatButton
    internal lateinit var umBtn: AppCompatButton
    internal lateinit var doisBtn: AppCompatButton
    internal lateinit var tresBtn: AppCompatButton
    internal lateinit var quatroBtn: AppCompatButton
    internal lateinit var cincoBtn: AppCompatButton
    internal lateinit var seisBtn: AppCompatButton
    internal lateinit var seteBtn: AppCompatButton
    internal lateinit var oitoBtn: AppCompatButton
    internal lateinit var noveBtn: AppCompatButton
    internal lateinit var somaBtn: AppCompatButton
    internal lateinit var subtracaoBtn: AppCompatButton
    internal lateinit var multiplicacaoBtn: AppCompatButton
    internal lateinit var divisaoBtn: AppCompatButton
    internal lateinit var igualBtn: AppCompatButton
    internal lateinit var pontoBtn: AppCompatButton
    internal lateinit var limparBtn: AppCompatButton
    internal lateinit var backspaceBtn: AppCompatButton
    internal lateinit var expressaoTxt: TextView
    internal lateinit var resultadoTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        zeroBtn = findViewById<AppCompatButton>(R.id.zeroBtn)
        umBtn = findViewById<AppCompatButton>(R.id.umBtn)
        doisBtn = findViewById<AppCompatButton>(R.id.doisBtn)
        tresBtn = findViewById<AppCompatButton>(R.id.tresBtn)
        quatroBtn = findViewById<AppCompatButton>(R.id.quatroBtn)
        cincoBtn = findViewById<AppCompatButton>(R.id.cincoBtn)
        seisBtn = findViewById<AppCompatButton>(R.id.seisBtn)
        seteBtn = findViewById<AppCompatButton>(R.id.seteBtn)
        oitoBtn = findViewById<AppCompatButton>(R.id.oitoBtn)
        noveBtn = findViewById<AppCompatButton>(R.id.noveBtn)
        somaBtn = findViewById<AppCompatButton>(R.id.somaBtn)
        subtracaoBtn = findViewById<AppCompatButton>(R.id.subtracaoBtn)
        multiplicacaoBtn = findViewById<AppCompatButton>(R.id.multiplicacaoBtn)
        divisaoBtn = findViewById<AppCompatButton>(R.id.divisaoBtn)
        igualBtn = findViewById<AppCompatButton>(R.id.igualBtn)
        pontoBtn = findViewById<AppCompatButton>(R.id.pontoBtn)
        limparBtn = findViewById<AppCompatButton>(R.id.limparBtn)
        backspaceBtn = findViewById<AppCompatButton>(R.id.backspaceBtn)
        expressaoTxt = findViewById<TextView>(R.id.expressaoTxt)
        resultadoTxt = findViewById<TextView>(R.id.resultadoTxt)


        zeroBtn.setOnClickListener {
            acrescentarExpressao("0", true)
        }

        umBtn.setOnClickListener {
            acrescentarExpressao("1", true)
        }

        doisBtn.setOnClickListener {
            acrescentarExpressao("2", true)
        }

        tresBtn.setOnClickListener {
            acrescentarExpressao("3", true)
        }

        quatroBtn.setOnClickListener {
            acrescentarExpressao("4", true)
        }

        cincoBtn.setOnClickListener {
            acrescentarExpressao("5", true)
        }

        seisBtn.setOnClickListener {
            acrescentarExpressao("6", true)
        }

        seteBtn.setOnClickListener {
            acrescentarExpressao("7", true)
        }

        oitoBtn.setOnClickListener {
            acrescentarExpressao("8", true)
        }

        noveBtn.setOnClickListener {
            acrescentarExpressao("9", true)
        }

        pontoBtn.setOnClickListener {
            acrescentarExpressao(".", true)
        }

        somaBtn.setOnClickListener {
            acrescentarExpressao("+", true)
        }

        subtracaoBtn.setOnClickListener {
            acrescentarExpressao("-", true)
        }

        multiplicacaoBtn.setOnClickListener {
            acrescentarExpressao("X", true)
        }

        divisaoBtn.setOnClickListener {
            acrescentarExpressao("/", true)
        }

        limparBtn.setOnClickListener {
            resultadoTxt.text = ""
            expressaoTxt.text = ""
        }

        backspaceBtn.setOnClickListener {
            if (expressaoTxt.text.isNotEmpty()) {
                expressaoTxt.text = expressaoTxt.text.substring(0, expressaoTxt.text.length - 1)
            }
            resultadoTxt.text = ""
        }

        igualBtn.setOnClickListener {
            var exp = expressaoTxt.text
                .toString()
                .replace(" ", "")
            if(exp.length > 2) {
                val resultado: Double = calcula(exp);
                resultadoTxt.text = resultado.toString()
            }
        }



    }

    private fun calcula(text: String?): Double {
        if(text != null) {
            if (text.contains("+")) {
                val split = text.split("+")
                val op1 = split[0]
                val op2 = split[1]
                return op1.toDouble() + op2.toDouble()
            }
            if (text.contains("-")) {
                val split = text.split("-")
                val op1 = split[0]
                val op2 = split[1]
                return op1.toDouble() - op2.toDouble()
            }
            if (text.contains("X")) {
                val split = text.split("X")
                val op1 = split[0]
                val op2 = split[1]
                return op1.toDouble() * op2.toDouble()
            }
            if (text.contains("/")) {
                val split = text.split("/")
                val op1 = split[0]
                val op2 = split[1]
                return op1.toDouble() / op2.toDouble()
            }
        }
        return 0.0;
    }

    fun acrescentarExpressao(str: String, limpar: Boolean) {
        if(resultadoTxt?.text.equals("")) {
            expressaoTxt?.text = " "
        }
        if(limpar) {
            resultadoTxt?.text = " "
            expressaoTxt?.append(str)
        } else {
            expressaoTxt?.append(resultadoTxt?.text)
            expressaoTxt?.append(str)
            resultadoTxt?.text = " ";
        }
    }


}