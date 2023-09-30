package com.example.carrotmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carrotmarket.databinding.FragmentActiveAlarmBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ActiveAlarmFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActiveAlarmFragment : Fragment() {
    lateinit var binding : FragmentActiveAlarmBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentActiveAlarmBinding.inflate(layoutInflater,container,false)

        binding.ivAlarmSelectKeyword.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.frm_alarm_list,KeywordAlarmFragment()).commit()
        }

        return binding.root
    }
}