package com.bs.hjsyxt.ui.presenter;

import android.util.Log;

import com.bs.hjsyxt.api.HttpApi;
import com.bs.hjsyxt.app.HjsApplication;
import com.bs.hjsyxt.base.RxPresenter;
import com.bs.hjsyxt.bean.ProductInfo;
import com.bs.hjsyxt.bean.User;
import com.bs.hjsyxt.ui.contract.ProductDetailContract;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wf on 2017/5/25.
 */

public class ProductDetailPresenter extends RxPresenter<ProductDetailContract.View> implements ProductDetailContract.Presenter<ProductDetailContract.View> {

    private HttpApi httpApi;

    private static final String TAG = "ProductDetailPresenter";

    @Inject
    public ProductDetailPresenter(HttpApi bookApi) {
        this.httpApi = bookApi;
    }
    @Override
    public void getProductDetail(String id) {
        //Rxjava 调用api获取数据并在ui线程装载数据
        Subscription rxSubscription =  httpApi.getProductDetail(id).subscribeOn(Schedulers.io())//获取bookid 从io线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductInfo>() {
                    @Override
                    public void onNext(ProductInfo data) {
                        if (data != null && mView != null) {
                            mView.showProductDetail(data);
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
    public void putSupplychain(String proId) {
        //Rxjava 调用api获取数据并在ui线程装载数据
        Subscription rxSubscription =  httpApi.putSupplyChain(proId,HjsApplication.getsInstance().userid).subscribeOn(Schedulers.io())//获取bookid 从io线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductInfo>() {
                    @Override
                    public void onNext(ProductInfo data) {

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
}
