package com.example.constraintlayoutevenbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin=findViewById(R.id.btSignIn);

        //menghubungkan variabel edemail dengan componen button pada Layout
        edemail=findViewById(R.id.edEmail);

        //menguhubungkan variabel edpassword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                String email = "admin";
                String pass = "123";

                if (nama.isEmpty() && password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "email dan Password wajib diisi", Toast.LENGTH_LONG);
                    t.show();
                } else {

                    if (nama.equals("admin@mail.com") & password.equals("123")) {
                        Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), ActivityKedua.class);
                        i.putExtras(b);

                        startActivity(i);
                    } else {

                        Toast t = Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG);

                        t.show();
                    }
                }
            }
        });
    }
}



