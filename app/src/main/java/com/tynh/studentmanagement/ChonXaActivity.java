package com.tynh.studentmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ChonXaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_xa);
    }
    public void goBack(View v){
        Intent intent=new Intent();
        EditText editText = (EditText) findViewById(R.id.editText3);
        intent.putExtra("data",editText.getText().toString().trim());
        setResult(50, intent);
        finish();
    }
}
