package kr.hs.emirim.yeonjae0331.gume;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 우연재 on 2016-11-08.
 */
public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton set_but1, set_but2, set_but3;
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        setContentView(R.layout.activity_setting);

        set_but1=(ImageButton)findViewById(R.id.set_but1);
        set_but2=(ImageButton)findViewById(R.id.set_but2);
        set_but3=(ImageButton)findViewById(R.id.back);

        set_but1.setOnClickListener(this);
        set_but2.setOnClickListener(this);
        set_but3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.set_but1:
                intent=new Intent(this, ApplicationActivity.class);
                startActivity(intent);
                break;
            case R.id.set_but2:
                intent=new Intent(this, DeveloperActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
