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

public class ProductDetailActivity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_company;
    private TextView tv_proarea;
    private TextView tv_manudata;
    private TextView tv_usedata;
    private ListView lv_jingxiao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);



        //接受扫描二维码获得的信息
        Bundle bundle = this.getIntent().getExtras();
        //接收result值
        String name = bundle.getString("result");


    }

}
