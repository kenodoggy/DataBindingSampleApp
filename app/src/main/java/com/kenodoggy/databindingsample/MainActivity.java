package com.kenodoggy.databindingsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kenodoggy.databindingsample.databinding.ActivityMainBinding;
import com.kenodoggy.databindingsample.observable.BindableObject;

public class MainActivity extends AppCompatActivity {

    private BindableObject bindableObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindableObject = new BindableObject();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setObj(bindableObject);
    }

    public void onClickReset(View v) {
        bindableObject.setTextValue("");
        bindableObject.setEditTextValue("");
    }


}
