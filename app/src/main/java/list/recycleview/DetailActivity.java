package list.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String NAMES_KEY = "names_key";
    public static final String IMAGES_KEY = "images_key";
    public static final String DES_KEY = "des_key";


    TextView namamobo, deskripsimobo, harga;
    ImageView imgmobo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        imgmobo = findViewById(R.id.tv_photo);
        namamobo = findViewById(R.id.tv_name);
        deskripsimobo = findViewById(R.id.tv_des);
        harga = findViewById(R.id.tv_harga);

        //Dapatkan Intent
        Intent intent = this.getIntent();

        //Menerima Intent
        String name = intent.getExtras().getString("NAMES_KEY");
        String des = intent.getExtras().getString("DES_KEY");
        String images = intent.getExtras().getString("IMAGES_KEY");
        String hrg = intent.getExtras().getString("PRICE_KEY");

        //Bin data
        imgmobo.setImageURI(Uri.parse(images));
        namamobo.setText(name);
        deskripsimobo.setText(des);
        harga.setText(hrg);

        Glide.with(this)
                .load(images)
                .into(imgmobo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(name);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
