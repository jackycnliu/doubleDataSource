package com.becom.common;

public class DataSourceContextHolder {
    public static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static void setDataSource(String dataSourceName){
        contextHolder.set(dataSourceName);
    }
    public static String getDataSource(){
        return contextHolder.get();
    }
    public static void clearDataSource(){
        contextHolder.remove();
    }
}
