package com.kenny.tinker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kenny.tinker.tinkermanager.TinkerService;

/**
 * Created by kenny on 17/4/27.
 */
public class MainActivity extends AppCompatActivity {

    private static final String FILE_END =".apk";
    private String mPatchDir;
    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_show = (TextView) findViewById(R.id.tv_show);
        //启用后台服务更新
        startPatchService();
    }

    private void startPatchService() {
        TinkerService.runTinkerService(this);
    }

//    public void loadPatch(View view){
//        tv_show.setText("点击了加载patch按钮" + getPatchName());
//        TinkerManager.loadPatch(getPatchName());
//    }
//
//    private String getPatchName() {
//        //patch_signed指的是在服务器下载下来的patch文件的名称
//        return mPatchDir.concat("patch_signed").concat(FILE_END);
//    }
}
