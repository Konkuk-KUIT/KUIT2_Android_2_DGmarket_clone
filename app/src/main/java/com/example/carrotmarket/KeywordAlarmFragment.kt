package com.example.carrotmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carrotmarket.databinding.FragmentKeywordAlarmBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KeywordAlarmFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KeywordAlarmFragment : Fragment() {
    lateinit var binding : FragmentKeywordAlarmBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentKeywordAlarmBinding.inflate(layoutInflater,container,false)

        /*binding.ivAlarmSelectActive.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.frm_alarm_list,ActiveAlarmFragment()).commit()
        }*/

        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initKeymordAlarm()
    }

    private fun initKeymordAlarm() {
        TODO("Not yet implemented")
    }*/
}