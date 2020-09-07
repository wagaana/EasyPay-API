package com.waglex.easypaytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nsiimbi.easypay.Request;

import static com.nsiimbi.easypay.Request.EP_REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new Request(MainActivity.this)
                            .setAmountToPay("500")
                            .setCurrency("UGX")
                            .setPaymentReason("some reason")
                            .setClientSecret("28b5c11ff5402dd7")
                            .setClientID("41238e5ca57bcc17")
                            .initialize();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Make sure you enable your device location", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EP_REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this, "EP_REQUEST_CODE", Toast.LENGTH_SHORT).show();
        }
    }
}