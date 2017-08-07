package com.kenny.tinker.entity;

import java.io.Serializable;

/**
 * Created by kenny on 2017/3/16.
 */

public class PatchInfo implements Serializable {

    public String downloadUrl; //不为空则表明有更新

    public String versionName; //本次patch包的版本号

    public String patchMessage; //本次patch包含的相关信息，例如：主要做了那些改动

    public String md5;//patch文件正确的md5值
}
