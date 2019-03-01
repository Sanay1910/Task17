package no.experis.task17;

public class ContactNumber {
    String homeNum, workNum, mobileNum;
    String home, work, mobile;

    public ContactNumber() {
    }

    public ContactNumber(String work, String home, String mobile) {
        this.work = work;
        this.home = home;
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}