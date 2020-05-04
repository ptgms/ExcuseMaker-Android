package xyz.ptgms.excusemaker;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    boolean lowercase = false;
    boolean uppercase = false;
    boolean furry = false;
    boolean mockery = false;

    public void saveSetting(int setting, boolean State) {
        System.out.println("" + setting + State);
        switch(setting) {
            case 0: lowercase = State; break;
            case 1: uppercase = State; break;
            case 2: furry = State; break;
            case 3: mockery = State; break;
        }
    }

    public boolean LoadSetting(int setting) {
        System.out.println("Lowercase: " + lowercase + " Uppercase: " + uppercase + " Furry: " + furry);
        switch(setting) {
            case 0: return lowercase;
            case 1: return uppercase;
            case 2: return furry;
            case 3: return mockery;
            default: System.exit(-1);
                return false;
        }
    }
}