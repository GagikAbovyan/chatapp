package vtc.room.a101.mychatapplication.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import vtc.room.a101.mychatapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment{


    public SettingsFragment() {
        // Required empty public constructor
    }

    CircleImageView myImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        myImage = (CircleImageView) view.findViewById(R.id.my_image);
        final ImageButton changeButton = (ImageButton) view.findViewById(R.id.my_change_image);
        final ImageButton changeNameButton = (ImageButton) view.findViewById(R.id.my_change_name);
        final ImageButton changeSurNameButton = (ImageButton) view.findViewById(R.id.my_change_sur_name);
        final EditText nameEdit = (EditText) view.findViewById(R.id.my_name_edit);
        final EditText surNameEdit = (EditText) view.findViewById(R.id.mu_sur_edit);
        final TextView name = (TextView) view.findViewById(R.id.my_name);
        final TextView surName = (TextView) view.findViewById(R.id.my_sur_name);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent, 69);
            }
        });

        changeNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(nameEdit.getText().toString());
                nameEdit.setText("");
            }
        });

        changeSurNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surName.setText(surNameEdit.getText().toString());
                surNameEdit.setText("");
            }
        });



        return view;
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK){
            if (requestCode == 69 && data !=null){
                final Uri imageUri = data.getData();
                myImage.setImageURI(imageUri);
            }
        }
    }

}
