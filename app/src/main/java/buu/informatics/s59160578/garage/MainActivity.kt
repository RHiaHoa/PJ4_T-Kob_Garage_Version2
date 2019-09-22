package buu.informatics.s59160578.garage

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.adapters.TextViewBindingAdapter.setText

class MainActivity: AppCompatActivity() {
    private val carInfo= Array(3){CarInfo()}
    private var ind = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.C1).setOnClickListener {
            ind = 0
            updateEditText(it)
        }

        findViewById<Button>(R.id.C2).setOnClickListener {
            ind = 1
            updateEditText(it)
        }

        findViewById<Button>(R.id.C3).setOnClickListener {
            ind = 2
            updateEditText(it)
        }

        findViewById<Button>(R.id.button_cancel).setOnClickListener {
            delDataCar(it)
        }

        findViewById<Button>(R.id.button_confirm).setOnClickListener {
            updateDataCar(it)
        }


    }

    private fun updateDataCar(view: View){
        carInfo[ind]?.idCar = findViewById<EditText>(R.id.editText_id).text.toString()
        carInfo[ind]?.brand = findViewById<EditText>(R.id.editText_brand).text.toString()
        carInfo[ind]?.name = findViewById<EditText>(R.id.editText_name).text.toString()
        when(ind){
            0 -> findViewById<Button>(R.id.C1).text = findViewById<EditText>(R.id.editText_id).text.toString()
            1 -> findViewById<Button>(R.id.C2).text = findViewById<EditText>(R.id.editText_id).text.toString()
            2 -> findViewById<Button>(R.id.C3).text = findViewById<EditText>(R.id.editText_id).text.toString()
        }
        invalidateOptionsMenu()
    }

    private fun delDataCar(view: View){
        carInfo[ind]?.idCar = ""
        carInfo[ind]?.brand = ""
        carInfo[ind]?.name = ""
        when(ind){
            0 -> findViewById<Button>(R.id.C1).text = "ว่าง"
            1 -> findViewById<Button>(R.id.C2).text = "ว่าง"
            2 -> findViewById<Button>(R.id.C3).text = "ว่าง"
        }
        invalidateOptionsMenu()
    }

    private fun updateEditText(view: View){
        findViewById<EditText>(R.id.editText_id).setText(carInfo[ind].idCar)
        findViewById<EditText>(R.id.editText_brand).setText(carInfo[ind].brand)
        findViewById<EditText>(R.id.editText_name).setText(carInfo[ind].name)
    }


}
