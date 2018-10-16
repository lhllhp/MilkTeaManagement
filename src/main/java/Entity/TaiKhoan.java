package Entity;

public class TaiKhoan {
    private int maUser;
    private String userName;
    private String passWord;
    private int type;

    public TaiKhoan(){}

    public TaiKhoan(int maUser, String userName, String passWord, int type) {
        this.maUser = maUser;
        this.userName = userName;
        this.passWord = passWord;
        this.type = type;
    }

    public int getMaUser() {
        return maUser;
    }

    public void setMaUser(int maUser) {
        this.maUser = maUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "maUser=" + maUser +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", type=" + type +
                '}';
    }
}
