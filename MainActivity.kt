import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.client.models.UserModel
import com.client.requests.UserRequest
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.VKApiConfig
import com.vk.api.sdk.VKTokenExpiredHandler

class MainActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        VK.addTokenExpiredHandler(tokenTracker)
        VK.setConfig(VKApiConfig(context=baseContext, VK.getAppId(baseContext), lang="ru"))

        val getDataButton: Button = findViewById(R.id.getDataBtn)
        val loginButton: Button = findViewById(R.id.loginBtn)

        if (!VK.isLoggedIn()) {
            if (getDataButton.isVisible) {
                getDataButton.visibility = View.INVISIBLE
            }
            loginButton.text = "Login"
            loginButton.setOnClickListener{
                LoginActivity.startFrom(this)
            }
        } else {
            if (!getDataButton.isVisible) {
                getDataButton.visibility = View.VISIBLE
            }
            loginButton.text = "Exit"
            loginButton.setOnClickListener {
                VK.logout()
                LoginActivity.startFrom(this)
            }
            getDataButton.setOnClickListener {
                UserViewActivity.startFrom(this)
            }
        }
    }

    private val tokenTracker = object: VKTokenExpiredHandler {
        override fun onTokenExpired() {
            LoginActivity.startFrom(this@MainActivity)
        }
    }

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }
    }
}
