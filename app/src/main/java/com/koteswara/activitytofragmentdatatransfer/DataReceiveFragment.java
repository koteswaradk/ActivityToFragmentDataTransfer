package com.koteswara.activitytofragmentdatatransfer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koteswara.activitytofragmentdatatransfer.databinding.FragmentDataReceiveBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataReceiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataReceiveFragment extends Fragment  {

    FragmentDataReceiveBinding fragmentDataReceiveBinding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "name";
    private static final String ARG_PARAM2 = "password";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DataReceiveFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataReceiveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataReceiveFragment newInstance(String param1, String param2) {
        DataReceiveFragment fragment = new DataReceiveFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentDataReceiveBinding= FragmentDataReceiveBinding.inflate(getLayoutInflater());
       // return inflater.inflate(R.layout.fragment_data_receive, container, false);
        return fragmentDataReceiveBinding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // fragmentDataReceiveBinding.textviewdata.setText(mParam1+" "+mParam2);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentDataReceiveBinding=null;
    }

}