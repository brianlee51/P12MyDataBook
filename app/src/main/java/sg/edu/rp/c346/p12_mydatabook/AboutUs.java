package sg.edu.rp.c346.p12_mydatabook;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutUs extends AppCompatActivity {

    ActionBar ab;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        iv = findViewById(R.id.iv);

        String imageUrl = "https://i.imgur.com/tGbaZCY.jpg";
        Picasso.with(this).load(imageUrl).error(R.drawable.error).placeholder(R.drawable.ajax_loader).into(iv);

    }
}
