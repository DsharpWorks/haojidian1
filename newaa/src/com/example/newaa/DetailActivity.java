package com.example.newaa;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity {

	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
        TextView timeTextView=(TextView)findViewById(R.id.time_show);
        TextView nameTextView=(TextView)findViewById(R.id.name_show);
        TextView addressTextView=(TextView)findViewById(R.id.address_show);
        TextView noteTextView=(TextView)findViewById(R.id.note_show);
        Button exitButton=(Button)findViewById(R.id.exit_show);
        Button deleteButton=(Button)findViewById(R.id.delete_show);
        Intent intent=this.getIntent();
		Bundle bundle=intent.getExtras();
        final DBAdapter db = new DBAdapter(DetailActivity.this);    
       final int i= bundle.getInt("v");
       db.open();
       Cursor cursor = db.getTitle(i);
       if(cursor.moveToFirst()){
        timeTextView.setText(cursor.getString(4));
        nameTextView.setText(cursor.getString(1));
        addressTextView.setText(cursor.getString(2));
        noteTextView.setText(cursor.getString(3));
       }
       else {
		Toast.makeText(this, "数据错误", Toast.LENGTH_SHORT).show();
	}
       db.close();
       exitButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent1=new Intent();
			intent1.setClass(DetailActivity.this, MainActivity.class);
			startActivity(intent1);
			finish();			
		}
	});
       deleteButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			db.open();
			db.deleteTitle(i);
			db.close();
			Intent intent2=new Intent();
			intent2.setClass(DetailActivity.this, MainActivity.class);
			startActivity(intent2);
			finish();	
			}
	});
	}
     
}
