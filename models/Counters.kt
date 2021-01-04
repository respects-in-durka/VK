import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class Counters(
    val albums: Int,
    val videos: Int,
    val audios: Int,
    val photos: Int,
    val notes: Int,
    val friends: Int,
    val groups: Int,
    val online_friends: Int,
    val mutual_friends: Int,
    val followers: Int,
    val pages: Int,
    val gifts: Int,
    val subscriptions: Int,
    val user_photos: Int,
    val clips_followers: Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(albums)
        parcel.writeInt(videos)
        parcel.writeInt(audios)
        parcel.writeInt(photos)
        parcel.writeInt(notes)
        parcel.writeInt(friends)
        parcel.writeInt(groups)
        parcel.writeInt(online_friends)
        parcel.writeInt(mutual_friends)
        parcel.writeInt(followers)
        parcel.writeInt(pages)
        parcel.writeInt(gifts)
        parcel.writeInt(subscriptions)
        parcel.writeInt(user_photos)
        parcel.writeInt(clips_followers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Counters> {
        override fun createFromParcel(parcel: Parcel): Counters {
            return Counters(parcel)
        }

        override fun newArray(size: Int): Array<Counters?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = Counters(
            albums=json.optInt("albums", 0),
            videos=json.optInt("videos", 0),
            audios=json.optInt("audios", 0),
            photos=json.optInt("photos", 0),
            notes=json.optInt("notes", 0),
            friends=json.optInt("friends", 0),
            groups=json.optInt("groups", 0),
            online_friends=json.optInt("online_friends", 0),
            mutual_friends=json.optInt("mutual_friends", 0),
            followers=json.optInt("followers", 0),
            pages=json.optInt("pages", 0),
            gifts=json.optInt("gifts", 0),
            subscriptions=json.optInt("subscriptions", 0),
            user_photos=json.optInt("user_photos", 0),
            clips_followers=json.optInt("clips_followers", 0)
        )
    }
}
