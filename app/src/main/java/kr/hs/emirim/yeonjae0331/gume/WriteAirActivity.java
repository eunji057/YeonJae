package kr.hs.emirim.yeonjae0331.gume;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by 우연재 on 2016-11-08.
 */
public class WriteAirActivity extends AppCompatActivity implements View.OnClickListener{
 //   DatePicker datePicker;
    ImageButton air_but1;
    ImageButton back_main;
    String currentDateTimeString;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        setContentView(R.layout.activity_writeair);

        air_but1=(ImageButton)findViewById(R.id.air_but1);
        back_main=(ImageButton)findViewById(R.id.back_main);

        air_but1.setOnClickListener(this);
        back_main.setOnClickListener(this);


    }
    public void onBackPressed() {
        //super.onBackPressed();
    }
    @Override
    public void onClick(View v) {
        //버튼을 누르면 종이비행기가 접히는 activity로 가기! (intent)
        Intent intent;
        switch(v.getId()){
            case R.id.air_but1:
                intent=new Intent(this, FlyAirActivity.class);
                startActivity(intent);
                break;
            case R.id.back_main:
                intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

    }
}