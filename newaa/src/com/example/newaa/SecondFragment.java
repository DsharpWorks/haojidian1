package com.example.newaa;

import android.R.integer;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class SecondFragment extends Fragment{
private DBAdapter db;	
private ListView diaryList;
public SecondFragment() {
	// TODO Auto-generated constructor stub
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	
	View rootView = inflater.inflate(R.layout.fragment_second,
			container, false);
	diaryList=(ListView)rootView.findViewById(R.id.listview02);
	db=new DBAdapter(getActivity());
	Refresh();//刷新listview
    diaryList.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			int intid=(int) id;	//强行转换，不过如果id确实很大会有问题
			Intent intent=new Intent();
			intent.setClass(getActivity(), DetailActivity.class);
			Bundle bundle = new Bundle();  
			bundle.putInt("v", intid);			
			intent.putExtras(bundle);  		
			startActivity(intent);
			getActivity().finish();
		}
	});
	return rootView;
}

private void Refresh()//刷新listview
{
	
	db.open(); 
	Cursor cursor =db.getAllTitles();
	@SuppressWarnings("deprecation")
	SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(getActivity(), R.layout.list_items,  
            cursor, 
            new String[]{"name","data"},  
            new int[]{R.id.ItemName,R.id.ItemMessage});          
    diaryList.setAdapter(listAdapter);
    db.close();
}
}
