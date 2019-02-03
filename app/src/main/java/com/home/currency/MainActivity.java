package com.home.currency;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private EditText mNtd;
    private TextView mJp;
    private TextView mUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
    }

    private void findViewById() {
        mNtd = findViewById(R.id.ntd);
        mJp = findViewById(R.id.jp);
        mUs = findViewById(R.id.us);
    }

    public void go(View view) {
        String ntd = mNtd.getText().toString().trim();
        if (ntd.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK", null)
                    .show();
        } else {
            double val = Integer.parseInt(ntd) / 30.9;
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is " + new BigDecimal(val).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue())
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mNtd.setText("");
                        }
                    })
                    .show();
        }
    }
}
