package study.liangyehong.android.review.ListView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import study.liangyehong.android.review.Adapter.AdapterDemo;
import study.liangyehong.android.review.EditText.EditTextDemo;
import study.liangyehong.android.review.GridView.GridViewDemo;
import study.liangyehong.android.review.R;
import study.liangyehong.android.review.Spinner.SpinnerDemo;
import study.liangyehong.android.review.TextView.TextViewDemo;

public class MainActivity extends AppCompatActivity {

    private ListView list_test;
    private TextView title_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        String[] str = {"ListViewDemo","EditTextDemo","TextViewDemo","GridViewDemo","SpinnerDemo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,str);
        list_test.setAdapter(adapter);
        list_test.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent= new Intent(MainActivity.this,AdapterDemo.class);
                        startActivity(intent);
                        break;

                    case 1:
                        Intent intent1= new Intent(MainActivity.this,EditTextDemo.class);
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2= new Intent(MainActivity.this,TextViewDemo.class);
                        startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3= new Intent(MainActivity.this,GridViewDemo.class);
                        startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4= new Intent(MainActivity.this,SpinnerDemo.class);
                        startActivity(intent4);
                        break;
                }
            }
        });
    }

    private void initView() {
        list_test = (ListView) findViewById(R.id.list_test);
        title_bar = (TextView) findViewById(R.id.title_bar);
/*        title_bar.setText("主界面");*/
    }
}
