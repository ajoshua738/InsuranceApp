package my.edu.tarc.insuranceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insuranceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            var basic: Int = 0
            var extra: Int = 0
            var total: Int = 0

            //Get age group
            val age = binding.spinnerAge.selectedItemPosition

            basic = when(age) {
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                4 -> 150
                5 -> 150
                else -> 0

            }


            //Get the gender
            val gender = binding.radioGroupGender.checkedRadioButtonId
            if(gender == binding.radioButtonMale.id)
            {
                //Calculate the extra premium for male
                extra = when(age) {
                    0 -> 0
                    1 -> 50
                    2 -> 100
                    3 -> 150
                    4 -> 200
                    5 -> 200
                    else -> 0

                }


            }

            //Get the smoker status
            val smoker = binding.checkBoxSmoker.isChecked
            if(smoker)
            {
                //Calculate the extra premium
                extra = when(age) {
                    0 -> 0
                    1 -> extra + 100
                    2 -> extra + 150
                    3 -> extra + 200
                    4 -> extra + 250
                    5 -> extra + 300
                    else -> 0

                }
            }


            total = basic + extra
            binding.myPremium = Premium(basic, extra, total)



        }

        binding.buttonReset.setOnClickListener {
            binding.myPremium = Premium()
        }



    }
}