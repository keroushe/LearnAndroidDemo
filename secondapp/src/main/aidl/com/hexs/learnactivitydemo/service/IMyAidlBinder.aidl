// IMyAidlBinder.aidl
package com.hexs.learnactivitydemo.service;

// Declare any non-default types here with import statements

interface IMyAidlBinder {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    // 设置num值
    void setnum(int _num);
}
