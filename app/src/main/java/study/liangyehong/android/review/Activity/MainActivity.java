package study.liangyehong.android.review.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import study.liangyehong.android.review.R;

public class MainActivity extends AppCompatActivity {

    private ListView list_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        list_test = (ListView) findViewById(R.id.list_test);
        String[] str = {"A","B","C"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,str);
        list_test.setAdapter(adapter);
    }
}
