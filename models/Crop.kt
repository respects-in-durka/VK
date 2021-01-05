import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Crop(
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

    companion object CREATOR : Parcelable.Creator<Crop> {
        override fun createFromParcel(parcel: Parcel): Crop {
            return Crop(parcel)
        }

        override fun newArray(size: Int): Array<Crop?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = Crop(
            x=json.optInt("x", 0),
            y=json.optInt("y", 0),
            x2=json.optInt("x2", 0),
            y2=json.optInt("y2", 0)
        )
    }
}
