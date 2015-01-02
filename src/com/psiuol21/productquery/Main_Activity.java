package com.psiuol21.productquery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Main_Activity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	
	public void add_prod(View v)
	{
	Intent i1=new Intent(getApplicationContext(), NewProducts_Activity.class);
	startActivity(i1);
	}
	public void view_prod(View v)
	{
		Intent i2=new Intent(getApplicationContext(), All_Products.class);
		startActivity(i2);
		
	}
	

}
