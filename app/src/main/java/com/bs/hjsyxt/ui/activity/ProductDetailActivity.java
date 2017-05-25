package com.bs.hjsyxt.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.bs.hjsyxt.R;
import com.bs.hjsyxt.app.HjsApplication;
import com.bs.hjsyxt.bean.ProductInfo;
import com.bs.hjsyxt.bean.Supply;
import com.bs.hjsyxt.component.DaggerAllComponent;
import com.bs.hjsyxt.ui.adapter.SupplyAdapter;
import com.bs.hjsyxt.ui.contract.ProductDetailContract;
import com.bs.hjsyxt.ui.presenter.ProductDetailPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailActivity extends AppCompatActivity implements ProductDetailContract.View{

    @BindView(R.id.tv_name)
    public TextView tv_name;
    @BindView(R.id.tv_company)
    public TextView tv_company;
    @BindView(R.id.tv_proarea)
    public TextView tv_proarea;
    @BindView(R.id.tv_manudata)
    public TextView tv_manudata;
    @BindView(R.id.tv_usedata)
    public TextView tv_usedata;

    @BindView(R.id.tv_update)
    public TextView btnUpdate;

    @BindView(R.id.lv_jingxiao)
    public ListView lv_jingxiao;

    public SupplyAdapter adapter;

    ProductInfo data;
    @Inject
    ProductDetailPresenter productDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ButterKnife.bind(this);
        setComponent();

        adapter = new SupplyAdapter(new ArrayList<Supply>(), this);
        lv_jingxiao.setAdapter(adapter);

        //接受扫描二维码获得的信息
        Bundle bundle = this.getIntent().getExtras();
        //接收result值
        String id = bundle.getString("result");

        productDetailPresenter.attachView(this);
        productDetailPresenter.getProductDetail(id);

    }

    public void setComponent() {
        DaggerAllComponent.builder()
                .appComponent(HjsApplication.getsInstance().getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    public void showProductDetail(ProductInfo data) {
        this.data = data;
        //显示详细产品
        tv_name.setText(data.product.name);
        tv_company.setText(data.shengchan.name);
        tv_proarea.setText(data.product.check_info);
        tv_manudata.setText(data.product.manu_date);
        tv_usedata.setText(data.product.use_date);
        adapter.setData(data.jinxiao);
        adapter.notifyDataSetChanged();

        if(HjsApplication.getsInstance().userType == 1) {
            btnUpdate.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.tv_update)
    public void onClickUpDate(){
        productDetailPresenter.putSupplychain(data.product.id);
    }


    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }
}
