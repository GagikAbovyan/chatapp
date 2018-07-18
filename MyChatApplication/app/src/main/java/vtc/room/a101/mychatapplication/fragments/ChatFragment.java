package vtc.room.a101.mychatapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import vtc.room.a101.mychatapplication.Constants;
import vtc.room.a101.mychatapplication.R;
import vtc.room.a101.mychatapplication.activity.MessengerActivity;
import vtc.room.a101.mychatapplication.adapters.MessageAdapter;
import vtc.room.a101.mychatapplication.models.Message;
import vtc.room.a101.mychatapplication.models.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {


    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        final ImageView userImage = (ImageView) view.findViewById(R.id.chat_image);
        final TextView name = (TextView) view.findViewById(R.id.chat_name);
        final int position = getArguments().getInt(Constants.MY_KEY);
        final User user = MessengerActivity.list.get(Constants.position);
        userImage.setImageResource(user.getImageId());
        name.setText(user.getName());
        final LinearLayoutManager llm = new LinearLayoutManager(getContext());
        final MessageAdapter messageAdapter = new MessageAdapter(getContext(), user.getList());
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.chat_rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(messageAdapter);
        final EditText editText = (EditText) view.findViewById(R.id.edit_text_send);
        final ImageButton imageButton = (ImageButton) view.findViewById(R.id.send_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.addMessage(new Message(editText.getText().toString(), true));
                user.addMessage(new Message(logicAnswer(editText.getText().toString(), user), false));
                editText.setText("");
                messageAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    private String logicAnswer(final String question, final User user){
        if (question.contains("name".toLowerCase())){
            return user.getName();
        }
        if (question.contains("status".toLowerCase())){
            return user.getStatus();
        }
        if (question.contains("email".toLowerCase())){
            return user.getEmail();
        }
        if (question.contains("tel".toLowerCase()) || question.contains("mobile".toLowerCase())){
            return user.getTel();
        }
        if (question.contains("us apple".toLowerCase())){
            return String.valueOf(user.isUseApple());
        }
        return "sorry my bunny cannot answer";
    }

}
