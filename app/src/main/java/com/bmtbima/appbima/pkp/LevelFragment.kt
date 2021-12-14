package com.bmtbima.appbima.pkp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bmtbima.appbima.R
import com.bmtbima.appbima.databinding.FragmentLevelBinding


class LevelFragment : Fragment(R.layout.fragment_level){
    private lateinit var binding: FragmentLevelBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLevelBinding.bind(view)

        //prepare data untuk level

        val level = mutableListOf<String>()
        level.add("Teller")
        level.add("Kabag Operasional")
        level.add("Staff Pemasaran")
        level.add("Kepala Cabang")
        level.add("Manager")

        val levelAdapter = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1, level)
        levelAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        binding.spinnerLevel.adapter = levelAdapter


        val user = mutableListOf<String>()
        user.add("Zaki")
        user.add("April")
        user.add("Mamad")

        val userAdapter = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1, user)
        userAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        binding.spinnerKaryawan.adapter=userAdapter



        //add listener untuk item  selected spinner level

        binding.spinnerLevel.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = level.get(position)
                Toast.makeText(requireActivity(),selectedItem, Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }


    }


}

