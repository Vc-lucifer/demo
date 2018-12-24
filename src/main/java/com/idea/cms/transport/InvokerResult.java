package com.idea.cms.transport;

import java.io.Serializable;

/**
 * 调用结果
 */

public final class InvokerResult implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 状态 1 代表成功 其他代表失败
     */
    private int resultCode = 1;

    /**
     * 回执数据
     */
    private Object resultData = "";

    /**
     * 错误内容,code为1 时,一般为空串
     */
    private String resultContent = "";


    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }
}