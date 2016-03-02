package com.tanyong.dragandview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DragAndDrawFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DragAndDrawFragment extends Fragment {


    public DragAndDrawFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DragAndDrawFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DragAndDrawFragment newInstance() {
        DragAndDrawFragment fragment = new DragAndDrawFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drag_and_draw, container, false);
    }

}