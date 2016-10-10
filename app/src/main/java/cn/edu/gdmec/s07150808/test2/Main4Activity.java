package cn.edu.gdmec.s07150808.test2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
     private TextView testView;
    private Spinner spinner;
    private List<String> list=new ArrayList<String>();
    private ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        list.add("北京");
        list.add("天津");
        list.add("上海");
        list.add("广州");
        list.add("深圳");

        testView=(TextView)findViewById(R.id.textView);
        spinner=(Spinner)findViewById(R.id.spinner);


        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adapter);

        spinner.setOnItemClickListener(new Spinner.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                testView.setText("你的选择是:" + adapter.getItem(position));
            }
                public void onNothingSelect(AdapterView<?>parent){
              testView.setText("N");
            }
        });
    }
}
