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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.market_place_frontend.R;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    TextView tv;
    EditText email;
    EditText password;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv = findViewById(R.id.signup_tv);
        submit = findViewById(R.id.login_button);

        tv.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        submit.setOnClickListener(v -> {
            email = findViewById(R.id.username_et_login);
            password = findViewById(R.id.password_et_login);
            postLoginRequest(email.getText().toString(), password.getText().toString());
        });
    }

    public void postLoginRequest(String mail, String password) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Define the URL for the login endpoint
        String url = "http://192.168.100.251:8080/api/v1/auth/authenticate";

        // Create a JSON object with login credentials
        JSONObject jsonBody = new JSONObject();
        try {
            //todo: to check later if the email is 'mail' or 'email' in the backend
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
                        Log.v("token", token);
                        // Store the token somewhere (e.g., SharedPreferences for later use)
                        saveTokenLocally(token);
                        startActivity(new Intent(LoginActivity.this, HomepageActivity.class));
                        // Handle other login success logic as needed
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Json exception", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Log.e("MainActivity", "Error while trying to log in", error);
                    Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show();
                });

        // Add the request to the queue
        requestQueue.add(jsonObjectRequest);
    }


    private void saveTokenLocally(String token) {
        // Implement your logic to store the token locally
        // For example, using SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
        editor.putString("token", token);
        editor.apply();
    }

}

// do that for log out.
/*
SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
editor.remove("token");
editor.apply();
* */