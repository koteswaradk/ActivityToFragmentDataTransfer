package com.koteswara.activitytofragmentdatatransfer;

import android.os.Bundle;
import android.view.View;

import com.koteswara.activitytofragmentdatatransfer.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements DataTransferFragment.DataTranferFragmentListner {

    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
    }

    public void activityToFragment(View view) {
        //data transfer from activity to fragment
      /*  DataReceiveFragment dataReceiveFragment  = new DataReceiveFragment();
        Bundle bundle=new Bundle();
        bundle.putString("name"," koteswaradk");
        bundle.putString("password","7795589555 from Activity");
        dataReceiveFragment.setArguments(bundle);*/
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new DataTransferFragment()).commit();
       // getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,dataReceiveFragment).commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        activityMainBinding=null;
    }


    @Override
    public void dataTransferFromFragment(Bundle bundle) {
        activityMainBinding.dataFromFragment.setText(bundle.getString("123")+" in Activity");

    }
}