package com.example.zlhhapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_2.*

class Fragment2 : Fragment(), AdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        model.messages.observe(viewLifecycleOwner) {
            it?.let {
                recycler.adapter = ResultTextAdapter(it.toMutableList(), this)
            }
        }
    }

    override fun passData(text: String) {
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        model.removeMessage(text)
    }
}
