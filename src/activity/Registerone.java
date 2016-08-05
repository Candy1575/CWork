package activity;

import com.example.cproject.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import net.SendDataToServer;

public class Registerone extends Activity implements OnClickListener{
	public TextView user_name,password,confirm_password,email,identifying_code;
	public ImageView identifyingImage;
	public TextView changeImageView;
	public Button nextRegister;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_registerone);
		user_name=(TextView)findViewById(R.id.r_name);
		password=(TextView)findViewById(R.id.r_password);
		confirm_password=(TextView)findViewById(R.id.r_confirmpassword);
		email=(TextView)findViewById(R.id.r_email);
		
		changeImageView=(TextView)findViewById(R.id.r_changeImageView);
		changeImageView.setClickable(true);
		changeImageView.setFocusable(true);
		changeImageView.setOnClickListener(this);
		nextRegister=(Button)findViewById(R.id.r_nextRegister);
		nextRegister.setOnClickListener(this);
		identifying_code=(TextView)findViewById(R.id.r_identifying);
		identifyingImage=(ImageView)findViewById(R.id.r_identifyImage);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		//换一张验证码
		case R.id.r_changeImageView:
			if(password.getText().toString().equals(confirm_password.getText().toString())){
				
			}else{
				Toast.makeText(Registerone.this, "确认密码是否输入正确", Toast.LENGTH_LONG).show();
			}
			break;
		//把输入的参数进行保存，并传到注册的下一个页面。
		case R.id.r_nextRegister:
			Intent r_intent=new Intent(Registerone.this,Registertwo.class);
			r_intent.putExtra("name", user_name.getText().toString());
			r_intent.putExtra("password", password.getText().toString());
			r_intent.putExtra("email", email.getText().toString());
			startActivity(r_intent);
			break;
		default:
			break;
		}
	}
}
