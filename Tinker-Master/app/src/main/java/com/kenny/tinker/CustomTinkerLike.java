package com.kenny.tinker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * @author kenny
 * @description 官方需求的写法，我们为什么要这个ApplicationLike对象呢？而不是在Application中完成对Tinker的初始化？
 *                            是因为tinker需要监听application的生命周期，所以它通过ApplicationLike进行委托，通过这个委托Tinker可以
 *                            完成ApplicationLike里对applicatoin的生命周期的监听，然后在不同的application生命周期阶段去做不同的初始工作也好或者其它工作
 *                            如果不使用这个对象tinker的初始化会非常复杂，而且要我们程序员自己动手去做，通过这个委托让tinker使用起来更加简单。
 * @date 2017/6/22
 */
@DefaultLifeCycle(application = ".MyTinkerApplication",flags = ShareConstants.TINKER_ENABLE_ALL,loadVerifyFlag = false)
public class CustomTinkerLike extends ApplicationLike {

    public CustomTinkerLike(Application application,
                            int tinkerFlags,
                            boolean tinkerLoadVerifyFlag,
                            long applicationStartElapsedTime,
                            long applicationStartMillisTime,
                            Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //使用应用支持分包
        MultiDex.install(base);
        //完成tinker的初始化
        TinkerManager.installTinker(this);
    }
}
