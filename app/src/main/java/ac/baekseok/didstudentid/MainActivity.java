package ac.baekseok.didstudentid;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends SignUp {
    EditText s_email,s_pwd1;
    Button login, sign_up;

    int EFlag = 0;
    int PwdFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s_email = (EditText)findViewById(R.id.s_email);
        s_pwd1 = (EditText)findViewById(R.id.s_pwd1);
        login = (Button)findViewById(R.id.login);   // 버튼을 클릭하면 학생창 or 교수창으로 이동
        sign_up=(Button)findViewById(R.id.sign_up); // 버튼을 클릭하면 회원가입창으로 이동

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = s_email.getText().toString();
                String password = s_pwd1.getText().toString();
                if (email.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "잘못입력하였습니다. 이메일과 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                }else if(email.equals("professor@bu.ac.kr")|| password.equals("0000")){
                    Intent intent = new Intent(getApplicationContext(), BupassProfessorActivity.class);
                    startActivityForResult(intent, 1);
                    finish();
                } else{
                    Intent intent = new Intent(getApplicationContext(), BupassStudentActivity.class);
                    intent.putExtra("tjdydwns123@bu.ac.kr", email);
                    startActivityForResult(intent, 1);
                    finish();
                }
            /*    Cursor cursor;
                sqlDB=myHelper.getReadableDatabase();

                cursor = sqlDB.rawQuery("SELECT * FROM SignUp_info", null);
                String edt1 = null;
                String edt2 = null;
                String pass1 = null;
                String pass2 = null;

                EFlag = 0;
                PwdFlag = 0;

                while (cursor.moveToNext()){
                    edt2 = cursor.getString(0);
                    pass2 = cursor.getString(1);
                    edt1 = s_email.getText().toString();
                    pass1 = s_pwd1.getText().toString();

                    if (edt2.equals(edt1)){
                        EFlag = 1;
                        if (pass2.equals(pass1)){
                            PwdFlag = 1;
                            Toast.makeText(getApplicationContext(), "환영합니다.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "비밀번호가 틀렸습니다. 다시 입력하여주세요.", Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                    }
                }
                cursor.close();
                sqlDB.close();
                if (EFlag==0 && PwdFlag==0){
                    Toast.makeText(getApplicationContext(), "이메일이 잘못되었거나. 비회원입니다.", Toast.LENGTH_LONG).show();

                }*/
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });

    }
}