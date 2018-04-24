package com.example.administrator.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private TextView textView;
    private Spinner spinner;
    private List<String> list;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        spinner = (Spinner) findViewById(R.id.spinner);
        textView.setText("您选择的城市是北京");
        //设置数据源
        list = new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        //设置下拉菜单样式
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String cityName = arrayAdapter.getItem(position);
        //String cityName = list.get(position);
        textView.setText("您选择的城市是"+cityName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
