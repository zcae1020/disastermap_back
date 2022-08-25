package disastermap.dmap.controller;

import java.util.Date;

public class dmForm {

    private String dCode; //산사태: 01, 홍수(침수): 02
    private String place, content;

    public String getdCode() {
        return dCode;
    }

    public void setdCode(String dCode) {
        this.dCode = dCode;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
                ", place='" + place + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
