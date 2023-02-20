package com.zx.dcl;

/**
 * 双重检测锁
 * 为什么用volatile？
 *    INSTANCE = new DCL();受互斥保护，可能还没执行完构造， if (INSTANCE == null)直接就返回了
 */
public class DCL {
    private volatile static DCL INSTANCE = null;
    public DCL(){}
    public static DCL getInstance() {
        if (INSTANCE == null) {
            synchronized (DCL.class) {
                if(INSTANCE == null) {
                    INSTANCE = new DCL();
                }
            }
        }
        return INSTANCE;
    }
}
