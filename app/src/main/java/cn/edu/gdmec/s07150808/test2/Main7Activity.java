package cn.edu.gdmec.s07150808.test2;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

public class Main7Activity extends AppCompatActivity {

    private AlertDialog .Builder builder;
    private TextView textView;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        textView= (TextView) findViewById(R.id.textView2);
        Button button1= (Button) findViewById(R.id.button2);
        Button button2= (Button) findViewById(R.id.button3);
        Button button3= (Button) findViewById(R.id.button4);
        Button button4= (Button) findViewById(R.id.button5);
        Button button5= (Button) findViewById(R.id.button6);
        Button button6= (Button) findViewById(R.id.button7);
        Button button7= (Button) findViewById(R.id.button8);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button2:
                        dialog1();
                        break;
                    case R.id.button3:
                        dialog2();
                        break;
                    case R.id.button4:
                        dialog3();
                        break;
                    case R.id.button5:
                        dialog4();
                        break;
                    case R.id.button6:
                        dialog5();
                        break;
                    case R.id.button7:
                        dialog6();
                        break;
                    case R.id.button8:
                        dialog7();
                        break;

                }
            }
        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);

    }
    public  void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定退出");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener listener2= new DatePickerDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               if(which==DialogInterface.BUTTON_POSITIVE){
                   dialog.dismiss();
                   Main7Activity.this.finish();
               }else if(which==DialogInterface.BUTTON_NEGATIVE){
                   dialog.dismiss();
               }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener2);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener2);
        dialog.show();
    }
    public  void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时很忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);

        DialogInterface.OnClickListener listener3= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
           String str="";
                switch (which)
                {
                    case DialogInterface.BUTTON_POSITIVE:
                        str="杜甫很忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="杜甫不怎么忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="杜甫很轻松";
                        break;
                }
                textView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",listener3);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"不怎么忙",listener3);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"轻松",listener3);
        dialog.show();
    }
    public  void dialog3(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入你的获奖感言");
        dialog.setMessage("你平时很忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText editText=new EditText(this);
        dialog.setView(editText);
        DialogInterface.OnClickListener listener4=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("你输入的是:"+editText.getText().toString());

            }
        };

        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener4);
        dialog.show();
    }
    public  void dialog4(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean Select[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener multiChoiceClickListener= new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Select[which]=isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,multiChoiceClickListener);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener5= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你的选择";
                for(int i=0;i<Select.length;i++){
                    if(Select[i]){
                        str=str+"\n"+item[i];
                    }
                }
                textView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener5);
        dialog.show();
    }



          int index=0;

    public  void dialog5(){
         final String item[]=new String[]{"北京","上海","广州"};
        final boolean Select[]=new boolean[item.length];

        DialogInterface.OnClickListener listener10= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Select[which]=true;
                index=which;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,listener10);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listener11= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你的选择:";

                for(int i=0;i<Select.length;i++)
                {
                    if(Select[i]){
                        str=str+"\n"+item[index];
                    }
                }
            }
        };
dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener11);
        dialog.show();

    }
    public  void dialog6(){
      final String item[]=new String[]{"北京","上海","广州"};

        final boolean Select[]=new boolean[item.length];

        DialogInterface.OnClickListener listener6=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你的选择是:"+item[which];
                textView.setText(str);

            }
        };
        builder=new AlertDialog.Builder(this);

        builder.setItems(item,listener6);

        dialog=builder.create();

        dialog.setTitle("列表框");

        DialogInterface.OnClickListener listener8= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };

        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener8);
        dialog.show();
    }
    public  void dialog7(){
        LayoutInflater inflater =getLayoutInflater();

        View Layout=inflater.inflate(R.layout.activity_main8,null);

        final EditText editText= (EditText) Layout.findViewById(R.id.editText1);

        dialog=new AlertDialog.Builder(this).create();

        dialog.setTitle("自定义布局");

        dialog.setView(Layout);

        DialogInterface.OnClickListener listener7= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textView.setText("输入的是:"+editText.getText().toString());


            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener7);

        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener7);

        dialog.show();
    }
}
