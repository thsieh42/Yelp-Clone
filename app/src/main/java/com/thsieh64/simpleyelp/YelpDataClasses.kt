package com.thsieh64.simpleyelp

import com.google.gson.annotations.SerializedName

data class YelpSearchResult(
        @SerializedName("total") val total: Int,
        @SerializedName("businesses") val restaurants: List<YelpRestaurant>
)

data class YelpRestaurant (
        val name: String,
        val rating: Double,
        val price: String,
        @SerializedName("review_count") val numReviews: String,
        @SerializedName("distance") val distanceInMeters: Double,
        @SerializedName("image_url") val imageURL: String,
        val categories: List<YelpCategory>,
        val location: YelpLocation

) {
    fun displayerDistance(): String {
        val milesPerMeter = 0.000621371
        val distanceInMiles = "%.2f".format(distanceInMeters * milesPerMeter)
        return "$distanceInMiles mi"
    }
}

data class YelpCategory (
        val title: String
)

data class YelpLocation (
        @SerializedName("address1") val address: String
)