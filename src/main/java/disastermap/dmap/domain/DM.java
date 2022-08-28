package disastermap.dmap.domain;

import java.util.Arrays;
import java.util.Date;

public class DM implements Cloneable{

    private Long id;

    //산사태: 01, 홍수(침수): 02
    private String disasterCode, content;
    private KakaoPlace kakaoPlace;
    private Date date;
    private boolean valid;

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
                ", date=" + date +
                '}';
    }

    @Override
    public DM clone() throws CloneNotSupportedException{
        return (DM) super.clone();
    }
}
