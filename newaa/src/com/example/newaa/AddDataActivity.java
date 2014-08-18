package com.example.newaa;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddDataActivity extends Activity {//添加数据的activity
	 TextView  dataEditText;
	 private int year;
	    private int month;
	    private int day;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);		
		 Button baocunButton=(Button)findViewById(R.id.baocun);
		 dataEditText=(TextView)findViewById(R.id.shijian_text);
			final DBAdapter db = new DBAdapter(this);
			
			//获取当前的日期
			 Calendar mycalendar=Calendar.getInstance(Locale.CHINA);
			Date mydate=new Date(); //获取当前日期Date对象
	        mycalendar.setTime(mydate);////为Calendar对象设置时间为当前日期	        
	        year=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
	        month=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
	        day=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
	        dataEditText.setText(year+"-"+(month+1)+"-"+day); //显示当前的年月日
			dataEditText.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
			new DatePickerDialog(AddDataActivity.this, Datelistener, year, month, day).show();
				}
			});
		 baocunButton.setOnClickListener(new View.OnClickListener() {//保存按钮
			
			@Override
			public void onClick(View v) {
			
				 EditText nameEditText=(EditText)findViewById(R.id.renwu_text);
				 EditText messagEditText=(EditText)findViewById(R.id.beizhu_text);
				 EditText addressEditText=(EditText)findViewById(R.id.didian_text);
				 String data;
				 String name;
				 String message;
				 String address;
				// TODO Auto-generated method stub
				 
				name=nameEditText.getText().toString();
				message=messagEditText.getText().toString();
				address=addressEditText.getText().toString();
			   data=dataEditText.getText().toString();
			   db.open();
			   long id=db.insertTitle(name, address, message,data);			
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

	 
	 private DatePickerDialog.OnDateSetListener Datelistener=new DatePickerDialog.OnDateSetListener()
	    {
	        /**params：view：该事件关联的组件
	         * params：myyear：当前选择的年
	         * params：monthOfYear：当前选择的月
	         * params：dayOfMonth：当前选择的日
	         */
	        @Override
	        public void onDateSet(DatePicker view, int myyear, int monthOfYear,int dayOfMonth) {
	            
	            
	            //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
	            year=myyear;
	            month=monthOfYear;
	            day=dayOfMonth;
	            //更新日期
	            updateDate();
	            
	        }
	        //当DatePickerDialog关闭时，更新日期显示
	        private void updateDate()
	        {
	            //在TextView上显示日期
	            dataEditText.setText(year+"-"+(month+1)+"-"+day);
	        }
	    };
}
