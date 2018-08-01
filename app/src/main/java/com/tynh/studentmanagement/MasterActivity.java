package com.tynh.studentmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MasterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
    }
    public void chonTinh(View v) {
        Intent intent = new Intent(this, ChonTinhActivity.class);
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 50) {
            Toast.makeText(this, "Come back here", Toast.LENGTH_LONG).show();
            EditText mLabel = (EditText) findViewById(R.id.txtXa);
            mLabel.setText(data.getStringExtra("data"));
        }
    }
}
