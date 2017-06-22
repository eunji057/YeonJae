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
public class FlyBirdActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView birdView;
    ImageButton bird_next;
    int data[]=new int[6];
    int cnt=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flybird);

        data[0]=R.drawable.bird_01;
        data[1]=R.drawable.bird_02;
        data[2]=R.drawable.bird_03;
        data[3]=R.drawable.bird_04;
        data[4]=R.drawable.bird_05;
        data[5]=R.drawable.bird_06;

        birdView=(ImageView)findViewById(R.id.birdView);
        bird_next=(ImageButton)findViewById(R.id.bird_next);

        bird_next.setOnClickListener(this);
    }
    public void forward(){
        if(cnt==data.length-1) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(FlyBirdActivity.this);

            dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent=new Intent(FlyBirdActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            dialog.setTitle("☆고민을 접었습니다☆");
            dialog.setMessage("메인으로 돌아갑니다!!");

            dialog.show();
        }else{
           // Toast.makeText(this, "다음 사진", Toast.LENGTH_SHORT).show();
            cnt++;
            birdView.setImageResource(data[cnt]);
        }
    }
    public void onBackPressed() {
        //super.onBackPressed();
    }
    public void onClick(View v){
        Log.i("my info", "v의 값"+v);

        int id=v.getId();

        if(id==R.id.bird_next){
            forward();
        }
    }
}
