package com.fkomuniku.scanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView tv_result;
    LinearLayout btn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_result = findViewById(R.id.tv_result);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final String result = getIntent().getStringExtra("result");

        tv_result.setText(result);

        tv_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/search?safe=strict&sxsrf=ALeKk03F9zoDeTPnt9y51pDCv-cvmFFGnw%3A1614609628946&source=hp&ei=3Pw8YP_DN9O38QORqqjQBg&iflsig=AINFCbYAAAAAYD0K7GwFKH3MDGKqqP5WmmwMgWtmu7Oa&q="+result +"&oq=test&gs_lcp=Cgdnd3Mtd2l6EAMyCggAELEDEIMBEEMyBAgAEEMyBAgAEEMyAggAMgUIABCxAzIFCAAQsQMyBQgAELEDMggIABCxAxCDATIECAAQCjICCAA6BwgjEOoCECc6BAgjECc6DQgAELEDEMcBEKMCEENQoiRYrSdgmSloAXAAeACAAaABiAHxA5IBAzAuNJgBAKABAaoBB2d3cy13aXqwAQo&sclient=gws-wiz&ved=0ahUKEwj_oYfLqY_vAhXTW3wKHREVCmoQ4dUDCAY&uact=5"));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ResultActivity.this, Scanner.class);
        startActivity(intent);
        this.finish();
    }
}
