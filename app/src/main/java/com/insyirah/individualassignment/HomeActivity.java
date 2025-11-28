package com.insyirah.individualassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {

    EditText edtInvested, edtRate, edtMonths;
    Button btnCalculate;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        edtInvested = findViewById(R.id.edtInvested);
        edtRate = findViewById(R.id.edtRate);
        edtMonths = findViewById(R.id.edtMonths);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(v -> calculateDividend());


    }

    private void calculateDividend() {
        String investedStr = edtInvested.getText().toString();
        String rateStr = edtRate.getText().toString();
        String monthsStr = edtMonths.getText().toString();

        if (investedStr.isEmpty() || rateStr.isEmpty() || monthsStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double invested = Double.parseDouble(investedStr);
        double rate = Double.parseDouble(rateStr) / 100;
        int months = Integer.parseInt(monthsStr);

        if (months < 1 || months > 12) {
            Toast.makeText(this, "Months must be between 1 and 12", Toast.LENGTH_SHORT).show();
            return;
        }

        double monthlyDividend = (rate / 12) * invested;
        double totalDividend = monthlyDividend * months;

        txtResult.setText(
                "Monthly Dividend: RM " + String.format("%.2f", monthlyDividend) +
                        "\nTotal Dividend: RM " + String.format("%.2f", totalDividend)
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        if (item.getItemId() == R.id.menu_home) {
            return true; // Already in Home
        }
        return super.onOptionsItemSelected(item);
    }
}
