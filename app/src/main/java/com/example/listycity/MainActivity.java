package com.example.listycity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView cityListView;
    private ArrayAdapter<String> cityAdapter;
    private ArrayList<String> cityDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cityListView = findViewById(R.id.city_list);
        cityDataList = new ArrayList<>();
        cityDataList.add("Edmonton");
        cityDataList.add("Calgary");
        cityDataList.add("Vancouver");
        cityDataList.add("Toronto");

        cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cityDataList);
        cityListView.setAdapter(cityAdapter);

        cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cityName = cityDataList.get(position);
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("CITY_NAME", cityName);
                startActivity(intent);
            }
        });
    }
}
