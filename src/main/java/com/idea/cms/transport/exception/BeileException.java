package com.idea.cms.transport.exception;


import com.idea.cms.transport.InvokerResult;

/**
 * all贝乐异常
 */
public class BeileException extends RuntimeException {

    public final static int CMS = 10000;

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 8970523354415436014L;
    private String resultContent;
    private int resultCode;

    public BeileException(String resultContent) {
        this(resultContent, 100);
    }

    public BeileException(String resultContent, int resultCode) {
        super();
        this.resultContent = resultContent;
        this.resultCode = resultCode;
    }


    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public InvokerResult toInvokerResult() {
        InvokerResult invokerResult = new InvokerResult();
        invokerResult.setResultCode(this.resultCode);
        invokerResult.setResultContent(this.resultContent);
        return invokerResult;
    }

}