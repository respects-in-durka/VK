import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject


data class Photo(
    val id: Int,
    val album_id: Int,
    val owner_id: Int,
    val date: Int,
    val sizes: ArrayList<Size>?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.createTypedArrayList(Size.CREATOR),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(album_id)
        parcel.writeInt(owner_id)
        parcel.writeInt(date)
        parcel.writeArray(arrayOf(sizes))
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Photo> {
        override fun createFromParcel(parcel: Parcel): Photo {
            return Photo(parcel)
        }

        override fun newArray(size: Int): Array<Photo?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) : Photo {
            val list: ArrayList<Size> = ArrayList()
            val jsonArray = json.optJSONArray("sizes")
            if (!jsonArray.isNull(0)) {
                for (i in 0 until jsonArray.length()) {
                    val size = Size.parse(jsonArray.getJSONObject(i))
                    list.add(size)
                }
            }
            return Photo(
                id=json.optInt("id", 0),
                album_id=json.optInt("album_id", 0),
                owner_id=json.optInt("owner_id", 0),
                date=json.optInt("date", 0),
                sizes=list,
            )
        }
    }
}
