package com.kumsam.nav_draw_bysetup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String country= getIntent().getStringExtra("country");
        TextView textView=findViewById(R.id.textView2);
        textView.setText(country);
    }
}
