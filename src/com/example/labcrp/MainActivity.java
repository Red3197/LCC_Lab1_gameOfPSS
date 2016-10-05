package com.example.labcrp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ImageView paper , scissor , stone , urA , comA;
	TextView txv , winTimes , loseTimes , tieTimes ;
	int w , l , t ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findView();
		onClk();
		w = l = t = 0 ;
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
		urA = (ImageView)findViewById(R.id.urA);
		comA = (ImageView)findViewById(R.id.comA);
		txv = (TextView)findViewById(R.id.txv_battleResult);
		winTimes = (TextView)findViewById(R.id.winTimes);
		loseTimes = (TextView)findViewById(R.id.loseTimes);
		tieTimes = (TextView)findViewById(R.id.tieTimes);
		
	}
	
	public void onClk(){
		paper.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				urA.setImageResource(R.drawable.a3);
				comDecide(1);
			}
		});
		scissor.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				urA.setImageResource(R.drawable.a1);
				comDecide(2);
			}
		});
		stone.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				urA.setImageResource(R.drawable.a2);
				comDecide(3);
			}
		});
	}
	
	public void comDecide(int urcmp){
		int i=(int)(Math.random()*3);
		switch(i){
		case 0:
			comA.setImageResource(R.drawable.a3);
			compare(urcmp, 1);
			break;
		case 1:
			comA.setImageResource(R.drawable.a1);
			compare(urcmp, 2);
			break;
		case 2:
			comA.setImageResource(R.drawable.a2);
			compare(urcmp, 3);
		}
	}
	
	public void compare(int urcmp, int comcmp){
		if(urcmp == comcmp){
			txv.setText(R.string.tieResult);
			tieTimes.setText(String.valueOf(++t));
		}
		else if(urcmp == (comcmp+1) || (urcmp==1 && comcmp==3) ){
			txv.setText(R.string.winResult);
			winTimes.setText(String.valueOf(++w));
		}
		else{
			txv.setText(R.string.loseResult);
			loseTimes.setText(String.valueOf(++l));
		}
	}
}
