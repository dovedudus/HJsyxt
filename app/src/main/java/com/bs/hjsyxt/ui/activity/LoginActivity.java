package com.bs.hjsyxt.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.bs.hjsyxt.R;

public class LoginActivity extends Activity {

    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt_login = (Button) this.findViewById(R.id.btn_login);
        bt_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //进入注册界面
                Intent SignupIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(SignupIntent);
            }
        });
    }

}
