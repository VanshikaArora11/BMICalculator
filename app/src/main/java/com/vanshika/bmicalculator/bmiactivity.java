package com.vanshika.bmicalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmiactivity extends AppCompatActivity {
    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;
    String height;
    String weight;
    String age;
    float intheight,intweight;
    RelativeLayout mbackground;


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setTitle(Html.fromHtml("<fontcolor=\"white\"</font>"));
            getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
         intent=getIntent();
         mbmidisplay = findViewById(R.id.bmidisplayage);
         mimageview = findViewById(R.id.imageview);
        mbmicategory = findViewById(R.id.bmicategorydisplay);
        mrecalculatebmi = findViewById(R.id.recalculatebmi);
         mgender = findViewById(R.id.genderdisplay);
         mbackground = findViewById(R.id.contentlayout);
         height=intent.getStringExtra("height");
         weight=intent.getStringExtra("weight");
         age = intent.getStringExtra("age");
         mbmidisplay.setText(Integer.toString(Integer.parseInt(age)));
         intheight=intheight/100;
         intbmi=intweight/(intheight*intheight);
         mbmi=Float.toString(intbmi);
         if (intbmi<16)
                {
                    mbmicategory.setText("Severe Thinness");
                    mbackground.setBackgroundColor(Color.RED);
                    mimageview.setImageResource(R.drawable.crosss);
                }
        else if (intbmi < 16.99 && intbmi > 16) {
                    mbmicategory.setText("Moderate Thinness");
                    mbackground.setBackgroundColor(Color.RED);
                    mimageview.setImageResource(R.drawable.warning);
                }
        else if (intbmi < 18.4 && intbmi > 17) {
                    mbmicategory.setText("Mild Thinness");
                    mbackground.setBackgroundColor(Color.RED);
                    mimageview.setImageResource(R.drawable.warning);
                }
        else if (intbmi < 25 && intbmi > 18.4) {
                    mbmicategory.setText("Normal");
                    mbackground.setBackgroundColor(Color.YELLOW);
                    mimageview.setImageResource(R.drawable.ok);
                }
        else if (intbmi < 29 && intbmi > 25) {
                    mbmicategory.setText("Overweight");
                    mbackground.setBackgroundColor(Color.RED);
                    mimageview.setImageResource(R.drawable.warning);
                }
        else {
                    mbmicategory.setText("Obese Class");
                    mbackground.setBackgroundColor(Color.RED);
                    mimageview.setImageResource(R.drawable.warning);
                }

        mgender.setText(intent.getStringExtra("gender"));
        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
