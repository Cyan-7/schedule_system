package com.MyProject.schedule.model.pojo;

public class HomeworkUser {
    private String userName;
    private String userAge;
    private String userEmail;

    public HomeworkUser() {
    }

    public HomeworkUser(String userName, String userAge, String userEmail) {
        this.userName = userName;
        this.userAge = userAge;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "姓名：" + this.getUserName() + "\n" +
                "年龄：" + this.getUserAge() + "\n" +
                "邮箱：" + this.getUserEmail();
    }
}
