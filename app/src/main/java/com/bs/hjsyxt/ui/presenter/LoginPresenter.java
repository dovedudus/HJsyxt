package com.bs.hjsyxt.ui.presenter;

import android.util.Log;

import com.bs.hjsyxt.api.HttpApi;
import com.bs.hjsyxt.base.RxPresenter;
import com.bs.hjsyxt.bean.User;
import com.bs.hjsyxt.ui.contract.LoginContract;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wf on 2017/5/25.
 */
public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter<LoginContract.View> {


    private HttpApi httpApi;

    private static final String TAG = "BookDetailPresenter";

    @Inject
    public LoginPresenter(HttpApi bookApi) {
        this.httpApi = bookApi;
    }

    @Override
    public void LoginCUser(String usernmame, String psw) {
        Log.d("maple","neter");

        //Rxjava 调用api获取数据并在ui线程装载数据
        Subscription rxSubscription =  httpApi.loginCUser(usernmame, psw).subscribeOn(Schedulers.io())//获取bookid 从io线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onNext(User data) {
                        Log.e("maple","login msg="+data.msg+"  result="+data.result);
                        if (data != null && mView != null) {
                            if(data.result == 0) {
                                mView.onLoginSuccess();
                            } else {
                                mView.onLoginFaild(data.msg);
                            }
                        }
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void LoginIUser(String usernmame, String psw) {
//        httpApi.loginIUser(usernmame, psw);
    }
}
