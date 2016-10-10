package cn.edu.gdmec.s07150808.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Main6Activity extends AppCompatActivity implements View.OnClickListener{

private ProgressBar progressBar;
    private Timer timer;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

         progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        Button button9 = (Button) findViewById(R.id.button9);

        button9.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.textView3);
    }

    @Override
    public void onClick(View v) {
     /*   for(int i=0;i<50;i++){
            progressBar.incrementProgressBy(1);
            progressBar.incrementSecondaryProgressBy(1);
        }*/

         timer =new Timer(true);
        timer.schedule(task,0,1000);

    }
    TimerTask task= new TimerTask() {
        @Override
        public void run() {
            /*for(int i=0;i<50;i++){
                progressBar.incrementProgressBy(1);
                progressBar.incrementSecondaryProgressBy(1);
            }*/
            int i=0;
            if(i<=10) {
                progressBar.incrementProgressBy(5);
                progressBar.incrementSecondaryProgressBy(5);
                i++;
            }

        /*    int doing=progressBar.getProgress();
            int max=progressBar.getMax();
            textView.setText("进度条:"+(doing/(float)max*100)+"%");*/
            if(i==10){
             textView.setText("下载完成！");

            }
        }


    };

}
