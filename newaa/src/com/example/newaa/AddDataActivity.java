package com.example.newaa;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts.Data;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDataActivity extends Activity {//添加数据的activity

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);		
		 Button baocunButton=(Button)findViewById(R.id.baocun);

			final DBAdapter db = new DBAdapter(this);
		 baocunButton.setOnClickListener(new View.OnClickListener() {//保存按钮
			
			@Override
			public void onClick(View v) {
				 EditText datatEditText=(EditText)findViewById(R.id.shijian_text);
				 EditText nameEditText=(EditText)findViewById(R.id.renwu_text);
				 EditText messagEditText=(EditText)findViewById(R.id.beizhu_text);
				 EditText addressEditText=(EditText)findViewById(R.id.didian_text);
				 Data firstData;
				 String name;
				 String message;
				 String address;
				// TODO Auto-generated method stub
				 
				name=nameEditText.getText().toString();
				message=messagEditText.getText().toString();
				address=addressEditText.getText().toString();
			
			   db.open();
			   long id=db.insertTitle(name, address, message);			
	        	db.close();
	        	Toast.makeText(AddDataActivity.this,"这是第"+id+"个信息",Toast.LENGTH_SHORT).show();
			
				Intent intent = new Intent();   
				intent.setClass(AddDataActivity.this, MainActivity.class);  
				startActivity(intent); 
				finish();
			}
		});
	}
	 @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	    	if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
	    		Intent intent = new Intent();    
				intent.setClass(AddDataActivity.this, MainActivity.class);  
				startActivity(intent); 
				finish();
	    		return true;
	    	} else
	    		return super.onKeyDown(keyCode, event);
	    }

	 
	
}
