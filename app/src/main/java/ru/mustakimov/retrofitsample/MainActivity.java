package ru.mustakimov.retrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mustakimov.retrofitsample.IpModel;


public class MainActivity extends AppCompatActivity {
    IpModel ip;
    DateModel date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getIpButton = (Button) findViewById(R.id.btnGetIp);
        getIpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getIp();
            }
        });

        Button getDateButton = (Button) findViewById(R.id.btnGetDate);
        getDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDate();
            }
        });
    }

    protected void getIp() {
        App.getApi().getIp().enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                ip = response.body();
                TextView mainText = (TextView)findViewById(R.id.textView);
                String text = "IP: " + ip.getIp();
                mainText.setText(text);
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "An error occurred during networking",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void getDate() {
        App.getApi().getDate().enqueue(new Callback<DateModel>() {
            @Override
            public void onResponse(Call<DateModel> call, Response<DateModel> response) {
                date = response.body();
                TextView mainText = (TextView)findViewById(R.id.textView);
                String text = "Date: " + date.getDate() + '\n' +
                              "Time: " + date.getTime() + '\n' +
                              "Milliseconds: " + date.getMillisecondsSinceEpoch();
                mainText.setText(text);
            }

            @Override
            public void onFailure(Call<DateModel> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "An error occurred during networking",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
