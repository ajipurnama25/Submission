package list.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText Rfullname, Remail, Rpassword, Rnumber;
    Button Rregisterbtn;
    TextView Rloginbtn;
    FirebaseAuth Rauth;
    ProgressBar progressBar;
    FirebaseFirestore Rstore;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Rfullname      = findViewById(R.id.fullName);
        Remail         = findViewById(R.id.Email);
        Rpassword      = findViewById(R.id.passwords);
        Rnumber        = findViewById(R.id.phone);
        Rregisterbtn   = findViewById(R.id.registerBtn);
        Rloginbtn      = findViewById(R.id.createText);

        Rauth          = FirebaseAuth.getInstance();
        Rstore         = FirebaseFirestore.getInstance();
        progressBar    = findViewById(R.id.progressBar);

        Rregisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = Remail.getText().toString().trim();
                String password = Rpassword.getText().toString().trim();
                final String fullname = Rfullname.getText().toString();
                final String phone = Rnumber.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Remail.setError("Email is Required!");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Rpassword.setError("Password is Required!");
                    return;
                }
                if(password.length()<8){
                    Rpassword.setError("Password Less Than 8 Characters!");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                Rauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            userid = Rauth.getCurrentUser().getUid();
                            DocumentReference refdoc = Rstore.collection("users").document(userid);
                            Map<String, Object> user = new HashMap<>();
                            user.put("Fname", fullname);
                            user.put("Emal", email);
                            user.put("nmbr", phone);
                            refdoc.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG","User Profile Is Created");
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("TAG", e.toString());
                                }
                            });
                            progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else {
                            Toast.makeText(Register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        Rloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}
