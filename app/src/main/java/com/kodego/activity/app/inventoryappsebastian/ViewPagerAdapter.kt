package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodego.activity.app.inventoryappsebastian.databinding.ItemViewPagerBinding

class ViewPagerAdapter (val images: List<Int>, var textViewPagerDesc: List<String>): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(val binding: ItemViewPagerBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        //give look to our views
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewPagerBinding.inflate(layoutInflater,parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val image = images[position]
//        var txtViewPagerText = textViewPagerDesc[position]
        holder.binding.apply {
            imgViewPager.setImageResource(image)
            txtViewPagerText.text = textViewPagerDesc[position].toString()
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }


}