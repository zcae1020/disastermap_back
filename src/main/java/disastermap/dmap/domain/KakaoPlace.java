package disastermap.dmap.domain;

public class KakaoPlace {
    private LatLng latLng;
    private String place, address;

    public KakaoPlace() {};

    public KakaoPlace(LatLng latLng, String place, String address) {
        this.latLng = latLng;
        this.place = place;
        this.address = address;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

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
}
