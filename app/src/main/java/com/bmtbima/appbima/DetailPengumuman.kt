package com.bmtbima.appbima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bmtbima.appbima.adapter.PengumumanItem
import com.bmtbima.appbima.databinding.ActivityDetailPengumumanBinding

class DetailPengumuman : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPengumumanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailPengumumanBinding.inflate(layoutInflater)


        setContentView(binding.root)

        val itemPengumuman = intent.getParcelableExtra<PengumumanItem>("item_pengumuman")
        
        binding.judulPengumuman.text =itemPengumuman?.judul
        binding.isiPengumuman.text = itemPengumuman?.lampiran
    }
}