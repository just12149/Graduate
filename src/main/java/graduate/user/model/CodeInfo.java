package graduate.user.model;

/**
 * Created by ${niuting} on 2017/1/13.
 */
public class CodeInfo {

    /**
     * 常量编号
     */
    private Integer  codeId;
    /**
     * 常量名称
     */
    private  String codeName;
    /**
     * 常量值
     */
    private  String codeValue;
    /**
     *备注
     */
    private String codeRemarks;
    /**
     *所属编码
     */
    private String codePater;

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeRemarks() {
        return codeRemarks;
    }

    public void setCodeRemarks(String codeRemarks) {
        this.codeRemarks = codeRemarks;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodePater() {
        return codePater;
    }

    public void setCodePater(String codePater) {
        this.codePater = codePater;
    }
}
