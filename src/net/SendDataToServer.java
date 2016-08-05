package net;

import android.util.Log;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cand on 2016/7/8.
 */
public class SendDataToServer {
    private static String url="http://172.16.14.145:8088/CJDBC/servlets/ServletsPOST";
    
    private String name;
    private String pwd;
    private String email;
    private String sex;
    private String Date;
    
    private String height;
    private String weight;
    private String zodiac;
    private String occupation;
    private String address;
    
    
    private String content;
    private String mark;
    
    
    
    //标志位
    private static final String Go="Go";
    private String Register=null;
    private String changePassword=null;
    private String Chat;
    
    public SendDataToServer(String name,String pwd){
           this.name=name;
           this.pwd=pwd;
    }
    public SendDataToServer(String name,String pwd,String changePassword){
    	   this.name=name;
    	   this.pwd=pwd;
    	   this.changePassword=changePassword;
    }
    public SendDataToServer(String name,String content,String mark,String Chat){
	        this.name=name;
	        this.content=content;
	        this.mark=mark;
	        this.Chat=Chat;
    }
    
    public SendDataToServer(String name,String pwd,String email,String sex,String Date,
    						String height,String weight,String zodiac,
    						String occupation,String address,
    						String Register)
    {
	    	this.name=name;
	    	this.pwd=pwd;
	    	this.email=email;
	    	this.sex=sex;
	    	this.Date=Date;
	    	
	    	this.height=height;
	    	this.weight=weight;
	    	this.zodiac=zodiac;
	    	this.occupation=occupation;
	    	this.address=address;
	    	
	    	this.Register=Register;
    }
    
    public void SendDataToServers(){
	        final Map<String,String> map=new HashMap<String,String>();
	        map.put("name",name); 
	        map.put("pwd",pwd);
	        map.put("email", email);
	        map.put("sex", sex);
	        map.put("Date", Date);
	        
	        map.put("height",height);
	        map.put("weight", weight);
	        map.put("zodiac",zodiac);
	        map.put("occupation", occupation);
	        map.put("address", address);
	        
	        map.put("content", content);
	        map.put("mark", mark);
	        
	        
	        map.put("changePassword", changePassword);
	        map.put("Chat", Chat);
	        map.put("GO", Go);
	        map.put("Register", Register);
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    sendPostRequest(map,url,"UTF-8");
	                }catch (Exception e){
	                    e.printStackTrace();
	                }
	            }
	        }).start();
    }
    public boolean sendPostRequest(Map<String,String> param,String url,String encoding)throws Exception{
	        StringBuffer sb=new StringBuffer();
	        if (!url.equals("")&!param.isEmpty()){
	            for (Map.Entry<String,String>entry:param.entrySet()){
	                sb.append(entry.getKey()+"=");
	                sb.append(entry.getValue());
	              //  sb.append(URLDecoder.decode(entry.getValue(),encoding));
	                sb.append("&");
	            }
	            sb.deleteCharAt(sb.length()-1); 
	        }
	        Log.d("hellowords", sb.toString());
	        byte[] data=sb.toString().getBytes();
	        HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
	        conn.setConnectTimeout(5000);
	        conn.setRequestMethod("POST");
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length",data.length+"");
	        OutputStream outputStream=conn.getOutputStream();
	        outputStream.write(data);
	        outputStream.flush();
	        if ( conn.getResponseCode()==200){
	            return true;
	        }
	        return false;
	    }
}
