package com.kenny.tinker.tinkermanager;

import android.content.Context;

import com.kenny.tinker.util.Utils;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by kenny on 2017/3/16.
 * @function: 1.较验patch文件是否合法  2.启动Service去安装patch文件
 */
public class CustomPatchListener extends DefaultPatchListener {

    private String currentMD5;

    public void setCurrentMD5(String md5Value) {

        this.currentMD5 = md5Value;
    }

    public CustomPatchListener(Context context) {
        super(context);
    }

    @Override
    protected int patchCheck(String path) {
        //patch文件ms5较验
        if (!Utils.isFileMD5Matched(path, currentMD5)) {

            return ShareConstants.ERROR_PATCH_DISABLE;
        }


        return super.patchCheck(path);
    }
}
