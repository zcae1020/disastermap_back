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

    public String getPlace() {
        return place;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "KakaoPlace{" +
                "latLng=" + latLng +
                ", place='" + place + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
