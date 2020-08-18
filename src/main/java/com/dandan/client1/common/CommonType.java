package com.dandan.client1.common;

public enum CommonType {
    ;
    public interface LogType{
        final String API_INVOKE_LOG = "API_INVOKE_LOG";
        final String STAFF_OP_LOG = "STAFF_OP_LOG";
        final String SYS_ALARM_LOG = "SYS_ALARM_LOG";
    }
    public interface StoreKey_Hash{
        final String API_INVOKE_LOG = "API_INVOKE_LOG_HASH";
        final String STAFF_OP_LOG = "STAFF_OP_LOG_HASH";
        final String SYS_ALARM_LOG = "SYS_ALARM_LOG_HASH";
    }
    public interface StoreKey_List{
        final String API_INVOKE_LOG = "API_INVOKE_LOG_LIST";
        final String STAFF_OP_LOG = "STAFF_OP_LOG_LIST";
        final String SYS_ALARM_LOG = "SYS_ALARM_LOG_LIST";
    }
}
