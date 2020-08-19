package com.cmm.aop;

public class DataSourceHolder {

    private final static ThreadLocal<String> currentSourceName = new ThreadLocal<>();

    public static void setTargetDSName(String dbName) {
        currentSourceName.set(dbName);
    }

    public static String getTargetDBName() {
        return currentSourceName.get();
    }

    public static void removeTargetDBName() {
        currentSourceName.remove();
    }
}
