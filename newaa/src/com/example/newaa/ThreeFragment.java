package com.example.newaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ThreeFragment extends Fragment{//介绍fragment
public ThreeFragment() {
	// TODO Auto-generated constructor stub
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	View rootView = inflater.inflate(R.layout.fragment_three, container,
			false);
	Button dsharpbButton = (Button) rootView.findViewById(R.id.dsharp);
	Button weButton = (Button) rootView.findViewById(R.id.women);
	Button addusButton = (Button) rootView.findViewById(R.id.addwomen);
	dsharpbButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {//根据传过来的数据，跳转到相应的页面
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(getActivity(), DescribeActivity.class);
			Bundle bundle = new Bundle();  
			bundle.putInt("v", 1);
			intent.putExtras(bundle);  		
			startActivity(intent);

		}
	});
	int i=1;
	weButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(getActivity(), DescribeActivity.class);
			Bundle bundle = new Bundle();  
			bundle.putInt("v", 2);
			intent.putExtras(bundle);  		
			startActivity(intent);

		}
	});
	addusButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(getActivity(), DescribeActivity.class);
			Bundle bundle = new Bundle();  
			bundle.putInt("v", 3);
			intent.putExtras(bundle);  		
			startActivity(intent);

		}
	});
	return rootView;
}
}
