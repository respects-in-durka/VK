import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Military(
        val unit: String,
        val unit_id: Int,
        val country_id: Int,
        val from: Int,
        val until: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(unit)
        parcel.writeInt(unit_id)
        parcel.writeInt(country_id)
        parcel.writeInt(from)
        parcel.writeInt(until)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Military> {
        override fun createFromParcel(parcel: Parcel): Military {
            return Military(parcel)
        }

        override fun newArray(size: Int): Array<Military?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = Military(
                unit=json.optString("unit", ""),
                unit_id=json.optInt("unit_id", 0),
                country_id=json.optInt("country_id", 0),
                from=json.optInt("from", 0),
                until=json.optInt("until", 0)
        )
    }
}
