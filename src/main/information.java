package main;


import com.example.cproject.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class information extends Activity{
	private ImageView head;
	private TextView name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m_information);
		head=(ImageView) findViewById(R.id.m_information_head);
		name=(TextView)findViewById(R.id.m_information_name);
//		int headint=getIntent("information_head");
//		head.setImageResource();
		String headName=getIntent().getStringExtra("information_name");
		name.setText(headName);
		
	}
}
