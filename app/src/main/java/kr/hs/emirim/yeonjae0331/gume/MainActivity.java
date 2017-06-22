package kr.hs.emirim.yeonjae0331.gume;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton main_but1, main_but2, main_but3, main_but4;
    ImageView bird, airplane;
    private BackPressCloseHandler backPressCloseHandler;
    static MyDBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper=new MyDBHelper(getApplicationContext());

        setContentView(R.layout.activity_main);

        final Animation animAir= AnimationUtils.loadAnimation(this, R.anim.airplane);
        final Animation animBird= AnimationUtils.loadAnimation(this, R.anim.bird);

        main_but1=(ImageButton) findViewById(R.id.main_but1);
        main_but2=(ImageButton)findViewById(R.id.main_but2);
        main_but3=(ImageButton)findViewById(R.id.main_but3);
        main_but4=(ImageButton)findViewById(R.id.main_but4);

        bird=(ImageView)findViewById(R.id.bird);
        airplane=(ImageView)findViewById(R.id.airplane);

        main_but1.setOnClickListener(this);
        main_but2.setOnClickListener(this);
        main_but3.setOnClickListener(this);
        main_but4.setOnClickListener(this);

        airplane.startAnimation(animAir);
        bird.startAnimation(animBird);

        backPressCloseHandler = new BackPressCloseHandler(this);
    }
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch(v.getId()){
            case R.id.main_but1:
                intent=new Intent(this, WriteBirdActivity.class);
                startActivity(intent);
                break;
            case R.id.main_but2:
                intent=new Intent(this, WriteAirActivity.class);
                startActivity(intent);
                break;
            case R.id.main_but3:
                intent=new Intent(this, ReadDBActivity.class);
                startActivity(intent);
                break;
            case R.id.main_but4:
                intent=new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
        }
    }

    public class MyDBHelper extends SQLiteOpenHelper {
        public MyDBHelper(Context context){
            super(context, "idoldb", null, 2);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table idoltable(gname char(100));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists idoltable ");
            onCreate(db);
        }
    }

}
