package no.experis.task17;

public class ContactNumbers {
    String homeNum, workNum, mobileNum;

    public ContactNumbers() {
    }

    public ContactNumbers(String homeNum, String workNum, String mobileNum) {
        this.homeNum = homeNum;
        this.workNum = workNum;
        this.mobileNum = mobileNum;
    }

    public String getHomeNum() {
        return homeNum;
    }

    public void setHomeNum(String homeNum) {
        this.homeNum = homeNum;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
}