package com.kenny.tinker.entity;

import java.io.Serializable;

/**
 * Created by kenny on 2017/3/16.
 */

public class BasePatch implements Serializable {
    public int ecode;
    public String emsg;
    public PatchInfo data;
}
