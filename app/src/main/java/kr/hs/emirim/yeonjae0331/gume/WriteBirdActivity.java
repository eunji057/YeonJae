package kr.hs.emirim.yeonjae0331.gume;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by 우연재 on 2016-11-08.
 */
public class WriteBirdActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;  //dbName=tv
    ImageButton back_main;
    ImageButton fly_bird_but;
    String currentDateTimeString;
    EditText bird_content;

    SQLiteDatabase db;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_writebird);

        fly_bird_but = (ImageButton) findViewById(R.id.write_bird_but3);
        back_main = (ImageButton) findViewById(R.id.back_main);

        bird_content=(EditText)findViewById(R.id.bird_content);


        fly_bird_but.setOnClickListener(this);
        back_main.setOnClickListener(this);



        fly_bird_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                db=MainActivity.dbHelper.getWritableDatabase();
                db.execSQL("insert into idoltable values('" +bird_content.getText().toString()+ "');");
                db.close();

              //  Toast.makeText(getApplicationContext(), "정상적으로 입력 완료",Toast.LENGTH_SHORT).show();
                intent = new Intent(v.getContext(), FlyBirdActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        //버튼을 누르면 종이학이 접히는 activity로 가기! (intent)
        switch (v.getId()) {
            case R.id.write_bird_but3:
                intent = new Intent(this, FlyBirdActivity.class);
                startActivity(intent);
                break;
            case R.id.back_main:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

    }

    /*
    public class MyDBHelper extends SQLiteOpenHelper{
        public MyDBHelper(Context context){
            super(context, "idoldb", null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table idoltable(gname char(100) primary key);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists idoltable ");
            onCreate(db);
        }
    }*/
}
