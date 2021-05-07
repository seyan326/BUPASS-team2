package ac.baekseok.didstudentid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class BupassProfessorActivity extends Activity {

    ImageButton back;
    Button attendance_check;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bupass_professor);

        back=(ImageButton)findViewById(R.id.back);
        attendance_check=(Button)findViewById(R.id.attendance_check);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        attendance_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AttendanceCheckProfessorActivity.class);
                startActivity(intent);
            }
        });

    }
}
