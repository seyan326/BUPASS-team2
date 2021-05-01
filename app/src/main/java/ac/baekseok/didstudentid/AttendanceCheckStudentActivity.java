package ac.baekseok.didstudentid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class AttendanceCheckStudentActivity extends Activity{
    ImageButton back;
    Button scanQR;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_check_s);

        back=(ImageButton)findViewById(R.id.back);
        scanQR=(Button)findViewById(R.id.scanQR);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BupassStudentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        scanQR.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(AttendanceCheckStudentActivity.this, ScanQR.class);
                startActivity(intent);
            }
        });
    }
}
