package com.kenny.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * @author kenny
 * @description 对Tinker的所有api做一层封装
 * @date 2017/6/22
 */
public class TinkerManager {

    /**用于标明tinker是否安装*/
    private static boolean isInstalled = false;

    private static ApplicationLike mAppLike;

    /**
     * 完成Tinker的初始化
     * @param applicationLike
     */
    public static void installTinker(ApplicationLike applicationLike){
        mAppLike = applicationLike;
        if (isInstalled) {
            return;
        }

        TinkerInstaller.install(mAppLike);//完成tinker的初始化
        isInstalled = true;
    }

    /**
     * 完成patch文件的加载
     * @param path
     */
    public static void loadPatch(String path){
        if (Tinker.isTinkerInstalled()) {

            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),path);
        }
    }

    private static Context getApplicationContext(){
        if (mAppLike != null) {
            return mAppLike.getApplication().getApplicationContext();
        }
        return null;
    }
}
