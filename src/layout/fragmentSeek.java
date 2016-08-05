package layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cproject.R;

import activity.Login;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import main.information;



public class fragmentSeek extends Fragment implements OnItemClickListener{
	
	private GridView gridView;
	private SimpleAdapter adapter;
	private List<Map<String, Object>> dataList;
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_seek, container,false);
		gridView=(GridView) view.findViewById(R.id.gridView);
		return view;
	}
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	super.onActivityCreated(savedInstanceState);
    	dataList=new ArrayList<Map<String,Object>>();
    	adapter=new SimpleAdapter(getContext(), getData(), R.layout.fragment_seek_item, new String[]{"pic","name"}, new int[]{R.id.pic,R.id.name});
   	 	gridView.setAdapter(adapter);
   	 	gridView.setOnItemClickListener(this);
    }
    ;
	
	String[] iconName = { "加拿大", "中国", "龙", "法国", "香港", "非洲", "欧盟", "台湾","联合国",
			"海盗","海军","恐怖分子","天空之城" };
	private List<Map<String,Object>> getData(){
//		int[] drawable = { R.drawable.temp_canada, R.drawable.temp_china,
//				R.drawable.temp_dragon, R.drawable.temp_franch, R.drawable.temp_hongkong,
//				R.drawable.temp_nothing, R.drawable.temp_onmen, R.drawable.temp_taiwan,
//				R.drawable.temp_un };
	Integer[] drawable={R.drawable.kulouwenhua_01,
				R.drawable.kulouwenhua_02,R.drawable.kulouwenhua_03,
				R.drawable.kulouwenhua_04,R.drawable.kulouwenhua_05,
				R.drawable.kulouwenhua_06,R.drawable.kulouwenhua_07,
				R.drawable.kulouwenhua_08,R.drawable.kulouwenhua_09,
				R.drawable.kulouwenhua_10,R.drawable.kulouwenhua_11,
//				R.drawable.kulouwenhua_12,R.drawable.kulouwenhua_14,
//				R.drawable.kulouwenhua_13,R.drawable.kulouwenhua_15,
//				R.drawable.kulouwenhua_16,R.drawable.kulouwenhua_17,
		};
		for(int i=0;i<drawable.length;i++){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pic", drawable[i]);
		map.put("name", iconName[i]);
		dataList.add(map);
		}
		return dataList;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(getContext(), "my name is"+iconName[position],Toast.LENGTH_LONG).show();
		Intent intent=new Intent(getContext(),information.class);
	//	intent.putExtra("information_head", drawable[position]);
		intent.putExtra("information_name", iconName[position]);
		startActivity(intent);
	}
}
