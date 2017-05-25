package com.bs.hjsyxt.ui.contract;

import com.bs.hjsyxt.base.BaseContract;

/**
 * Created by wf on 2017/5/25.
 */

public interface LoginContract {

    interface View extends BaseContract.BaseView {
        void onLoginSuccess();
        void onLoginFaild(String msg);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{

        void LoginCUser(String usernmame,String psw);

        void LoginIUser(String usernmame,String psw);
    }
}
