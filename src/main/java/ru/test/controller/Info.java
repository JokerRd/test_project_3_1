package ru.test.controller;

import java.util.List;

public class Info {

    private String name;
    private int number;
    private List<String> string;
    private SubInfo subInfo;

    public Info() {

    }

    public Info(String name, int number, List<String> string, SubInfo subInfo) {
        this.name = name;
        this.number = number;
        this.string = string;
        this.subInfo = subInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<String> getString() {
        return string;
    }

    public void setString(List<String> string) {
        this.string = string;
    }

    public SubInfo getSubInfo() {
        return subInfo;
    }

    public void setSubInfo(SubInfo subInfo) {
        this.subInfo = subInfo;
    }
}
