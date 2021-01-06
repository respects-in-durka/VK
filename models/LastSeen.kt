import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class LastSeen(val time: Long, val platform: Int) : Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(time)
        parcel.writeInt(platform)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LastSeen> {
        override fun createFromParcel(parcel: Parcel): LastSeen {
            return LastSeen(parcel)
        }

        override fun newArray(size: Int): Array<LastSeen?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = LastSeen(
            time=json.optLong("time", 0),
            platform=json.optInt("platform", 0)
        )
    }
}
