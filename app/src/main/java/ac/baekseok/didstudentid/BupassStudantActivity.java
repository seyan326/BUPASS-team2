package ac.baekseok.didstudentid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class BupassStudantActivity extends Activity {
    ImageButton back;
    Button studant_Id_Card, attendance_check;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bupass_studant);

        back=(ImageButton)findViewById(R.id.back);
        studant_Id_Card=(Button)findViewById(R.id.studant_Id_Card);
        attendance_check=(Button)findViewById(R.id.attendance_check);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        studant_Id_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StuantIDCardActivity.class);
                startActivity(intent);
            }
        });

        attendance_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClassDitailsStudantsActivity.class);
                startActivity(intent);
            }
        });

    }
}
