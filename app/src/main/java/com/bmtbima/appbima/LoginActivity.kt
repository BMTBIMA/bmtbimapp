package com.bmtbima.appbima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.bmtbima.appbima.databinding.ActivityLoginBinding
import com.bmtbima.appbima.utils.Constant
import com.pixplicity.easyprefs.library.Prefs

class LoginActivity : AppCompatActivity() {
    //ini digunakan untuk mengakses id-id yang ada didalam activity login.xml
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(checkedLogin()){
            Intent(this, LandingActivity::class.java).apply{
                startActivity(this)
            }
            finish()
        }

        //memasukkan activity_login.xml kedalam kotlin nya
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //kasih event klik ke tombol masuk
        binding.btnMasuk.setOnClickListener {

            val userid = binding.UserId.text.toString()//ambil nilai dari edittext user id
            val password = binding.password.text.toString() //ambil nilai dari edittext password

            if (userid.isEmpty() || password.isEmpty()) {
                //action kalo user id dan password kosong
                Toast.makeText(this, "Nama Id dan Sandi harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                //action kalo user id dan password berisi
                    // intent untuk memindahkan dari 1 activity ke activity lain
                        Prefs.putString(Constant.USERID, userid)
                        Prefs.putString(Constant.PASSWORD,password)
                startActivity(Intent(this,LandingActivity::class.java))


            }
        }

    }

    private fun checkedLogin():Boolean{
        return Prefs.contains(Constant.USERID)

    }
}