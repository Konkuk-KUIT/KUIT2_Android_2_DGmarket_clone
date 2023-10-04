package com.example.carrotmarket

import java.io.Serializable

// TODO: RecyclerView에 들어갈 item을 구성할 때 필요한 정보에는 무엇이 있을지 생각해보고 data class로 만들기
// 예시: 사진(썸네일), 글 제목, 사는 곳, 시간, 가격, ...
data class ProductInfo(

    val product_img: Int,
    val product_title: String,
    val product_id: String,
    val product_price: String,
    val comment_count: Int,
    val like_count: Int
):Serializable