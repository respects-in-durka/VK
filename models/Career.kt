import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Career(
    val group_id: Int,
    val company: String,
    val country_id: Int,
    val city_id: Int,
    val city_name: String,
    val from: Int,
    val until: Int,
    val position: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(group_id)
        parcel.writeString(company)
        parcel.writeInt(country_id)
        parcel.writeInt(city_id)
        parcel.writeString(city_name)
        parcel.writeInt(from)
        parcel.writeInt(until)
        parcel.writeString(position)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Career> {
        override fun createFromParcel(parcel: Parcel): Career {
            return Career(parcel)
        }

        override fun newArray(size: Int): Array<Career?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = Career(
            group_id=json.optInt("group_id", 0),
            company=json.optString("company", ""),
            country_id = json.optInt("country_id", 0),
            city_id = json.optInt("city_id", 0),
            city_name = json.optString("city_name", ""),
            from = json.optInt("from", 0),
            until = json.optInt("until", 0),
            position = json.optString("position", "")
        )
    }
}
