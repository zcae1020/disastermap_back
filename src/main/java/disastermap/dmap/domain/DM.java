package disastermap.dmap.domain;

import java.sql.Date;

public class DM implements Cloneable{

    private Long id;

    //산사태: 01, 홍수(침수): 02
    private String disasterCode, content;
    private KakaoPlace kakaoPlace;

    private java.util.Date utildate = new java.util.Date();
    private Date date = new Date(utildate.getTime());
    private boolean valid = true;

    public DM(){}

    public DM(String disasterCode, String content, String place, String address, LatLng latLng) {
        this.disasterCode = disasterCode;
        this.content = content;
        this.kakaoPlace = new KakaoPlace(latLng, place, address);
    }

    public DM(Long id, String disasterCode, String content, String place, String address, LatLng latLng) {
        this.id = id;
        this.disasterCode = disasterCode;
        this.content = content;
        this.kakaoPlace = new KakaoPlace(latLng, place, address);
    }

    public DM(Long id, String disasterCode, String content, String place, String address, LatLng latLng, Date date, boolean valid) {
        this.id = id;
        this.disasterCode = disasterCode;
        this.content = content;
        this.kakaoPlace = new KakaoPlace(latLng, place, address);
        this.date = date;
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public KakaoPlace getKakaoPlace() {
        return kakaoPlace;
    }

    public void setKakaoPlace(KakaoPlace kakaoPlace) {
        this.kakaoPlace = kakaoPlace;
    }

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

    @Override
    public String toString() {
        return "DM{" +
                "id=" + id +
                ", disasterCode='" + disasterCode + '\'' +
                ", content='" + content + '\'' +
                ", kakaoPlace=" + kakaoPlace +
                ", date=" + date +
                ", valid=" + valid +
                '}';
    }

    @Override
    public DM clone() throws CloneNotSupportedException{
        return (DM) super.clone();
    }
}
