package com.nmefc.grid_monitor_service.common;

public enum ProcessEnum {
    GUIDE("指导产品上传"),
    CORRECT("订正产品上传"),
    FUSION("融合产品上传"),
    SUCCESS("9001"),
    FAIL("9002"),
    WAIT("9003"),
    L0("6101"),
    L1("6102"),
    L2("6103"),
    L3("6104"),
    L4("6105"),
    L5("6106");
    private String value;
    public String getValue(){
        return value;
    }
    ProcessEnum(String value) {
        this.value = value;
    }
}
