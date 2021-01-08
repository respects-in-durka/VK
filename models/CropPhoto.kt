import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class CropPhoto(
    val photo: Photo?,
    val crop: Crop?,
    val rect: Rect?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Photo::class.java.classLoader),
        parcel.readParcelable(Crop::class.java.classLoader),
        parcel.readParcelable(Rect::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(photo, flags)
        parcel.writeParcelable(crop, flags)
        parcel.writeParcelable(rect, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CropPhoto> {
        override fun createFromParcel(parcel: Parcel): CropPhoto {
            return CropPhoto(parcel)
        }

        override fun newArray(size: Int): Array<CropPhoto?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = CropPhoto(
            photo=Photo.parse(json.getJSONObject("photo")),
            crop=Crop.parse(json.getJSONObject("crop")),
            rect=Rect.parse(json.getJSONObject("rect"))
        )
    }
}
