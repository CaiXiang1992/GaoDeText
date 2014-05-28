package com.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;

public class MainActivity extends Activity {
	private MapView mapView;
	private AMap aMap;
	private RadioGroup group;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		mapView = (MapView) this.findViewById(R.id.map);
		mapView.onCreate(savedInstanceState);

		group = (RadioGroup) this.findViewById(R.id.mapShow);
		init();
		int idid = group.getCheckedRadioButtonId();
		if (idid == R.id.biaozhun) {
			aMap.setMapType(AMap.MAP_TYPE_NORMAL);
		} else if (idid == R.id.weixing) {
			aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
		}

		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				if (arg1 == R.id.biaozhun) {
					setLayer("±ê×¼µØÍ¼");
				} else {
					setLayer("ÎÀÐÇµØÍ¼");
				}
			}
		});
	}

	private void setLayer(String layerName) {
		if (layerName.equals("±ê×¼µØÍ¼")) {
			// ï¿½ï¿½Ê¾ï¿½ï¿½×¼ï¿½ï¿½Í¼
			aMap.setMapType(AMap.MAP_TYPE_NORMAL);
		} else if (layerName.equals("ÎÀÐÇµØÍ¼")) {
			// ï¿½ï¿½Ê¾ï¿½ï¿½ï¿½Çµï¿½Í¼
			aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
		}
	}

	private void init() {
		if (aMap == null) {
			aMap = mapView.getMap();
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mapView.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mapView.onPause();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mapView.onDestroy();
	}
}
