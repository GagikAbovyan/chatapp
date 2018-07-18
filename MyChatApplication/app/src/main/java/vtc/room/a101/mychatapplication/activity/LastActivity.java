package vtc.room.a101.mychatapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vtc.room.a101.mychatapplication.Constants;
import vtc.room.a101.mychatapplication.R;
import vtc.room.a101.mychatapplication.fragments.ChatFragment;
import vtc.room.a101.mychatapplication.fragments.ProfileFragment;

public class LastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        final int position = getIntent().getExtras().getInt(Constants.MY_KEY);
        if (MessengerActivity.flag){
            final Bundle profileBundle = new Bundle();
            profileBundle.putInt(Constants.MY_KEY, position);
            final ProfileFragment profileFragment = new ProfileFragment();
            profileFragment.setArguments(profileBundle);
            getSupportFragmentManager().beginTransaction().add(R.id.last_container, profileFragment)
                    .addToBackStack(null).commit();
        }else{
            final Bundle chatBundle = new Bundle();
            chatBundle.putInt(Constants.MY_KEY, position);
            final ChatFragment chatFragment = new ChatFragment();
            chatFragment.setArguments(chatBundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.last_container, chatFragment)
                    .addToBackStack(null).commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
