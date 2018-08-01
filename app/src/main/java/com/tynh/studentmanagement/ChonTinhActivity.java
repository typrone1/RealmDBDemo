package com.tynh.studentmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChonTinhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_tinh);
    }
    public void chonHuyen(View v){
        Intent intent=new Intent(this, ChonHuyenActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
//        startActivity(intent);
        startActivityForResult(intent, 100);
    }

//    Intent intent = new Intent(this, ChonTinhActivity.class);

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 50){
            setResult(resultCode, data);
            finish();
        }
    }

}
