package com.bs.hjsyxt.component;

import com.bs.hjsyxt.ui.activity.LoginActivity;

import dagger.Component;

/**
 * Created by wf on 2017/5/25.
 */

@Component(dependencies = AppComponent.class)
public interface AllComponent {

    //登录界面
    LoginActivity inject(LoginActivity activity);
}
