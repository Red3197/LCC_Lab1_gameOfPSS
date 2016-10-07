package com.example.labcrp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ImageView paper , scissor , stone;
	TextView  winTimes , loseTimes , tieTimes ;
	int w , l , t ;
	Bundle bun=new Bundle();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		w = l = t = 0 ;
		findView();
		onClk();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void findView(){
		paper = (ImageView)findViewById(R.id.paper);
		scissor = (ImageView)findViewById(R.id.scissor);
		stone = (ImageView)findViewById(R.id.stone);
		//urA = (ImageView)findViewById(R.id.urA);
		//comA = (ImageView)findViewById(R.id.comA);
		//txv = (TextView)findViewById(R.id.txv_battleResult);
		winTimes = (TextView)findViewById(R.id.winTimes);
		loseTimes = (TextView)findViewById(R.id.loseTimes);
		tieTimes = (TextView)findViewById(R.id.tieTimes);
		
	}
	
	public void onClk(){
		//Intent intent= new Intent();
		//intent.setClass(MainActivity.this, resultActivity.class);
		//intent.putExtras(bun);
		//startActivityForResult(intent,1);
		paper.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				toNext(1);
				//urA.setImageResource(R.drawable.a3);
				//comDecide(1);
			}
		});
		scissor.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				toNext(2);
				//urA.setImageResource(R.drawable.a1);
				//comDecide(2);
			}
		});
		stone.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				toNext(3);
				//urA.setImageResource(R.drawable.a2);
				//comDecide(3);
			}
		});
	}
	
	void toNext(int i){
		Intent intent= new Intent(this , resultActivity.class);
		bun.putInt("U", i);
		intent.putExtras(bun);
		startActivityForResult(intent,0);
	}
	
	protected void onActivityResult(int req, int res, Intent data){
		super.onActivityResult(req, res, data);
		switch(res){
		case 1 :
			int getData= data.getIntExtra("RE", -1);
			if(getData!=-1){
				switch(getData){
				case 1:
					tieTimes.setText(String.valueOf(++t));
					break;
				case 2:
					winTimes.setText(String.valueOf(++w));
					break;
				case 3:
					loseTimes.setText(String.valueOf(++l));
				}
			}
		}
	}
}
