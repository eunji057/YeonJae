package kr.hs.emirim.yeonjae0331.gume;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by 우연재 on 2016-11-22.
 */
public class ReadDBActivity extends AppCompatActivity{
    Button butInit;
    TextView read_bird;
    ImageButton back;
    SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbread);

        butInit=(Button)findViewById(R.id.but_init);
        read_bird=(TextView)findViewById(R.id.read_bird);
        back=(ImageButton)findViewById(R.id.back_db);

        butInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=MainActivity.dbHelper.getWritableDatabase();
                MainActivity.dbHelper.onUpgrade(db, 1, 2);
                db.close();
                ;
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(ReadDBActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Toast.makeText(getApplicationContext(), "ReadDBActivity",Toast.LENGTH_SHORT).show();
        db=MainActivity.dbHelper.getReadableDatabase();
        Cursor rs=db.rawQuery("select * from idoltable", null);
        String gname="접은 고민"+"\n"+"==========="+"\n";
        while (rs.moveToNext()){
            gname+=rs.getString(0)+"\n";
        }
        read_bird.setText(gname);
        rs.close();
        db.close();
    }


    public void onBackPressed() {
        //super.onBackPressed();
    }
}
