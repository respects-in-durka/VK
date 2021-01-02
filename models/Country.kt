import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Country(val id: Int, val title: String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt(), parcel.readString()!!)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Country> {
        override fun createFromParcel(parcel: Parcel): Country {
            return Country(parcel)
        }

        override fun newArray(size: Int): Array<Country?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = Country(id=json.optInt("id", 0), title=json.optString("title", ""))
    }
}
