package com.example.newaa;

import java.util.ArrayList;
import java.util.HashMap;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
//首页的fragment
public class FisrtFragment extends Fragment{
	Toast toast;
public FisrtFragment() {
	// TODO Auto-generated constructor stub
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
	View rootView = inflater.inflate(R.layout.fragment_first, container,false);	
	final DBAdapter db = new DBAdapter(getActivity());
	Button addButton = (Button) rootView.findViewById(R.id.addbutton);
	Button quanbuButton=(Button)rootView.findViewById(R.id.quanbu);
						addButton.setOnClickListener(new View.OnClickListener() {
												@Override
												public void onClick(View v) {
													// TODO Auto-generated method stub
													startActivity(new Intent(getActivity(), AddDataActivity.class));
													getActivity().finish();
							}
						});
						quanbuButton.setOnClickListener(new View.OnClickListener() {
							
												@Override
												public void onClick(View v) {
													// TODO Auto-generated method stub
													db.open();
													Cursor c = db.getAllTitles();
													if (c.moveToFirst())
													{
													do {
													DisplayTitle(c);
													} while (c.moveToNext());
													}
										  	db.close();
												}
						});
						ListView list = (ListView) rootView.findViewById(R.id.listview01);
				        //设置一个map放入数据
				        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
				        db.open();
				 
						Cursor c = db.getAllTitles();
						if (c.moveToFirst())
						{
						do {
							HashMap<String, Object> map = new HashMap<String, Object>();					           
				        	map.put("ItemName", "姓名: "+c.getString(1));
				        	map.put("ItemAddress","地址:  " +c.getString(2));
				        	map.put("ItemMessage", "时间:"+c.getString(4));
				        	listItem.add(map);
						} while (c.moveToNext());
						}
			  	     db.close();
				        //设置一个匹配器
				        SimpleAdapter listItemAdapter = new SimpleAdapter(getActivity(),listItem,//����Դ 
				            R.layout.list_items,//ListItem 的布局文件				  
				            new String[] {"ItemName","ItemAddress", "ItemMessage"}, 				         
				            new int[] {R.id.ItemName,R.id.ItemAddress,R.id.ItemMessage}
				        );				
				        list.setAdapter(listItemAdapter);
	return rootView;
}

public void DisplayTitle(Cursor c)
{
if(c==null)return;
Toast.makeText(getActivity(),"编号: " + c.getString(0) + "\n" +"姓名: " + c.getString(1) + "\n" +"地址：" + c.getString(2) + "\n" +"备注： " + c.getString(3),Toast.LENGTH_SHORT).show();
}

}
