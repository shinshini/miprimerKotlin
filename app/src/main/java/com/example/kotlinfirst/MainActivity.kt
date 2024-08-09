package com.example.kotlinfirst

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinfirst.models.Productos

class MainActivity : AppCompatActivity() {
    lateinit var btnCalcular : Button
    lateinit var txtPrecio : EditText
    lateinit var tvResult: TextView
    lateinit var spList: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        //codigo
        cargarR()
        estadoOnclick()

        //cargar lista de datos en spinner
        val listaPaises = arrayOf("USA", "BOL", "ESP")
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaPaises)
        spList.adapter = adaptador1
        
    }
    fun cargarR (){
        btnCalcular = findViewById(R.id.btnCalcularIva)
        txtPrecio = findViewById(R.id.txtProducto)
        tvResult = findViewById(R.id.tvResultado)
        spList = findViewById(R.id.spPaises)
    }
    fun estadoOnclick(){
        btnCalcular.setOnClickListener(){
            val laptop = Productos("laptop",txtPrecio.text.toString().toDouble())
            //val datosRe : Double = laptop.calIva()

            when(spList.selectedItem.toString()){
                "USA"->tvResult.text = laptop.calIva(0.03).toString()
                "BOL"->tvResult.text = laptop.calIva(0.13).toString()
                "ESP"->tvResult.text = laptop.calIva(0.05).toString()
            }
        }
    }
    /*//funcion para clacular iva
    fun calIva(costo :Double):Double{
        val total:Double = costo*0.03
        return total
    }*/
}