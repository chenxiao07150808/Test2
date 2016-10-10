package cn.edu.gdmec.s07150808.test2;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private AutoCompleteTextView auto;
    private MultiAutoCompleteTextView muit;
    private String[] res = {"beijing1", "beijing2", "beijing3", "shanghai1", "shanghai2"};


    private ToggleButton tb;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, res);
        auto.setAdapter(adapter);


        muit = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        //加入资源
        muit.setAdapter(adapter);
        //设置以逗号隔开
        muit.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        //第二个埪件


        tb=(ToggleButton)findViewById(R.id.toggleButton);
        iv=(ImageView)findViewById(R.id.imageView);

        tb.setOnCheckedChangeListener(this);



    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //buttonView表示被点击埪件的本身
        // isChecked---被电击控件本身的状态
        iv.setBackgroundResource(isChecked?R.drawable.on:R.drawable.off);
    }


}

