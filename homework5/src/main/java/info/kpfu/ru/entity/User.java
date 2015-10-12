package info.kpfu.ru.entity;


public class User {
    String mail;
    String pwd;
    String sex;
    String chb;
    public User(){}

    public User(String m,String p,String s,String c){
        mail = m;
        pwd = p;
        sex = s;
        chb = c;
    }

    public String getMail() {
        return mail;
    }

    public String getChb() {
        return chb;
    }

    public String getPwd() {
        return pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setChb(String chb) {
        this.chb = chb;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
