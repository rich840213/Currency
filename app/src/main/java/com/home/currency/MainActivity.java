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
                    .setTitle(R.string.problem)
                    .setMessage(R.string.please_enter_ntd)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        } else {
            double val = Integer.parseInt(ntd) / 30.9;
            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.usd_is) + new BigDecimal(val).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue())
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mNtd.setText("");
                        }
                    })
                    .show();
        }
    }
}
