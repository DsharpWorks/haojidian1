package com.example.newaa;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	private Button sButton = null;
	private Button jButton = null;
	private Button qButton = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sButton = (Button) findViewById(R.id.sbutton);
		jButton = (Button) findViewById(R.id.jbutton);
		qButton = (Button) findViewById(R.id.qbutton);
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new FisrtFragment()).commit();

		}
		sButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.container, new FisrtFragment()).commit();
				sButton.setTextColor(getResources().getColor(R.color.skyblue));
				jButton.setTextColor(getResources().getColor(R.color.white));
				qButton.setTextColor(getResources().getColor(R.color.white));
			}
		});
		jButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.container, new SecondFragment())
						.commit();
				sButton.setTextColor(getResources().getColor(R.color.white));
				jButton.setTextColor(getResources().getColor(R.color.skyblue));
				qButton.setTextColor(getResources().getColor(R.color.white));
			}
		});
		qButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sButton.setTextColor(getResources().getColor(R.color.white));
				jButton.setTextColor(getResources().getColor(R.color.white));
				qButton.setTextColor(getResources().getColor(R.color.skyblue));
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.container, new ThreeFragment()).commit();
			}
			});
	}

	@Override
	// 退出键
	public boolean onKeyDown(int keyCode, KeyEvent event) {//重写回退键
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {//
			exit();
			return true;
		} else
			return super.onKeyDown(keyCode, event);
	}
//菜单
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {//菜单

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override//目录
	public boolean onOptionsItemSelected(MenuItem item) {//目录
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	
	
	protected void exit() {// 退出

		AlertDialog.Builder d1 = new AlertDialog.Builder(this);
		d1.setTitle("提示ʾ").setMessage("确定要退出吗")
				.setPositiveButton("确定", new Dialog.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Intent.ACTION_MAIN);
						intent.addCategory(Intent.CATEGORY_HOME);
						intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
						System.exit(0);
					}
				}).setNegativeButton("取消", new Dialog.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				}).show();
	}
	
}
