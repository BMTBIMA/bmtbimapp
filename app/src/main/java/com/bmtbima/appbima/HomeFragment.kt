package com.bmtbima.appbima

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmtbima.appbima.adapter.AdapterPengumuman
import com.bmtbima.appbima.adapter.PengumumanItem
import com.bmtbima.appbima.databinding.FragmentHomeBinding
import com.bmtbima.appbima.pkp.PkpActivity


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var adapterPengumuman: AdapterPengumuman
    private lateinit var binding: FragmentHomeBinding

    //ini dipanggil ketika layout itu sudah tampil
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        val listPengumuman = mutableListOf<PengumumanItem>()
        val pengumumanItem1 = PengumumanItem()
        pengumumanItem1.gambar = R.drawable.ic_home
        pengumumanItem1.judul = "Contoh Judul Pengumuman"
        pengumumanItem1.lampiran = "Contoh Pengumuman lampiran"

        listPengumuman.add(pengumumanItem1)


        adapterPengumuman = AdapterPengumuman(onItemClick = {
            Intent(requireActivity(), DetailPengumuman::class.java).apply {
                putExtra("item_pengumuman", it)
                startActivity(this)
            }
        })
        binding.rvPengumuman.adapter = adapterPengumuman
        binding.rvPengumuman.layoutManager = LinearLayoutManager(requireActivity())

        adapterPengumuman.addItem(listPengumuman)
        //tombol PKP
        binding.pkp.setOnClickListener{
            Intent(requireActivity(),PkpActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

}