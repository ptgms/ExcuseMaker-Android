package xyz.ptgms.excusemaker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }

    var lowercase = false
    var uppercase = false
    var furry = false
    var mockery = false
    fun saveSetting(setting: Int, State: Boolean) {
        println("" + setting + State)
        when (setting) {
            0 -> lowercase = State
            1 -> uppercase = State
            2 -> furry = State
            3 -> mockery = State
        }
    }

    fun LoadSetting(setting: Int): Boolean {
        println("Lowercase: $lowercase Uppercase: $uppercase Furry: $furry")
        return when (setting) {
            0 -> lowercase
            1 -> uppercase
            2 -> furry
            3 -> mockery
            else -> {
                System.exit(-1)
                false
            }
        }
    }
}