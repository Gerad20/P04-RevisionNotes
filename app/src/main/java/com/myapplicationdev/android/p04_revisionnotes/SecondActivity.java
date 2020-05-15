package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView displayContent;

	RevisionNotesArrayAdapter aa;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView
		setContentView(R.layout.activity_second);
		displayContent = findViewById(R.id.lv);

		DBHelper db = new DBHelper(SecondActivity.this);

		ArrayList<Note> data = db.getAllNotes();
		db.close();



		ArrayAdapter aa = new RevisionNotesArrayAdapter(getApplicationContext(),R.layout.row,data);
		displayContent.setAdapter(aa);



	}


}
