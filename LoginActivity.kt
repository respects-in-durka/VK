import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import kotlinx.android.synthetic.main.activity_login.view.*

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        VK.login(this, arrayListOf(VKScope.PHOTOS, VKScope.WALL, VKScope.OFFLINE))

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                MainActivity.startFrom(this@LoginActivity)
            }

            override fun onLoginFailed(errorCode: Int) {
                AlertDialog.Builder(this@LoginActivity)
                        .setTitle(" ")
                        .setMessage("Login Failed")
            }

        }
        super.onActivityResult(requestCode, resultCode, data)
        VK.onActivityResult(requestCode, resultCode, data, callback)
    }

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }
    }
}
