package com.example.market_place_frontend.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.market_place_frontend.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    TextView tv;
    EditText name_et;
    EditText username_et;
    EditText password_et;
    Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tv = findViewById(R.id.login_tv);
        tv.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
        submit_btn = findViewById(R.id.register_button);
        submit_btn.setOnClickListener(v -> {
            name_et = findViewById(R.id.name_et);
            username_et = findViewById(R.id.username_et);
            password_et = findViewById(R.id.password_et);
            postRegisterRequest(name_et.getText().toString(), username_et.getText().toString(), password_et.getText().toString());
        });
    }


    public void postRegisterRequest(String name, String mail, String password) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Define the URL for the registration endpoint
        String url = "http://192.168.100.251:8080/api/v1/auth/register";

        // Create a JSON object with user details
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("name", name);
            jsonBody.put("mail", mail);
            jsonBody.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Create the request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                response -> {
                    try {
                        // Assuming the token is stored in a field called "token" in the response
                        String token = response.getString("token");
                        Log.v("token:", token);
                        // Store the token somewhere (e.g., SharedPreferences for later use)
                        saveTokenLocally(token);
                        startActivity(new Intent(RegisterActivity.this, HomepageActivity.class));
                        // Handle other logic as needed
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Json Exception", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Log.e("MainActivity", "Error while trying to register", error);
                    Toast.makeText(this, "Register Failed!", Toast.LENGTH_SHORT).show();
                });

        // Add the request to the queue
        requestQueue.add(jsonObjectRequest);
    }

    // Function to save the token locally (e.g., using SharedPreferences)
    private void saveTokenLocally(String token) {
        // Implement your logic to store the token locally
        // For example, using SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
        editor.putString("token", token);
        editor.apply();
    }
    private String retrieveStoredToken() {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return prefs.getString("token", null);
    }

    public void makeAuthorizedRequest(String endpoint) {
        String token = retrieveStoredToken();

        if (token != null) {
            // Include the token in your request headers
            // You need to modify this part based on your specific API requirements
            String url = "http://192.168.100.251:8080/";
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // Handle the authorized response
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Handle the error response
                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() {
                    // Set the Authorization header with the retrieved token
                    Map<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Bearer " + token);
                    return headers;
                }
            };

            // Add the request to the queue
            requestQueue.add(jsonObjectRequest);
        } else {
            // Handle the case where the token is not available
            // You might want to redirect the user to the login screen or perform some other action
        }
    }

}