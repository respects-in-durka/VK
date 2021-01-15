import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class School(
        val id: Int,
        val country: Int,
        val city: Int,
        val name: String,
        val year_from: Int,
        val year_to: Int,
        val year_graduated: Int,
        val classLetter: String,
        val speciality: String,
        val type: Int,
        val type_str: String
        ) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readString()!!,
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(country)
        parcel.writeInt(city)
        parcel.writeString(name)
        parcel.writeInt(year_from)
        parcel.writeInt(year_to)
        parcel.writeInt(year_graduated)
        parcel.writeString(classLetter)
        parcel.writeString(speciality)
        parcel.writeInt(type)
        parcel.writeString(type_str)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<School> {
        override fun createFromParcel(parcel: Parcel): School {
            return School(parcel)
        }

        override fun newArray(size: Int): Array<School?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = School(
                id=json.optInt("id", 0),
                country=json.optInt("country", 0),
                city=json.optInt("city", 0),
                name=json.optString("name", ""),
                year_from=json.optInt("year_from", 0),
                year_to=json.optInt("year_to", 0),
                year_graduated=json.optInt("year_graduated", 0),
                classLetter=json.optString("class", ""),
                speciality=json.optString("speciality", ""),
                type=json.optInt("type", 0),
                type_str=json.optString("type_str", "")
        )
    }
}
