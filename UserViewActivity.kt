import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.client.models.UserModel
import com.client.requests.UserRequest
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback

class UserViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile)
        VK.execute(UserRequest(), object: VKApiCallback<UserModel> {
            override fun fail(error: Exception) {
                println(error)
            }

            override fun success(result: UserModel) {
                Image(findViewById(R.id.image)).execute(result.photo_max_orig)
                findViewById<TextView>(R.id.firstName).text = result.firstName
                findViewById<TextView>(R.id.lastName).text = result.lastName
            }

        })

    }

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, UserViewActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }
    }

    @SuppressLint("StaticFieldLeak")
    @Suppress("DEPRECATION")
    private inner class Image(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {

        override fun doInBackground(vararg urls: String): Bitmap? {
            val imageURL = urls[0]
            var image: Bitmap? = null
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
            }
            catch (e: Exception) {
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
            return image
        }
        override fun onPostExecute(result: Bitmap?) {
            imageView.setImageBitmap(result)
        }
    }
}
