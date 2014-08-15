package com.example.newaa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment{
public SecondFragment() {
	// TODO Auto-generated constructor stub
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	View rootView = inflater.inflate(R.layout.fragment_second,
			container, false);
	int i=0;
	int j=9;
	return rootView;
}
}
