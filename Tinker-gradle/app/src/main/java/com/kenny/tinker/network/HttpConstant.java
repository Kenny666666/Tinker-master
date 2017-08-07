package com.kenny.tinker.network;

/**
 * @function: all url in the sdk
 * Created by kenny on 2017/3/16.
 */
public class HttpConstant {

    private static final String ROOT_URL = "http://www.xxx.com/api";
    /**
     * 检查是否有patch文件更新
     */
    public static String UPDATE_PATCH_URL = ROOT_URL + "/tinker/update.php";

    /**
     * patch文件下载地址
     */
    public static String DOWNLOAD_PATCH_URL = ROOT_URL + "/tinker/download_patch.php";

}
