import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Size(
    val url: String,
    val type: String,
    val width: Int,
    val height: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(type)
        parcel.writeInt(width)
        parcel.writeInt(height)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Size> {
        override fun createFromParcel(parcel: Parcel): Size {
            return Size(parcel)
        }

        override fun newArray(size: Int): Array<Size?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = Size(
            url=json.optString("url", ""),
            type=json.optString("type", ""),
            width=json.optInt("width", 0),
            height=json.optInt("height", 0)
        )
    }
}
