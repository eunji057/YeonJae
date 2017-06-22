package kr.hs.emirim.yeonjae0331.gume;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by 우연재 on 2016-11-10.
 */
public class ApplicationActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton back;
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_application);

        back=(ImageButton)findViewById(R.id.back);

        back.setOnClickListener(this);
    }

    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch(v.getId()) {
            case R.id.back:
                intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
        }
    }
}