package com.bs.hjsyxt.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.bs.hjsyxt.R;
import com.bs.hjsyxt.app.HjsApplication;
import com.bs.hjsyxt.component.DaggerAllComponent;
import com.bs.hjsyxt.ui.contract.LoginContract;
import com.bs.hjsyxt.ui.presenter.LoginPresenter;
import com.bs.hjsyxt.utils.ToastUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{

    private Button bt_login;

    @BindView(R.id.et_loginname)
    EditText loginName;

    @BindView(R.id.et_loginpsw)
    EditText loginPsw;

    @BindView(R.id.spn_logintype)
    Spinner spinner;

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        ButterKnife.bind(this);
        setComponent();


        bt_login = (Button) this.findViewById(R.id.btn_login);
        bt_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //参数检查
               if(loginName.getText().equals("") || loginPsw.getText().equals("")) {
                   ToastUtils.showSingleToast("密码或账号为空");
                   return;
               }
                loginPresenter.attachView(LoginActivity.this);
               switch (HjsApplication.getsInstance().userType) {
                   case 0:
                      loginPresenter.LoginCUser(loginName.getText().toString(), loginPsw.getText().toString());
                      break;
                   case 1:
                       loginPresenter.LoginIUser(loginName.getText().toString(), loginPsw.getText().toString());
                       break;
                   default:
                       break;
               }

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                HjsApplication.getsInstance().userType = pos;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

    public void setComponent() {
        DaggerAllComponent.builder()
                .appComponent(HjsApplication.getsInstance().getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    public void onLoginSuccess() {

        Intent SignInIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(SignInIntent);
    }

    @Override
    public void onLoginFaild(String msg) {
        ToastUtils.showSingleToast(msg);
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }
}
