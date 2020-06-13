package list.recycleview;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText Lemail, Lpassword;
    Button Lloginbtn;
    TextView Lcreatebtn;
    ProgressBar progressBar;
    FirebaseAuth Lauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Lemail         = findViewById(R.id.Emaillog);
        Lpassword      = findViewById(R.id.passwordlog);
        progressBar    = findViewById(R.id.progressBarlog);
        Lauth          = FirebaseAuth.getInstance();
        Lloginbtn      = findViewById(R.id.loginBtnlog);
        Lcreatebtn     = findViewById(R.id.createTextlog);

        if(Lauth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        Lloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Lemail.getText().toString().trim();
                String password = Lpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Lemail.setError("Email is Required!");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Lpassword.setError("Password is Required!");
                    return;
                }
                if(password.length()<8){
                    Lpassword.setError("Password Less Than 8 Characters!");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                Lauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Login Successfully.", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else {
                            Toast.makeText(Login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        Lcreatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

    }
}
