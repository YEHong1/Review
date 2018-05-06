package study.liangyehong.android.review.Spinner;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import study.liangyehong.android.review.R;

public class SpinnerDemo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AppCompatSpinner spin_one;
    private AppCompatSpinner spin_two;
    private Context mContext;
    //判断是否为刚进去是触发onItemSelect的标志
    private boolean one_selected = false;
    private boolean two_selected = false;
    private ArrayList<Hero> mData = null;
    private BaseAdapter myAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        mContext = SpinnerDemo.this;
        mData = new ArrayList<Hero>();
        initView();
    }

    private void initView() {
        spin_one = (AppCompatSpinner) findViewById(R.id.spin_one);
        spin_two = (AppCompatSpinner) findViewById(R.id.spin_two);

        mData.add(new Hero(R.drawable.iv_lol_icon1,"迅捷斥候：提莫（Teemo）"));
        mData.add(new Hero(R.drawable.iv_lol_icon2,"诺克萨斯之手：德莱厄斯（Darius）"));
        mData.add(new Hero(R.drawable.iv_lol_icon3,"无极剑圣：易（Yi）"));
        mData.add(new Hero(R.drawable.iv_lol_icon4,"德莱厄斯：德莱文（Draven）"));
        mData.add(new Hero(R.drawable.iv_lol_icon5,"德邦总管：赵信（XinZhao）"));
        mData.add(new Hero(R.drawable.iv_lol_icon6,"狂战士：奥拉夫（Olaf）"));

        myAdapter = new myAdapter<Hero>(mData,R.layout.item_spin_hero) {

            @Override
            public void bindView(ViewHolder holder, Hero obj) {
                holder.setImageResource(R.id.img_icon,obj.gethIcon());
                holder.setText(R.id.text_name,obj.gethName());
            }
        };
        spin_two.setAdapter(myAdapter);
        spin_one.setOnItemSelectedListener(this);
        spin_two.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spin_one:
                if(one_selected){
                    Toast.makeText(mContext,"您的分段是~：" + parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_SHORT).show();
                }else one_selected = true;
                break;
            case R.id.spin_two:
                if(two_selected){
                    TextView text_name = (TextView) view.findViewById(R.id.text_name);
                    Toast.makeText(mContext,"您选择的英雄是~：" + text_name.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                }else two_selected = true;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
