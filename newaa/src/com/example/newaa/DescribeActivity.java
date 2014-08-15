package com.example.newaa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DescribeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent=this.getIntent();
		Bundle bundle=intent.getExtras();
		if (bundle.getInt("v")==1) {
			setContentView(R.layout.activity_dsharp);
		}else if (bundle.getInt("v")==2) {
			setContentView(R.layout.activity_we);
		}else if ( bundle.getInt("v")==3) {
			setContentView(R.layout.activity_addus);
		}		
				
	}
}
