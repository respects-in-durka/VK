import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class UserModel(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val is_closed: Boolean,
        val can_access_closed: Boolean,
        val about: String,
        val activities: String,
        val bdate: String,
        val blackListed: Int,
        val blacklisted_by_me: Int,
        val books: String,
        val can_post: Int,
        val can_see_all_posts: Int,
        val can_see_audio: Int,
        val can_send_friend_request: Int,
        val can_write_private_message: Int,
        val common_count: Int,
        val country: Country?,
        val city: City?,
        val mobile_phone: String,
        val home_phone: String,
        val skype: String? = null,
        val twitter: String? = null,
        val liveJournal: String? = null,
        val instagram: String? = null,
        val facebook: String? = null,
        val facebook_Name: String? = null,
        val counters: Counters?,
        val career: Career?,
        val crop_photo: CropPhoto?,
        val domain: String,
        val university: Int? = null,
        val university_name: String? = null,
        val faculty: Int? = null,
        val faculty_name: String? = null,
        val graduation: Int? =  null,
        val followers_count: Int,
        val friend_status: Int,
        val games: String,
        val home_town: String,
        val interests: String,
        val is_friend: Int,
        val is_hidden_from_feed: Int,
        val last_seen: LastSeen?,
        val military: Military? = null,
        val movies: String,
        val occupation: Occupation?,
        val online: Int,
        val online_mobile: Int,
        val personal: Personal?,
        val photo_50: String,
        val photo_100: String,
        val photo_200_orig: String,
        val photo_200: String,
        val photo_400_orig: String,
        val photo_max: String,
        val photo_max_orig: String,
        val quotes: String,
        val relatives: ArrayList<Relative>?,
        val relation: Int,
        val relation_partner: RelationPartner? = null,
        val schools: ArrayList<School>?,
        val screen_name: String,
        val sex: Int,
        val site: String,
        val status: String,
        val timezone: Int,
        val trending: Int,
        val tv: String,
        val universities: ArrayList<University>?,
        val verified: Int,
        val wall_default: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readBoolean(),
        parcel.readBoolean(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(Country::class.java.classLoader),
        parcel.readParcelable(City::class.java.classLoader),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Counters::class.java.classLoader),
        parcel.readParcelable(Career::class.java.classLoader),
        parcel.readParcelable(CropPhoto::class.java.classLoader),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(LastSeen::class.java.classLoader),
        parcel.readParcelable(Military::class.java.classLoader),
        parcel.readString()!!,
        parcel.readParcelable(Occupation::class.java.classLoader),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(Personal::class.java.classLoader),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createTypedArrayList(Relative.CREATOR),
        parcel.readInt(),
        parcel.readParcelable(RelationPartner::class.java.classLoader),
        parcel.createTypedArrayList(School.CREATOR),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.createTypedArrayList(University.CREATOR),
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeBoolean(is_closed)
        parcel.writeBoolean(can_access_closed)
        parcel.writeString(about)
        parcel.writeString(activities)
        parcel.writeString(bdate)
        parcel.writeInt(blackListed)
        parcel.writeInt(blacklisted_by_me)
        parcel.writeString(books)
        parcel.writeInt(can_post)
        parcel.writeInt(can_see_all_posts)
        parcel.writeInt(can_see_audio)
        parcel.writeInt(can_send_friend_request)
        parcel.writeInt(can_write_private_message)
        parcel.writeInt(common_count)
        parcel.writeParcelable(country, flags)
        parcel.writeParcelable(city, flags)
        parcel.writeString(mobile_phone)
        parcel.writeString(home_phone)
        parcel.writeString(skype)
        parcel.writeString(twitter)
        parcel.writeString(liveJournal)
        parcel.writeString(instagram)
        parcel.writeString(facebook)
        parcel.writeString(facebook_Name)
        parcel.writeParcelable(counters, flags)
        parcel.writeParcelable(career, flags)
        parcel.writeParcelable(crop_photo, flags)
        parcel.writeString(domain)
        parcel.writeValue(university)
        parcel.writeString(university_name)
        parcel.writeValue(faculty)
        parcel.writeString(faculty_name)
        parcel.writeValue(graduation)
        parcel.writeInt(followers_count)
        parcel.writeInt(friend_status)
        parcel.writeString(games)
        parcel.writeString(home_town)
        parcel.writeString(interests)
        parcel.writeInt(is_friend)
        parcel.writeInt(is_hidden_from_feed)
        parcel.writeParcelable(last_seen, flags)
        parcel.writeParcelable(military, flags)
        parcel.writeString(movies)
        parcel.writeParcelable(occupation, flags)
        parcel.writeInt(online)
        parcel.writeInt(online_mobile)
        parcel.writeParcelable(personal, flags)
        parcel.writeString(photo_50)
        parcel.writeString(photo_100)
        parcel.writeString(photo_200_orig)
        parcel.writeString(photo_200)
        parcel.writeString(photo_400_orig)
        parcel.writeString(photo_max)
        parcel.writeString(photo_max_orig)
        parcel.writeString(quotes)
        parcel.writeInt(relation)
        parcel.writeParcelable(relation_partner, flags)
        parcel.writeString(screen_name)
        parcel.writeInt(sex)
        parcel.writeString(site)
        parcel.writeString(status)
        parcel.writeInt(timezone)
        parcel.writeInt(trending)
        parcel.writeString(tv)
        parcel.writeInt(verified)
        parcel.writeString(wall_default)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModel> {
        override fun createFromParcel(parcel: Parcel): UserModel {
            return UserModel(parcel)
        }

        override fun newArray(size: Int): Array<UserModel?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) : UserModel {
            var career: Career? = null
            var city: City? = null
            var military: Military? = null
            var occupation: Occupation? = null
            var relationPartner: RelationPartner? = null
            val relatives: ArrayList<Relative> = ArrayList()
            val schools: ArrayList<School> = ArrayList()
            val universities: ArrayList<University> = ArrayList()

            if (!json.getJSONArray("career").isNull(0)) career = Career.parse(json.getJSONArray("career").getJSONObject(0))
            if (!json.isNull("city")) city = City.parse(json.getJSONObject("city"))
            if (!json.getJSONArray("military").isNull(0)) military = Military.parse(json.getJSONArray("military").getJSONObject(0))
            if (!json.isNull("occupation")) occupation = Occupation.parse(json.getJSONObject("occupation"))
            if (!json.isNull("relation_partner")) relationPartner = RelationPartner.parse(json.getJSONObject("relation_partner"))
            if (json.isNull("relatives")) {
                for (i in 0 until json.getJSONArray("relatives").length()) {
                    relatives.add(Relative.parse(json.getJSONArray("relatives").getJSONObject(i)))
                }
            }
            if (!json.isNull("schools")) {
                for (i in 0 until json.getJSONArray("schools").length()) {
                    schools.add(School.parse(json.getJSONArray("schools").getJSONObject(i)))
                }
            }
            if (!json.isNull("universities")) {
                for (i in 0 until json.getJSONArray("universities").length()) {
                    universities.add(University.parse(json.getJSONArray("universities").getJSONObject(i)))
                }
            }


            return UserModel(
                id=json.optInt("id", 0),
                firstName=json.optString("first_name", ""),
                lastName=json.optString("last_name", ""),
                is_closed=json.optBoolean("is_closed"),
                can_access_closed=json.optBoolean("can_access_closed"),
                about=json.optString("about", ""),
                activities=json.optString("activities", ""),
                bdate=json.optString("bdate", ""),
                blackListed=json.optInt("blacklisted", 0),
                blacklisted_by_me=json.optInt("blacklisted_by_me", 0),
                books=json.optString("books", ""),
                can_post=json.optInt("can_post", 0),
                can_see_all_posts=json.optInt("can_see_all_posts", 0),
                can_see_audio=json.optInt("can_see_audio", 0),
                can_send_friend_request=json.optInt("can_send_friend_request", 0),
                can_write_private_message=json.optInt("can_write_private_message", 0),
                common_count=json.optInt("common_count", 0),
                country=Country.parse(json.getJSONObject("country")),
                city=city,
                mobile_phone=json.optString("mobile_phone", ""),
                home_phone=json.optString("home_phone", ""),
                skype=json.optString("skype", ""),
                twitter=json.optString("twitter", ""),
                liveJournal=json.optString("livejournal"),
                instagram=json.optString("instagram", ""),
                facebook=json.optString("facebook", ""),
                facebook_Name=json.optString("facebook_name", ""),
                counters=Counters.parse(json.getJSONObject("counters")),
                career=career,
                crop_photo=CropPhoto.parse(json.getJSONObject("crop_photo")),
                domain=json.optString("domain", ""),
                university=json.optInt("university", 0),
                university_name=json.optString("university_name", ""),
                faculty=json.optInt("faculty", 0),
                faculty_name=json.optString("faculty_name", ""),
                graduation=json.optInt("graduation", 0),
                followers_count=json.optInt("followers_count", 0),
                friend_status=json.optInt("friend_status", 0),
                games=json.optString("games", ""),
                home_town=json.optString("home_town", ""),
                interests=json.optString("interests", ""),
                is_friend=json.optInt("is_friend", 0),
                is_hidden_from_feed=json.optInt("is_hidden_from_feed", 0),
                last_seen=LastSeen.parse(json.getJSONObject("last_seen")),
                military=military,
                movies=json.optString("movies", ""),
                occupation=occupation,
                online =json.optInt("online", 0),
                online_mobile=json.optInt("online_mobile", 0),
                personal=Personal.parse(json.getJSONObject("personal")),
                photo_50=json.optString("photo_50", ""),
                photo_100=json.optString("photo_100", ""),
                photo_200=json.optString("photo_200", ""),
                photo_200_orig=json.optString("photo_200_orig", ""),
                photo_400_orig=json.optString("photo_400_orig", ""),
                photo_max=json.optString("photo_max", ""),
                photo_max_orig=json.optString("photo_max_orig", ""),
                quotes=json.optString("quotes", ""),
                relatives=relatives,
                relation=json.optInt("relation", 0),
                relation_partner=relationPartner,
                schools=schools,
                screen_name =json.optString("screen_name", ""),
                sex=json.optInt("sex", 0),
                site=json.optString("site", ""),
                status=json.optString("status", ""),
                timezone=json.optInt("timezone", 0),
                trending=json.optInt("trending", 0),
                tv=json.optString("tv", ""),
                universities=universities,
                verified=json.optInt("verified", 0),
                wall_default=json.optString("wall_default", "")
            )
        }
    }
}
