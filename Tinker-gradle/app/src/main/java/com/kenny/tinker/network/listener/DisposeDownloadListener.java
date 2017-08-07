package com.kenny.tinker.network.listener;

/**
 * Created by kenny on 2017/3/16.
 * @function 监听下载进度
 */
public interface DisposeDownloadListener extends DisposeDataListener {
	void onProgress(int progrss);
}
