package com.hexs.learnactivitydemo.permission;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by hexs on 16/9/14.
 */
public class PermissionManger {

    public static final String PERMISSION_START = "com.hexs.learnactivitydemo.permission.START";

    // 代码验证权限
    public static Boolean checkpermission(Context context) {
        int ret = context.checkCallingOrSelfPermission(PERMISSION_START);
        return (ret == PackageManager.PERMISSION_GRANTED);
    }

    // 也可为四大组件在AndroidManifest.xml中添加权限
    // 详见permission权限: com.hexs.learnactivitydemo.permission.WebViewActivity
}
