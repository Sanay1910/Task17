package no.experis.task17;

public class ContactNumber {
    String homeNum, workNum, mobileNum;

    public ContactNumber() {
    }

    public ContactNumber(String workNum, String homeNum, String mobileNum) {
        this.workNum = workNum;
        this.homeNum = homeNum;
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