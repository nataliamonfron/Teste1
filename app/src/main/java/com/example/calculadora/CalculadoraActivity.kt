package com.example.calculadora

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityCalculadoraBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalculadoraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculadoraBinding

    private var entradaAtual = StringBuilder()
    private var operadorAtual = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonVoltarCalculadora.setOnClickListener{
            startActivity(Intent(this, MenuActivity::class.java))
        }

        binding.button0.setOnClickListener{AcrescentarUmaExpressao("0", limpar_dados = true)}
        binding.button1.setOnClickListener{AcrescentarUmaExpressao("1", limpar_dados = true)}
        binding.button2.setOnClickListener{AcrescentarUmaExpressao("2", limpar_dados = true)}
        binding.button3.setOnClickListener{AcrescentarUmaExpressao("3", limpar_dados = true)}
        binding.button4.setOnClickListener{AcrescentarUmaExpressao("4", limpar_dados = true)}
        binding.button5.setOnClickListener{AcrescentarUmaExpressao("5", limpar_dados = true)}
        binding.button6.setOnClickListener{AcrescentarUmaExpressao("6", limpar_dados = true)}
        binding.button7.setOnClickListener{AcrescentarUmaExpressao("7", limpar_dados = true)}
        binding.button8.setOnClickListener{AcrescentarUmaExpressao("8", limpar_dados = true)}
        binding.button9.setOnClickListener{AcrescentarUmaExpressao("9", limpar_dados = true)}

        binding.buttonSomar.setOnClickListener{AcrescentarUmaExpressao("+", limpar_dados = false)}
        binding.buttonSubtrair.setOnClickListener{AcrescentarUmaExpressao("-", limpar_dados = false)}
        binding.buttonMultiplicar.setOnClickListener{AcrescentarUmaExpressao("*", limpar_dados = false)}
        binding.buttonDividir.setOnClickListener{AcrescentarUmaExpressao("/", limpar_dados = false)}

        binding.buttonLimpar.setOnClickListener {
            binding.textExpressao.text = ""
            binding.textResultado.text = ""
        }

        binding.buttonIgual.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(binding.textExpressao.text.toString()).build()

                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if (resultado == longResult.toDouble()){
                    binding.textResultado.text = longResult.toString()
                } else {
                    binding.textResultado.text = resultado.toString()
                }

            } catch (e: Exception) {

            }
        }
    }

    fun AcrescentarUmaExpressao(string: String, limpar_dados: Boolean){
        if (binding.textResultado.text.isNotEmpty()){
            binding.textExpressao.text = ""
        }

        if(limpar_dados){
            binding.textResultado.text = ""
            binding.textExpressao.append(string)

        } else {
            binding.textExpressao.append(binding.textResultado.text)
            binding.textExpressao.append(string)
            binding.textResultado.text = ""
        }

    }

}