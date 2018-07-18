package vtc.room.a101.mychatapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vtc.room.a101.mychatapplication.R;
import vtc.room.a101.mychatapplication.adapters.RecyclerChatAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.chat_rec);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        RecyclerChatAdapter adapter = new RecyclerChatAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }
}


