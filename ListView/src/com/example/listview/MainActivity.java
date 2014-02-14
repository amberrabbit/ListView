package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//リストビュー指定
		list = (ListView) findViewById(R.id.listView);
		
		//配列の指定
		String[] ms = getResources().getStringArray(R.array.MS);
		
		//string.XMLの配列の中身をリストに指定
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, ms);
		
		//リスト指定
		list.setAdapter(adapter);
		
        //アイテムがクリックされたときの処理
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id){
                
            	//リストビューで押したものの文字の表示
            	String text = (String)parent.getItemAtPosition(position);
                
                //トーストの表示
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                
            }
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
