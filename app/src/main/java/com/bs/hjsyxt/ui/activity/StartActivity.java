package com.bs.hjsyxt.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bs.hjsyxt.R;

public class StartActivity extends AppCompatActivity {

    private Button bt_signin;
    private Button bt_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        bt_signin = (Button) this.findViewById(R.id.btn_signin);
        bt_signup = (Button) this.findViewById(R.id.btn_signup);

        bt_signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //进入登录界面
                Intent SigninIntent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(SigninIntent);
            }
        });

        bt_signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //进入注册界面
                Intent SignupIntent = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(SignupIntent);
            }
        });

    }

}
