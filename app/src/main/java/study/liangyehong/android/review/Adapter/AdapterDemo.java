package study.liangyehong.android.review.Adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import study.liangyehong.android.review.R;

public class AdapterDemo extends AppCompatActivity {

    private ImageView img;
    private TextView name;
    private TextView say;
    private ListView listview;

    private String names[] = new String[]{"陈奕迅","张家辉","张学友"};
    private String says[] = new String[]{"祝你阴天快乐！","是兄弟就来贪玩蓝月！","再玩贪玩蓝月就不认你了！"};
    private int imgId[] = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_demo);
        initView();
        initData();
    }

    private void initData() {
        List<Map<String,Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++){
            Map<String,Object> showitem = new HashMap<String, Object>();
            showitem.put("img",imgId[i]);
            showitem.put("name",names[i]);
            showitem.put("say",says[i]);
            listitem.add(showitem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(),
                listitem,R.layout.list_item,new String[]{"img","name","say"},
                new int[]{R.id.img,R.id.name,R.id.say});
        listview.setAdapter(simpleAdapter);
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        say = (TextView) findViewById(R.id.say);
        listview = (ListView) findViewById(R.id.list_test1);
    }
}
