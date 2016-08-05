package activity;



import com.example.cproject.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import net.SendDataToServer;

public class Forget extends Activity implements OnClickListener{
	public Button obtainidentify ,confirm;
	public TextView email,identify,newPassword,confirmPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.a_forget);
		email=(TextView)findViewById(R.id.f_email);
		identify=(TextView)findViewById(R.id.f_identify);
		newPassword=(TextView)findViewById(R.id.f_newPassword);
		confirmPassword=(TextView)findViewById(R.id.f_confirmpassword);
		
		obtainidentify=(Button)findViewById(R.id.f_obtainidentify);
		obtainidentify.setOnClickListener(this);
		confirm=(Button)findViewById(R.id.f_confirm);
		confirm.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.f_obtainidentify:
			break;
		case R.id.f_confirm:
			if(newPassword.getText().toString().equals(confirmPassword.getText().toString())){
				change();
				Intent f_intent=new Intent(Forget.this,Login.class);
				startActivity(f_intent);
			}
			else{
				Toast.makeText(Forget.this,"确认密码是否输入正确", Toast.LENGTH_LONG).show();
			}
			break;
			default:
				break;
		}
	}
	public void change(){
		Intent intent=getIntent();
		String user_name=intent.getStringExtra("user_name");
		String password=newPassword.getText().toString();
		String changePassword="changePassword";
        SendDataToServer server=new SendDataToServer(user_name,password,changePassword);
        server.SendDataToServers();
	}
}
