package com.example.carrotmarket

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MyProductDAO {

    //MyProductDAO 객체를 가져와서 addMyProduct 함수 호출 → 그 인자로 MyProduct 객체를 넣어주면 테이블에 쓰여짐
    @Insert
    fun addMyProduct(myProduct: MyProduct)

    @Update
    fun updateMyProduct(myProduct: MyProduct)

    @Delete
    fun deleteMyProduct(myProduct: MyProduct)

    //Select는 옵션이 많기 때문에 직접 지정해줌. - Table에 있는 모든 걸 가져오겠다.(*)
    @Query("SELECT * FROM MyProductTable")
    fun getMyProducts() : List<MyProduct>
}