package com.example.carrotmarket
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemHomeProductBinding

class ProductAdapter(val productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    // TODO: 인터페이스에서 제공하는 추상 메서드는 무엇이 있을까요?
    interface OnItemClickListener {
        fun onItemClick(Product: Product)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }

    /*  해설: RecyclerView에 들어갈 item을 구성하는 xml의 이름이 item_home_product.xml 이므로
      * 따라서 binding 은 ItemHomeProductBinding으로 작성된다.
    */
    inner class ViewHolder(val binding: ItemHomeProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(Product: Product) {
            //여기 모르겠어 ㅠ


            itemView.setOnClickListener{
                itemClickListener.onItemClick(Product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHomeProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 해석: holder의 타입이 위에서 구현한 ViewHolder 클래스이므로, 해당 클래스의 bind 함수를 실행.
        // 이 때 매개변수로 productList라는 ArrayList의 position에 위치하는 항목을 넘겨준다.
        holder.bind(productList[position])
        val binding = holder.binding
        binding.clItem.setOnClickListener{
            itemClickListener.onItemClick(productList[position])
        }
    }
    fun setData(list: List<Product>){
        productList.addAll(list)
        notifyDataSetChanged()
    }
}
