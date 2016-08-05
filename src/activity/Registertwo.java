package activity;



import com.example.cproject.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import net.SendDataToServer;


public class Registertwo extends Activity implements OnClickListener{
	private TextView height,weight,occupation,address;
	private Spinner sex,dateY,dateM,dateD,zodiac;
	private Button register;
	
	private static final String[] sex_data=new String[]{"男","女"};
	private static final String[] Y_data={"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012"};
	private static final String[] M_data={"1","2","3","4","5","6","7","8","9","10","11","12"};
	private static final String[] D_data={"1","2","3","4","5","6","7","8","9","10",
											"11","12","13","14","15","16","17","18","19","20",
											"21","22","23","24","25","26","27","28","29","30"};
	private static final String[] zodiac_data={
			"白羊座","金牛座","双子座","巨蟹座",
			"狮子座","处女座","天秤座","天蝎座",
			"射手座","魔羯座","水瓶座","双鱼座"
	};
	
	private ArrayAdapter<String> adapterSex;
	private ArrayAdapter<String> adapterY; 
	private ArrayAdapter<String> adapterM; 
	private ArrayAdapter<String> adapterD; 
	private ArrayAdapter<String> adapterZodiac; 
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_registertwo);
		height=(TextView)findViewById(R.id.r_height);
		weight=(TextView)findViewById(R.id.r_weight);
		occupation=(TextView)findViewById(R.id.r_occupation);
		address=(TextView)findViewById(R.id.r_address);
		
		sex=(Spinner)findViewById(R.id.sex);
		dateY=(Spinner)findViewById(R.id.r_dateY);
		dateM=(Spinner)findViewById(R.id.r_dateM);
		dateD=(Spinner)findViewById(R.id.r_dateD);
		zodiac=(Spinner)findViewById(R.id.r_zodiac);
		
		register=(Button)findViewById(R.id.r_register);
		register.setOnClickListener(this);
		
		adapterSex=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sex_data);
		adapterY=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Y_data);
		adapterM=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,M_data);
		adapterD=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,D_data);
	adapterZodiac=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,zodiac_data);
		
	
		sex.setAdapter(adapterSex);
		dateY.setAdapter(adapterY);
		dateM.setAdapter(adapterM);
		dateD.setAdapter(adapterD);
		zodiac.setAdapter(adapterZodiac);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.r_register:
			saveData();
			Intent intent=new Intent(Registertwo.this,Registerthree.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}
	public void saveData(){
		//从界面一传过来的数据
		Intent intent=getIntent();
		String nameData=intent.getStringExtra("name");
		String passwordData=intent.getStringExtra("password");
		String eamilData=intent.getStringExtra("email");
		
		String sexData=sex.getSelectedItem().toString();
		String heightData=height.getText().toString();
		String weightData=weight.getText().toString();
		String zodiacData=zodiac.getSelectedItem().toString();
		String occupationData=occupation.getText().toString();
		String addressData=address.getText().toString();
		
		String Register="Register";
		
		String Date=dateY.getSelectedItem().toString()+"-"+
		dateM.getSelectedItem().toString()+"-"+
		dateD.getSelectedItem().toString();
		SendDataToServer SDTS=new SendDataToServer(
				nameData,passwordData,eamilData,sexData,
				Date,heightData,weightData,
				zodiacData,occupationData,addressData,Register
				);
		SDTS.SendDataToServers();
	}
}
