import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Rect(
    val x: Int,
    val y: Int,
    val x2: Int,
    val y2: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(x)
        parcel.writeInt(y)
        parcel.writeInt(x2)
        parcel.writeInt(y2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rect> {
        override fun createFromParcel(parcel: Parcel): Rect {
            return Rect(parcel)
        }

        override fun newArray(size: Int): Array<Rect?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = Rect(
            x=json.optInt("x", 0),
            y=json.optInt("y", 0),
            x2=json.optInt("x2", 0),
            y2=json.optInt("y2", 0)
        )
    }
}
