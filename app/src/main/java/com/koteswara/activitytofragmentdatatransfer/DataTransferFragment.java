package com.koteswara.activitytofragmentdatatransfer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koteswara.activitytofragmentdatatransfer.databinding.FragmentDataTransferBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataTransferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataTransferFragment extends Fragment {
    DataTranferFragmentListner dataTranferFragmentListner;
    FragmentDataTransferBinding fragmentDataTransferBinding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Bundle sendData;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DataTransferFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataTransferFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataTransferFragment newInstance(String param1, String param2) {
        DataTransferFragment fragment = new DataTransferFragment();
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
        fragmentDataTransferBinding=FragmentDataTransferBinding.inflate(getLayoutInflater());
        return fragmentDataTransferBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentDataTransferBinding.fragmentToFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData=new Bundle();
                sendData.putString("123","from fragment");
                dataTranferFragmentListner.dataTransferFromFragment(sendData);
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragmentContainer,new DataReceiveFragment()).commit();
            }
        });
    }
    public interface DataTranferFragmentListner{
        public void dataTransferFromFragment(Bundle bundle);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try
        {
            dataTranferFragmentListner = (DataTranferFragmentListner) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString()+ " must implement OnImageClickListener");
        }
    }
}