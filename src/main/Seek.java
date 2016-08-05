package main;



import com.example.cproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import layout.fragmentMe;
import layout.fragmentNews;
import layout.fragmentSeek;

public class Seek extends FragmentActivity implements OnCheckedChangeListener{
	private ViewPager viewPager;
	private RadioGroup group;
	
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.seek);
		group=(RadioGroup)findViewById(R.id.daohan);
		group.setOnCheckedChangeListener(this);
	}
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId){
		//动态加载布局
		case R.id.seek:
			fragmentSeek f_seek=new fragmentSeek();
			FragmentManager fragmentManagerS=getSupportFragmentManager();
			FragmentTransaction beginS=fragmentManagerS.beginTransaction();
			beginS.replace(R.id.show_frame, f_seek);
			beginS.addToBackStack(null);
			beginS.commit();
			break;
		case R.id.news:{
			fragmentNews f_news=new fragmentNews();
			FragmentManager fragmentManagerN=getSupportFragmentManager();
			FragmentTransaction beginN=fragmentManagerN.beginTransaction();
			beginN.replace(R.id.show_frame, f_news);
			beginN.addToBackStack(null);
			beginN.commit();
			break;
			}
		//静态加载布局
		case R.id.trend:
			Intent intent=new Intent(Seek.this,Text.class);
			startActivity(intent);
			break;
		case R.id.me:
			fragmentMe f_newM=new fragmentMe();
			FragmentManager fragmentManagerM=getSupportFragmentManager();
			FragmentTransaction beginM=fragmentManagerM.beginTransaction();
			beginM.replace(R.id.show_frame, f_newM);
			beginM.addToBackStack(null);
			beginM.commit();
			break;
			default:
				break;
		}
	}
	
	
	
	
	
	

	
}
