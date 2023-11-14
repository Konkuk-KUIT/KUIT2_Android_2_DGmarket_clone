package com.example.carrotmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentExerciseAlarmBinding
import com.example.carrotmarket.databinding.FragmentKeywordAlarmBinding

class KeywordAlarmFragment : Fragment() {
    private lateinit var binding : FragmentKeywordAlarmBinding
    private var keywordAdapter : KeywordAlarmAdapter?= null
    private var keywordList : ArrayList<KeywordAlarmDataClass> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKeywordAlarmBinding.inflate(layoutInflater)

        initInfoExample()
        initKeywordRecyclerView()

        return binding.root
    }

    private fun initInfoExample() {
        keywordList.addAll(
            arrayListOf(
                KeywordAlarmDataClass("황졍민님, 아직 당근마켓 새 이름을 모르시나요?","새로워진 당신 근처의 당근을 만나보세요","하루 전"),
                KeywordAlarmDataClass("💌 10월 가계부가 도착했어요!","#당근 #당근가계부 #자원재순환 #따뜻한 거래","3일 전"),
                KeywordAlarmDataClass("황졍민님, 동네생활에 댓글을 작성하셨네요!","더 많은 활동을 통해 '동네 활동가'에 도전해보세요.","3주전"),
                KeywordAlarmDataClass("황졍민님, 동네생활 이웃에게 공감을 받으셨네요!","더 많은 활동을 통해 '동네 활동가'에 도전해보세요","4주전"),
                KeywordAlarmDataClass("🎉황졍민님, 축하합니다! 동네 산책 배지를 획득했어요. 지금 확인해보세요."," ","5주전"),
                KeywordAlarmDataClass("황졍민님, 동네생활에 글을 작성하셨네요!","더 많은 활동을 통해 '동네 활동가'에 도전해보세요.","6주전"),
                KeywordAlarmDataClass("나눔을 실천하시는 황졍민님께 소식 도착🧡","10월은 나눔의 날, 쌀쌀해진 날을 따뜻하게 만든 나눔 사연을 전해요","7주전"),
                KeywordAlarmDataClass("\uD83D\uDC8C9월 가계부가 도착했어요!","#당근 #당근가계부 #자원재순환 #따뜻한 거래","8주전")
            )
        )
    }


    private fun initKeywordRecyclerView() {
        keywordAdapter = KeywordAlarmAdapter(keywordList)
        binding.rvKeywordAlarm.adapter = keywordAdapter
        binding.rvKeywordAlarm.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
    }

}