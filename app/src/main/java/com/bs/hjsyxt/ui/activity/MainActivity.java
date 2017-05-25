package com.bs.hjsyxt.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.bs.hjsyxt.R;

public class MainActivity extends AppCompatActivity {

    private Button bt_scan;
    private Button bt_company;
    private Button bt_notice;
    private Button bt_feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_scan = (Button) this.findViewById(R.id.btn_scan);
        bt_company = (Button) this.findViewById(R.id.btn_company);
        bt_notice = (Button) this.findViewById(R.id.btn_notice);
        bt_feedback = (Button) this.findViewById(R.id.btn_feedback);

        bt_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开扫描界面扫描条形码或二维码
                Intent openCameraIntent = new Intent(MainActivity.this, CaptureActivity.class);
                Log.e("johnny","hello");
                startActivity(openCameraIntent);
            }
        });

    }
}
