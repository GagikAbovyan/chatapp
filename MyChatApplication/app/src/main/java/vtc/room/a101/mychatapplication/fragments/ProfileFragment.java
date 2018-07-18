package vtc.room.a101.mychatapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import vtc.room.a101.mychatapplication.Constants;
import vtc.room.a101.mychatapplication.R;
import vtc.room.a101.mychatapplication.activity.MessengerActivity;
import vtc.room.a101.mychatapplication.models.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        final int position = getArguments().getInt(Constants.MY_KEY);
        final ImageView imageProfile = (ImageView) view.findViewById(R.id.image_profile);
        final TextView nameProfile = (TextView) view.findViewById(R.id.name_profile);
        final TextView statusProfile = (TextView) view.findViewById(R.id.statud_profile);
        final TextView emailProfile = (TextView) view.findViewById(R.id.email_profile);
        final TextView mobileProfile = (TextView) view.findViewById(R.id.mobile_profile);;
        final Switch useAppleProfile = (Switch) view.findViewById(R.id.us_apple_flag_profile);
        final User user = MessengerActivity.list.get(position);
        imageProfile.setImageResource(user.getImageId());
        nameProfile.setText(user.getName());
        statusProfile.setText(user.getStatus());
        emailProfile.setText(user.getEmail());
        mobileProfile.setText(user.getTel());
        useAppleProfile.setChecked(user.isUseApple());
        return view;
    }

}
