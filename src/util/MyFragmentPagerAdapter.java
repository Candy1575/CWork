package util;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class MyFragmentPagerAdapter {
		private List<Fragment> list;
		public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> list){
			super();
			this.list=list;
		}
		public Fragment getItem(int position){
			return list.get(position);
			
		}
		public int getCount(){
			return list.size();
			
		}
}
