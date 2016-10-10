package cn.edu.gdmec.s07150808.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener{
     private Button add;
    private Button reduce;
    private  Button reset;
    private TextView textView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main5);

        add= (Button) findViewById(R.id.add);

        reduce = (Button) findViewById(R.id.reduce);

        reset= (Button) findViewById(R.id.reset);

        progressBar= (ProgressBar) findViewById(R.id.progressBar);

        textView= (TextView) findViewById(R.id.textView);


        int one=progressBar.getProgress();
        int two =progressBar.getSecondaryProgress();
        int max=progressBar.getMax();
       textView.setText("第一个进度条:"+(one/(float)max*100)+"%"+"   "+"第二条进度条:"+(two/(float)max*100)+"%");
        add.setOnClickListener(this);

        reduce.setOnClickListener(this);

        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
            {
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(10);
                break;
            }
            case R.id.reduce:
            {
                progressBar.incrementProgressBy(-10);
                progressBar.incrementSecondaryProgressBy(-10);
                break;
            }
            case R.id.reset:
            {
                progressBar.setProgress(50);
                progressBar.setSecondaryProgress(60);
                break;
            }
        }
        textView.setText("第一个进度条:"+(int)(progressBar.getProgress()/(float)progressBar.getMax()*100)+"%"+"   "+"第二条进度条:"+(int)(progressBar.getSecondaryProgress()/(float)progressBar.getMax()
                *100)+"%");
        }
    }

