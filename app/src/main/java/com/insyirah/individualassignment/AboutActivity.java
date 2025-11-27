package com.insyirah.individualassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView github = findViewById(R.id.txtGithub);
        github.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/InsyirahIshak/DividendCalculatorApp"));
            startActivity(intent);
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
