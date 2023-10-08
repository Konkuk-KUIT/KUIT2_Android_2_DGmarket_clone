package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemHomeProductBinding

class ProductAdapter(val productList:ArrayList<MyProduct>)
    :RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    //OnItemClickLister라는 타입의 itemClickListener라는 프로퍼티 선언
    private lateinit var itemClickListener: OnItemClickListener

    //interface에선 추상메소드 구현 가능, 즉, adapter에서 메소드를 명시만 해놓음.
    interface OnItemClickListener{
        fun onItemClick(myProduct: MyProduct)
    }

    //함수의 초기화를 진행하지 않았기 때문에 선언,외부에서 onItemClickListener를 받겠다.
    //이걸 안해주면 null function - 실행했을 때 itemclicklistener에 대한 정보가 없기 때문에 프로그램 강제 종료.
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        //itemClickListener의 세터를 작성한다고 생각
        itemClickListener = onItemClickListener
    }

    //View Holder는 ItemView를 가지고 있고, 이것을 Binding하기 위해 ItemHomeProductBinding을 생성자로 받음.
    inner class ViewHolder(val binding:ItemHomeProductBinding):RecyclerView.ViewHolder(binding.root){
        //onBindViewHolder의 코드를 간소화 하기위해 bind 함수 선언, myProduct라는 매개변수를 받음.
        fun bind(myProduct:MyProduct){
            binding.tvProductTitle.text = myProduct.producttitle
            binding.tvProductPrice.text = myProduct.productprice
            binding.tvProductRegion.text = myProduct.productregion
            binding.tvProductTime.text = myProduct.producttime
            binding.tvProductComment.text = myProduct.productcomment
            binding.tvProductLike.text = myProduct.productlike
            binding.ivProductImage.setImageResource(myProduct.productimage)

            itemView.setOnClickListener{
                itemClickListener.onItemClick(myProduct)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //xml파일 객체화, View Holder 반환
        val binding = ItemHomeProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        //wordList의 사이즈 리턴
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //이미 bind라는 함수를 통해 어느정도 할 일 명시, bind 호출
        holder.bind(productList[position])
    }


}