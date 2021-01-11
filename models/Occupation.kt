import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Occupation(
        val type: String,
        val id: Int,
        val name: String) : Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readString()!!)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Occupation> {
        override fun createFromParcel(parcel: Parcel): Occupation {
            return Occupation(parcel)
        }

        override fun newArray(size: Int): Array<Occupation?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = Occupation(
                type= json.optString("type", ""),
                id=json.optInt("id", 0),
                name=json.optString("name", "")
        )
        
    }
}
