package vtc.room.a101.mychatapplication.activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;
import vtc.room.a101.mychatapplication.Constants;
import vtc.room.a101.mychatapplication.R;
import vtc.room.a101.mychatapplication.fragments.CallFragment;
import vtc.room.a101.mychatapplication.fragments.MessageFragment;
import vtc.room.a101.mychatapplication.fragments.SettingsFragment;
import vtc.room.a101.mychatapplication.models.User;

public class MessengerActivity extends AppCompatActivity {


    public static List<User> list = new ArrayList<>();
    public static boolean flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        initData(list);
        final BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        getSupportFragmentManager().beginTransaction().add(R.id.content, new CallFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_call:
                        setFragment(new CallFragment());
                        return true;
                    case R.id.navigation_message:
                        setFragment(new MessageFragment());
                        return true;
                    case R.id.navigation_settings:
                        setFragment(new SettingsFragment());
                        return true;
                }
                return false;
            }
        });
    }

    private void setFragment(final Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    private void initData(final List<User> list){
        final User elizabeth = new User(R.drawable.elizabeth, Constants.ELIZABETH, Constants.IN_SEARCH);
        final User scarlett = new User(R.drawable.scarlett, Constants.SCARLETT, Constants.IN_SEARCH);
        final User mariam = new User(R.drawable.mariam, Constants.MARIAM, Constants.BELOVED);
        final User gal = new User(R.drawable.gal, Constants.GAL, Constants.MARRIED);
        final User kira = new User(R.drawable.kira, Constants.KIRA, Constants.MARRIED);
        elizabeth.setTel(Constants.MY_NUMBER);
        scarlett.setTel(Constants.MY_NUMBER);
        mariam.setTel(Constants.MY_NUMBER);
        gal.setTel(Constants.MY_NUMBER);
        kira.setTel(Constants.MY_NUMBER);
        elizabeth.setEmail(Constants.MY_EMAIL);
        scarlett.setEmail(Constants.MY_EMAIL);
        mariam.setEmail(Constants.MY_EMAIL);
        gal.setEmail(Constants.MY_EMAIL);
        kira.setEmail(Constants.MY_EMAIL);
        elizabeth.setUseApple(true);
        scarlett.setUseApple(true);
        mariam.setUseApple(true);
        gal.setUseApple(false);
        kira.setUseApple(false);
        list.add(elizabeth);
        list.add(scarlett);
        list.add(mariam);
        list.add(gal);
        list.add(kira);
    }

}
