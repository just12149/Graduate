package graduate.user.model;

/**
 * Created by ${niuting} on 2017/1/6.
 */
public class UserInfo {
    /**
     * 信息id
     */
    private Integer infoId;

    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 性别
     */
    private int sex;
    /**
     * 年龄区段
     */
    private int age;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 邮箱
     */
    private String mail;

    /**
     * 居住地区
     */
    private String address;

    /**
     * 学历程度
     */
    private int education;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
