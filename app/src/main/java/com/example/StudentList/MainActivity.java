package com.example.StudentList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.StudentList.db.stuList;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEdtTxtStuName;
    private Button mBtnQuery;
    private TextView mTvPhone;
    private String name[] = {"caishisen"/*"caishisen"*/, "zhenghaoyuan", "zengshenghan", "zengtong", "chenbin", "chenjiarong", "陈凯斌", "chenliehai",
            "daijei", "gaopeiqian", "guoqingpeng", "heyunxian", "huangwenbin", "haungyian", "jiangweihao", "jiangzelin", "keyujie", "lanwei",
            "liboxin", "libin", "liweihao", "liwenhao", "lizhixuan", "lizhiming", "linguosheng", "liuxiaomin", "luojiaxu", "luojianhong",
            "luozhixian", "lvzhuangrui", "ouxuepeng", "peijvchao", "qiuxiang", "qinyixiong", "wangbinyong", "wenzhihang", "wuyashi", "xiekaigong",
            "changjinhui", "yelijuan", "zhangjiayan", "zhangjiayuan", "zhangjunjie", "zhanglinhong", "zhangpeisheng", "zhouyong", "chenzejun", "chenjiachong",
            "lijiayong", "qumaosen", "liuyanjun"/*"lyj"*/};
    private String phone[] = {"1329711653", "13528887953", "13713989050", "13544198126", "15625270028",
            "13544114269", "15014148069", "13433862613", "15813807612", "18926502873", "15013816779",
            "13433529378", "13612984564", "13714279798", "18126303527", "15012611179", "13632586763",
            "13145874320", "15507552024", "13712781003", "13417583756", "13750566404", "13590416445",
            "13530024017", "15602902698", "15602960267", "15602317239", "15014131945", "13723729770",
            "13322994005", "15889554874", "13714261139", "13534125951", "15707664434", "15602961326",
            "13632753614", "13714030200", "13066881204", "15017048404", "13682646890", "13928493648",
            "13723497070", "15999653318", "13537579977", "13728908026", "13049735521", "13760478768",
            "15119442269", "13148881230", "13005636562", "18127001507"};
    private String classmark []={"1329711653", "13528887953", "13713989050", "13544198126", "15625270028",
            "13544114269", "15014148069", "13433862613", "15813807612", "18926502873", "15013816779",
            "13433529378", "13612984564", "13714279798", "18126303527", "15012611179", "13632586763",
            "13145874320", "15507552024", "13712781003", "13417583756", "13750566404", "13590416445",
            "13530024017", "15602902698", "15602960267", "15602317239", "15014131945", "13723729770",
            "13322994005", "15889554874", "13714261139", "13534125951", "15707664434", "15602961326",
            "13632753614", "13714030200", "13066881204", "15017048404", "13682646890", "13928493648",
            "13723497070", "15999653318", "13537579977", "13728908026", "13049735521", "13760478768",
            "15119442269", "13148881230", "13005636562", "18127001507"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }


    private void initView() {
        mEdtTxtStuName = (EditText) findViewById(R.id.edtTxt_stuName);
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mTvPhone = (TextView) findViewById(R.id.tv_phone);
        mBtnQuery.setOnClickListener(this);
        LitePal.getDatabase();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_query:
                submit();
                queryData();
                break;
        }
    }

    private void queryData() {
        String name=mEdtTxtStuName.getText().toString();
       /* String phone = DataSupport.where("sName=?",name).find(stuList.class).toString();
        mTvPhone.setText(phone);
*/
        List<stuList> student=DataSupport.where("sName=?",name).find(stuList.class);
       for (stuList stu:student ){
           String phone =stu.getsPhone();
           mTvPhone.setText(phone);
       }



    }

    private void submit() {
        // validate
        String stuName = mEdtTxtStuName.getText().toString().trim();
        if (TextUtils.isEmpty(stuName)) {
            Toast.makeText(this, "name", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    private void initData() {
       // stuList list = new stuList();
        for (int i = 0; i < name.length; i++) {
            stuList list = new stuList();
            list.setsName(name[i]);
            list.setsPhone(phone[i]);
            list.save();
        }
//        list.save();
    }
}
