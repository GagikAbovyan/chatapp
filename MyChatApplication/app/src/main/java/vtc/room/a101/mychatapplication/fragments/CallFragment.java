package vtc.room.a101.mychatapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vtc.room.a101.mychatapplication.R;
import vtc.room.a101.mychatapplication.adapters.RecyclerCallAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends Fragment {


    public CallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_call);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        RecyclerCallAdapter adapter = new RecyclerCallAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }

}
