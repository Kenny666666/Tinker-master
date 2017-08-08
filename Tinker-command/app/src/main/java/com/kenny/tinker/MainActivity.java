package com.kenny.tinker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_END =".apk";
    private String mPatchDir;
    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_show = (TextView) findViewById(R.id.tv_show);

        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        //创建patch文件保存目录
        File file = new File(mPatchDir);
        if (file == null || !file.exists()) {
            file.mkdir();
        }
    }

    public void loadPatch(View view){
        tv_show.setText("点击了加载patch按钮" + getPatchName());
        TinkerManager.loadPatch(getPatchName());
    }

    private String getPatchName() {
        //patch_signed指的是在服务器下载下来的patch文件的名称
        return mPatchDir.concat("patch_signed").concat(FILE_END);
    }
}
