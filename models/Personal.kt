import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Personal (
        val inspired_by: String,
        val people_main: Int,
        val life_main: Int,
        val smoking: Int,
        val alcohol: Int
    ) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(inspired_by)
        parcel.writeInt(people_main)
        parcel.writeInt(life_main)
        parcel.writeInt(smoking)
        parcel.writeInt(alcohol)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Personal> {

        override fun createFromParcel(parcel: Parcel): Personal {
            return Personal(parcel)
        }

        override fun newArray(size: Int): Array<Personal?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject): Personal {
            return Personal (
                inspired_by=json.optString("inspired_by", ""),
                people_main=json.optInt("people_main", 0),
                life_main=json.optInt("life_main", 0),
                smoking=json.optInt("smoking", 0),
                alcohol=json.optInt("alcohol", 0)
            )
        }
    }
}
