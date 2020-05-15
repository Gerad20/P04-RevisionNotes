package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button insertBtn;
    Button show;
    //for insert connection
    EditText noteContent;
    RadioGroup starsNum;
    RadioButton amountChosen;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertBtn = findViewById(R.id.buttonInsertNote);
        noteContent = findViewById(R.id.editTextNote);
        starsNum = findViewById(R.id.radioGroupStars);
        show = findViewById(R.id.buttonShowList);


        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper db = new DBHelper(MainActivity.this);

                int selectedId = starsNum.getCheckedRadioButtonId();

                amountChosen = (RadioButton)findViewById(selectedId);

                int ChosenNumber = Integer.parseInt(amountChosen.getText().toString());
                String content = noteContent.getText().toString();

                db.insertNote(content,ChosenNumber);
                db.close();
                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
