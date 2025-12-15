package com.example.clipstacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private String Url = "http://172.25.83.42/ClipStacksAPI/Login.php";

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.login_page);

        EditText InputUserName = findViewById(R.id.UserName);
        EditText InputPassword = findViewById(R.id.Password);
        Button ButtonLogin = findViewById(R.id.LogInButton);

        ButtonLogin.setOnClickListener(v -> {

            Toast.makeText(this, "Sending Request...", Toast.LENGTH_SHORT).show();

            StringRequest Request = new StringRequest(
                    com.android.volley.Request.Method.POST,
                    Url,

                    Response -> {
                        try {
                            JSONObject Json = new JSONObject(Response);

                            if (Json.getString("Status").equals("Success")) {

                                String UserName = Json.getString("UserName");

                                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();

                                Intent Go = new Intent(this, MainHomeActivity.class);
                                Go.putExtra("UserName", UserName);
                                startActivity(Go);
                                finish();
                            } else {
                                Toast.makeText(this, "Login Failed.", Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            Toast.makeText(this, "Response Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    },

                    Error -> {
                        Toast.makeText(this, "VolleyError: " + Error.toString(), Toast.LENGTH_LONG).show();
                    }
            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> Params = new HashMap<>();
                    Params.put("UserName", InputUserName.getText().toString());
                    Params.put("Password", InputPassword.getText().toString());
                    return Params;
                }
            };

            RequestQueue Queue = Volley.newRequestQueue(this);
            Queue.add(Request);
        });
    }
}
