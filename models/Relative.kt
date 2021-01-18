import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Relative(
        val id: Int,
        val name: String,
        val type: String
        ) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readString()!!)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Relative> {
        override fun createFromParcel(parcel: Parcel): Relative {
            return Relative(parcel)
        }

        override fun newArray(size: Int): Array<Relative?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = Relative(
                id=json.optInt("id", 0),
                name=json.optString("name", ""),
                type=json.optString("type", "")
        )
    }
}
