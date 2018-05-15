package com.bean;

public class Person {
    private String name;

    private String sex;

    private String education;

    private String address;

    public String getName() {
        return name;
    }
    public Person(){

    }
    public Person(String name, String sex, String education, String address) {
        this.name = name;
        this.sex = sex;
        this.education = education;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + ',' +
                ", sex='" + sex + ',' +
                ", education='" + education + ',' +
                ", address='" + address + ',' +
                '}';
    }
}
