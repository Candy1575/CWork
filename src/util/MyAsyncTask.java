package util;

import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask<Object, Object, Object>{
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		
		super.onPreExecute();
		
	}
	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub
		publishProgress(); //�������ֵ            �ֶ�����onProgressUpdate����
		return null;
	}
	//��ȡ���ȣ����½�����  ��ȡdoInBackground�������Ĳ���          ֪��������ɵĽ��� 
	@Override
	protected void onProgressUpdate(Object... values) {                            
		// TODO Auto-generated method stub
		super.onProgressUpdate(values); 
	}
	

}
