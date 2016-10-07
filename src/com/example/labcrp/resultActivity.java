package com.example.labcrp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class resultActivity extends Activity{
	Intent intent;
	ImageView uI, cI;
	TextView txv;
	Button btn;
	Bundle b;
	boolean first=true;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		findV();
		b= this.getIntent().getExtras();
		btn.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(first){
					comDecide(b.getInt("U"));
					first= false;
				}
				else{
					resultActivity.this.setResult(1, intent);
					resultActivity.this.finish();
				}
			}
		});
		//comDecide(b.getInt("U"));
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
	
	
	
	void findV(){
		uI=(ImageView)findViewById(R.id.ImageU);
		cI=(ImageView)findViewById(R.id.ImageC);
		txv=(TextView)findViewById(R.id.resultTxv);
		btn=(Button)findViewById(R.id.backBtn);
	}
	
	public void comDecide(int urcmp){
		int i=(int)(Math.random()*3);
		showuI();
		switch(i){
		case 0:
			cI.setImageResource(R.drawable.a3);
			compare(urcmp, 1);
			break;
		case 1:
			cI.setImageResource(R.drawable.a1);
			compare(urcmp, 2);
			break;
		case 2:
			cI.setImageResource(R.drawable.a2);
			compare(urcmp, 3);
		}
	}
	
	void showuI(){
		switch(b.getInt("U")){
		case 1:
			uI.setImageResource(R.drawable.a3);
			break;
		case 2:
			uI.setImageResource(R.drawable.a1);
			break;
		case 3:
			uI.setImageResource(R.drawable.a2);
		}
	}
	
	public void compare(int urcmp, int comcmp){
		intent= new Intent();
		if(urcmp == comcmp){
			txv.setText(R.string.tieResult);
			intent.putExtra("RE", 1);
			//tieTimes.setText(String.valueOf(++t));
		}
		else if(urcmp == (comcmp+1) || (urcmp==1 && comcmp==3) ){
			txv.setText(R.string.winResult);
			intent.putExtra("RE", 2);
			//winTimes.setText(String.valueOf(++w));
		}
		else{
			txv.setText(R.string.loseResult);
			intent.putExtra("RE", 3);
			//loseTimes.setText(String.valueOf(++l));
		}
		
		
	}
}
