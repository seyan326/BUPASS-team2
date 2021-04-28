package ac.baekseok.didstudentid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SignUp extends Activity {
    EditText s_name, s_email, s_pwd1, s_pwd2, s_number;
    ImageButton back;
    Button s_Registration, e_send;
    SQLiteDatabase sqlDB;
    myDBHelper myHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        back=(ImageButton)findViewById(R.id.back);
        s_name = (EditText)findViewById(R.id.s_name);
        s_number = (EditText)findViewById(R.id.s_number);
        s_email = (EditText)findViewById(R.id.s_email);
        s_pwd1 = (EditText)findViewById(R.id.s_pwd1);
        s_pwd2 = (EditText)findViewById(R.id.s_pwd2);
        s_Registration = (Button)findViewById(R.id.s_Registration);
        e_send = (Button)findViewById(R.id.e_send);

        myHelper = new myDBHelper(this);

        back.setOnClickListener(new View.OnClickListener() {
            // ImageButton을 누르면 메인페이지로 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        s_Registration.setOnClickListener(new View.OnClickListener() {
            // 회원가입화면에서 가입할 name,   PW를 EditText에 입력하고 btnRegistration 버튼을 누름
            // 회원가입 레코드가 1건 저장됨
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase(); //쓰기전용  DB열기
                sqlDB.execSQL("INSERT INTO SignUp_info VALUES ('" +
                        s_name.getText().toString() + "','" +
                        s_email.getText().toString() + "','" +
                        s_number.getText().toString() + "','" +
                        s_pwd1.getText().toString() + "','" + "')");   // 1건의 회원정보(레코드) 입력
                sqlDB.close(); // SignUp_info DB 닫기
                Toast.makeText(getApplicationContext(), "가입완료", Toast.LENGTH_LONG).show();
            }
        });

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitDiskReads().permitDiskWrites().permitNetwork().build());

        e_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    GMailSender sender = new GMailSender("username@gmail.com", "password");
                    sender.sendMail("This is Subject", "This is Body", "user@gmail.com", "user@yahoo.com");
                } catch (Exception e){
                    Log.e("SenMail", e.getMessage());
                }
            }
        });
    }   // onCreate

    public class myDBHelper extends SQLiteOpenHelper{
        public myDBHelper(Context context){
            super(context, "BUPASSLoginDB", null, 1);
        }   // 생성자 myDBHelper()
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE SignUp_info(s_name TEXT, s_pwd1 TEXT , s_number TEXT, s_email TEXT);");
        }   //onCreate()

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS SignUp_info");
            onCreate(db);
        }   // onUpgrade()
    }   // myDBHelper
}   // MainActivity
