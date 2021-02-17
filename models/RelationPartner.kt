import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class RelationPartner(
        val id: Int,
        val first_name: String,
        val last_name: String
        ) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readString()!!)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RelationPartner> {
        override fun createFromParcel(parcel: Parcel): RelationPartner {
            return RelationPartner(parcel)
        }

        override fun newArray(size: Int): Array<RelationPartner?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = RelationPartner(
                id=json.optInt("id", 0),
                first_name=json.optString("first_name", ""),
                last_name=json.optString("last_name", "")
        )
    }
}
