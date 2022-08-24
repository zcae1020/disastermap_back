package disastermap.dmap.domain;

import java.util.Date;

public class DM {

    private Long id;
    private String disasterCode; //산사태: 01, 홍수(침수): 02
    private double LatLng[];
    private String place, content;
    private Date date;

    public String getDisasterCode() {
        return disasterCode;
    }

    public void setDisasterCode(String disasterCode) {
        this.disasterCode = disasterCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double[] getLatLng() {
        return LatLng;
    }

    public void setLatLng(double[] latLng) {
        LatLng = latLng;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
