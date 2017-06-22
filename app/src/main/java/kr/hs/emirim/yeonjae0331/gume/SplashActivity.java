package kr.hs.emirim.yeonjae0331.gume;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 우연재 on 2016-11-08.
 */
public class SplashActivity extends AppCompatActivity {

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        //    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, R.anim.zoom_exit);
                finish();
            }
        },3000);   //3000밀리세컨드 ->3초
    }
}
