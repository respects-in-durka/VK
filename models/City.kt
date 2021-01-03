import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class City(val id: Int, val title: String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt(), parcel.readString()!!)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<City> {
        override fun createFromParcel(parcel: Parcel): City {
            return City(parcel)
        }

        override fun newArray(size: Int): Array<City?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = City(
            id=json.optInt("id", 0),
            title=json.optString("title", "")
        )
    }
}
