package disastermap.dmap.controller;

import disastermap.dmap.domain.KakaoPlace;

import java.util.Date;

public class dmForm {

    //dCode 산사태: 01, 홍수(침수): 02
    private String dCode, content, place, address, x,y;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getdCode() {
        return dCode;
    }

    public void setdCode(String dCode) {
        this.dCode = dCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "dmForm{" +
                "disasterCode='" + dCode + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
