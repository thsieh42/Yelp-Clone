package com.thsieh64.simpleyelp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantsAdapter(val context: Context, val restaurants: List<YelpRestaurant>) : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.bind(restaurant)
    }

    override fun getItemCount() = restaurants.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(restaurant: YelpRestaurant) {
            itemView.tvName.text = restaurant.name
            itemView.tvNumReviews.text = "${restaurant.numReviews} Views"
            itemView.tvAddress.text = restaurant.location.address
            itemView.tvCategory.text = restaurant.categories[0].title
            itemView.tvDistance.text = restaurant.displayerDistance()
            itemView.tvPrice.text = restaurant.price

            when(restaurant.rating.toFloat()) {
                0.0.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_0)
                0.5.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_0)
                1.0.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_1)
                1.5.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_1_half)
                2.0.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_2)
                2.5.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_2_half)
                3.0.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_3)
                3.5.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_3_half)
                4.0.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_4)
                4.5.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_4_half)
                5.0.toFloat() -> itemView.ivRating.setImageResource(R.drawable.stars_regular_5)
                else -> {
                    itemView.ivRating.setImageResource(R.drawable.stars_regular_0)
                }
            }

            Glide.with(context).load(restaurant.imageURL).apply(
                RequestOptions().transforms(
                CenterCrop(), RoundedCorners(20)
            )).into(itemView.imageView)
        }

    }

}
