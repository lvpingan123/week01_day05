package com.example.administrator.week01_day05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.administrator.week01_day05.Clazz.Data;
import com.example.administrator.week01_day05.Presnter.Presnter;
import com.example.administrator.week01_day05.View.MvpInterface;
import com.example.administrator.week01_day05.adepter.MyAdepter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MvpInterface {


    Presnter presnter;
    @BindView(R.id.main_Rv)
    RecyclerView mainRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presnter = new Presnter(this);
        presnter.handleData();
    }

    @Override
    public void LoadSuccess(List<Data> data) {
        Log.e("LLL", data.toString());
        for (int i = 0;i<data.size();i++) {
            Log.v("ZDZD",data.get(i).tvText+"\n");
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mainRv.setLayoutManager(manager);
        MyAdepter adepter = new MyAdepter(this);
        adepter.refresh(data);
        mainRv.setAdapter(adepter);
    }
}
