package kr.hs.emirim.yeonjae0331.gume;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ViewFlipper;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 우연재 on 2016-11-09.
 */
public class FlyAirActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView airView;
    ImageButton air_next;
    int data[]=new int[6];
    int cnt=0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flyair);

        data[0]=R.drawable.air_01;
        data[1]=R.drawable.air_02;
        data[2]=R.drawable.air_03;
        data[3]=R.drawable.air_04;
        data[4]=R.drawable.air_05;
        data[5]=R.drawable.air_06;

        airView=(ImageView)findViewById(R.id.airView);
        air_next=(ImageButton)findViewById(R.id.air_next);
        air_next.setOnClickListener(this);

    }
    public void forward(){
        //Intent intent;
        if(cnt==data.length-1) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(FlyAirActivity.this);

            dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent=new Intent(FlyAirActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            dialog.setTitle("☆고민을 접었습니다☆");
            dialog.setMessage("메인으로 돌아갑니다!!");

            dialog.show();



          //  Toast.makeText(this, "마지막 비행기", Toast.LENGTH_SHORT).show();
        }else{
        //    Toast.makeText(this, "다음 사진", Toast.LENGTH_SHORT).show();
            cnt++;
            airView.setImageResource(data[cnt]);
        }
    }
    public void onBackPressed() {
        //super.onBackPressed();
    }
    public void onClick(View v){
        Log.i("my info", "v의 값"+v);

        int id=v.getId();

        if(id==R.id.air_next){
            forward();
        }
    }
}
