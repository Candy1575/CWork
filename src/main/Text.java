package main;

import com.example.cproject.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Text extends Activity implements OnClickListener{
	private Spinner sex, zodiac, occupation;
	private static final String[] sex_data = new String[] { "男", "女" };
	private static final String[] occupation_data = { "student", "teacher", "engineer", "worker", "farmer" };
	private static final String[] zodiac_data = { "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "魔羯座",
			"水瓶座", "双鱼座" };

	private ArrayAdapter<String> adapterSex;
	private ArrayAdapter<String> adapterZodiac;
	private ArrayAdapter<String> adapterOccupation;
	
	private TextView old1;
	private TextView old2;
	private TextView height1;
	private TextView height2;
	private TextView weight1;
	private TextView weight2;
	
	private Button Find;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_fragment);
		initView();
		Find.setOnClickListener(this);
		

		// //获取fragment里面的button
		// Button button=(Button)findViewById(R.id.button1);
		// button.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// Toast.makeText(Text.this, "this is ok", Toast.LENGTH_LONG).show();
		// }
		// });
	}

	public void initView() {
		old1=(TextView)findViewById(R.id.editText1);
		old2=(TextView)findViewById(R.id.editText2);
		height1=(TextView)findViewById(R.id.editText3);
		height2=(TextView)findViewById(R.id.editText4);
		weight1=(TextView)findViewById(R.id.editText5);
		weight2=(TextView)findViewById(R.id.editText6);
		
		
		sex = (Spinner) findViewById(R.id.seek_find_sex);
		zodiac = (Spinner) findViewById(R.id.seek_find_zodiac);
		occupation = (Spinner) findViewById(R.id.seek_find_occupation);

		adapterSex = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sex_data);
		adapterZodiac = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, zodiac_data);
		adapterOccupation = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, occupation_data);

		sex.setAdapter(adapterSex);
		zodiac.setAdapter(adapterZodiac);
		occupation.setAdapter(adapterOccupation);
		
		Find=(Button)findViewById(R.id.seek_find_button);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.seek_find_button:
			upload();
			break;
		default:
			break;
		}
	}
	
	public void upload(){
		String old1Data=old1.getText().toString();
		String old2Data=old2.getText().toString();
		String height1Data=height1.getText().toString();
		String height2Data=height2.getText().toString();
		String weight1Data=weight1.getText().toString();
		String weight2Data=weight2.getText().toString();
		
		String sexData=sex.getSelectedItem().toString();
		String zodiacData=zodiac.getSelectedItem().toString();
		String occupationData=occupation.getSelectedItem().toString();
		
		
		
		
		
	}
	
	
	
}
