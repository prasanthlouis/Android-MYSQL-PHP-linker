package com.psiuol21.productquery;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewProducts_Activity extends Activity {
	    JSONParser jsonParser = new JSONParser();
	    EditText name;
	    EditText price;
	    EditText description;
	    ProgressDialog progressdia;
	    private static String product_url = "http://192.168.1.12/android_connect/product.php"; //this would vary check your wi-fi IP address
	    private static final String tagss = "success";
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.add_product);
	        //find out the edittext values
	        name = (EditText) findViewById(R.id.name);
	        price = (EditText) findViewById(R.id.price);
	        description = (EditText) findViewById(R.id.description);
	        Button btnCreateProduct = (Button) findViewById(R.id.btn);
	        btnCreateProduct.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                new CreateNew().execute();
	                //starting the Async task on the click of a button
	                
	            }
	        });
	    }
	    class CreateNew extends AsyncTask<String, String, String> {
	        @Override
	        protected void onPreExecute() {
	        	/*pre excecute is what's done before the actual Asynctask
	        	here, i'm creating a progress dialogue engaging the user while the product is being created*/
	            super.onPreExecute();
	            progressdia = new ProgressDialog(NewProducts_Activity.this);
	            progressdia.setMessage("Please Wait..");
	            progressdia.setIndeterminate(true);
	            progressdia.setCancelable(true);
	            progressdia.show();
	        }
	        protected String doInBackground(String... args) {
	            String namex = name.getText().toString();
	            String pricex = price.getText().toString();
	            String descriptionx = description.getText().toString();
	 
	            List<NameValuePair> params = new ArrayList<NameValuePair>();
	            params.add(new BasicNameValuePair("name", namex));
	            params.add(new BasicNameValuePair("price", pricex));
	            params.add(new BasicNameValuePair("description", descriptionx));
	            //we're setting values to names to match with the names in php.
	            //the phpfile then checks if these values are set and then adds it to our database
	 
	         
	            JSONObject json = jsonParser.makeHttpRequest(product_url,"POST", params);
	            try {
	                int success = json.getInt(tagss);
	 //if its a success, return to the all products page
	                if (success == 1) {
	                    Intent i = new Intent(getApplicationContext(), All_Products.class);
	                    startActivity(i);
	                    finish();
	                } else {
	                }
	            } catch (Exception e) {  
	            }
	            return null;
	        }
	        protected void onPostExecute(String file_url) {
	            progressdia.dismiss();
	            //when the async task is finished remember to dismiss it.
	        }
	 
	    }
}