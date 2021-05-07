package ac.baekseok.didstudentid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class AttendanceCheckProfessorActivity extends Activity {
    Button p_class1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_check_p);

        p_class1=(Button)findViewById(R.id.p_class1);

        p_class1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ClassWeekProfessor.class);
                startActivity(intent);
            }
        });

    }
}
