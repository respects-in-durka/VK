import com.client.models.UserModel
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class UserRequest : VKRequest<UserModel>("users.get", "5.126") {

    init {
        addParam("fields", "photo_id, verified, sex, bdate, city, country, home_town, has_photo, photo_50, photo_100, photo_200_orig, photo_200, photo_400_orig, photo_max, photo_max_orig, online, domain, has_mobile, contacts, site, education, universities, schools, status, last_seen, followers_count, common_count, occupation, nickname, relatives, relation, personal, connections, exports, activities, interests, music, movies, tv, books, games, about, quotes, can_post, can_see_all_posts, can_see_audio, can_write_private_message, can_send_friend_request, is_favorite, is_hidden_from_feed, timezone, screen_name, maiden_name, crop_photo, is_friend, friend_status, career, military, blacklisted, blacklisted_by_me, can_be_invited_group, counters")
    }

    override fun parse(r: JSONObject): UserModel {
        val users = r.getJSONArray("response")
        return UserModel.parse(users.getJSONObject(0))
    }
}
