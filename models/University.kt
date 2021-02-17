import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class University(
        val id: Int,
        val country: Int,
        val city: Int,
        val name: String,
        val faculty: Int,
        val faculty_name: String,
        val chair: Int,
        val chair_name: String,
        val graduation: Int,
        val education_form: String,
        val education_status: String
        ) : Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(country)
        parcel.writeInt(city)
        parcel.writeString(name)
        parcel.writeInt(faculty)
        parcel.writeString(faculty_name)
        parcel.writeInt(chair)
        parcel.writeString(chair_name)
        parcel.writeInt(graduation)
        parcel.writeString(education_form)
        parcel.writeString(education_status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<University> {
        override fun createFromParcel(parcel: Parcel): University {
            return University(parcel)
        }

        override fun newArray(size: Int): Array<University?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) : University {
             return University(
                id=json.optInt("id", 0),
                country=json.optInt("country", 0),
                city=json.optInt("city", 0),
                name=json.optString("name", ""),
                faculty=json.optInt("faculty", 0),
                faculty_name=json.optString("faculty_name", ""),
                chair=json.optInt("chair", 0),
                chair_name=json.optString("chair_name", "",),
                graduation=json.optInt("graduation", 0),
                education_form=json.optString("education_form", ""),
                education_status=json.optString("education_status", "")
        ) }
    }
}
