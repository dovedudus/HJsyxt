package com.bs.hjsyxt.app;

import android.app.Application;

import com.bs.hjsyxt.component.AppComponent;
import com.bs.hjsyxt.component.DaggerAppComponent;
import com.bs.hjsyxt.module.AppModule;
import com.bs.hjsyxt.module.HttpApiModule;
import com.bs.hjsyxt.utils.AppUtils;


/**
 * Created by wf on 2017/5/3.
 */

public class HjsApplication extends Application {

    private static HjsApplication sInstance;
    private AppComponent appComponent;
    //0消费者 1 经销商
    public int userType=0;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        AppUtils.init(this);
        initComponent();
    }

    public static HjsApplication getsInstance() {
        return sInstance;
    }

    private void initComponent() {
        //对所有依赖AppComponent的xxxActivityComponent都可以使用httpApi和context
        appComponent = DaggerAppComponent.builder()
                .httpApiModule(new HttpApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }



}
