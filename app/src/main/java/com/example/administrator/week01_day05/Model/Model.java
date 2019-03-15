package com.example.administrator.week01_day05.Model;



import android.util.Log;

import com.example.administrator.week01_day05.Clazz.Bean;
import com.example.administrator.week01_day05.Clazz.Data;
import com.example.administrator.week01_day05.RetroInterface;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {
    ModelInterface modelInterface;
    List<Data> list=new ArrayList<>();

    public Model(ModelInterface modelInterface) {
        this.modelInterface = modelInterface;
    }
    public void getData(){
      Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory
        .create()).baseUrl("http://www.qubaobei.com/ios/cf/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        RetroInterface retroInterface=retrofit.create(RetroInterface.class);
        Observable<Bean> observable=retroInterface
                .getData("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1");

                observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        Log.e("LPA",bean.toString());
                        List<Bean.DataBean> dataBeans=bean.getData();
                        for(int i=0;i<dataBeans.size();i++){
                            Data data=new Data();
                           data.imgPath=dataBeans.get(i).getPic();
                           data.tvText=dataBeans.get(i).getTitle();
                           list.add(data);
                        }
                        modelInterface.successData(list);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
