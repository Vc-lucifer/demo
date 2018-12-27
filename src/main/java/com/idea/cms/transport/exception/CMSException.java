package com.idea.cms.transport.exception;

/**
 * 异常处理
 */

public class CMSException extends BeileException {

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 8970523354415436014L;

    private CMSException(String message) {
        super(message);
    }

    public CMSException(ErrorBaseEnum err) {
        super(err.getDescription(), err.getValue());
    }

    public static enum ErrorBaseEnum {

        ERR_EXCEPTION(CMS, "未知异常错误"),

        ERR_BASE_LOGIN(CMS + 1, "登录失败,用户不存在"),
        ERR_BASE_NOT_LOGIN(CMS + 2, "User doesn't login"),
        ERR_BASE_FAIL_INSERT(CMS + 2, "保存失败"),
        ERR_BASE_FAIL_DELETE(CMS + 3, "删除失败"),
        ERR_BASE_FAIL_UPDATE(CMS + 4, "更新失败"),
        ERR_BASE_FAIL_SELECT(CMS + 5, "查询失败");


        private int value;
        private String description;

        private ErrorBaseEnum(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

}