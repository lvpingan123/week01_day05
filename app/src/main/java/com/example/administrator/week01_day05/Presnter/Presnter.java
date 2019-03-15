package com.example.administrator.week01_day05.Presnter;

import com.example.administrator.week01_day05.Clazz.Data;
import com.example.administrator.week01_day05.Model.Model;
import com.example.administrator.week01_day05.Model.ModelInterface;
import com.example.administrator.week01_day05.View.MvpInterface;

import java.util.List;

public class Presnter implements ModelInterface {
    MvpInterface mvpInterface;
    Model model=new Model(this);

    public Presnter(MvpInterface mvpInterface) {
        this.mvpInterface = mvpInterface;
    }

    public  void handleData(){
        model.getData();

    }

    @Override
    public void successData(List<Data> data) {
        mvpInterface.LoadSuccess(data);
    }
}
