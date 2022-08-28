package disastermap.dmap.repository;

import disastermap.dmap.domain.DM;
import disastermap.dmap.domain.KakaoPlace;
import disastermap.dmap.domain.LatLng;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DMmemoryRepository implements DMrepository{

    private ArrayList<DM> dmArrayList;
    private Long ID;

    public DMmemoryRepository() {
        this.dmArrayList = new ArrayList<>();
        this.ID = 0L;

        DM dm = new DM();

        LatLng latLng = new LatLng(37.5821159805264, 127.002785057425);
        KakaoPlace kakaoPlace = new KakaoPlace();
        kakaoPlace.setPlace("장");
        kakaoPlace.setAddress("서울 종로구 동숭동 1-62");
        kakaoPlace.setLatLng(latLng);

        dm.setDisasterCode("01");
        dm.setContent("산사태");
        dm.setDate(new Date());
        dm.setValid(true);
        dm.setKakaoPlace(kakaoPlace);
        dm.setId(++ID);

        this.dmArrayList.add(dm);
    }

    @Override
    public DM save(DM dm) {
        dm.setId(++ID);
        dmArrayList.add(dm);
        return dm;
    }

    @Override
    public DM findById(Long id) {
        for(DM dm:dmArrayList){
            if(dm.getId()==id){
                return dm;
            }
        }

        return null;
    }

    @Override
    public List<DM> findAll() {
        return dmArrayList;
    }

    @Override
    public List<DM> findValidAll() {
        ArrayList<DM> validDmList = new ArrayList<>();

        for(DM dm:dmArrayList)
            if(dm.isValid())
                validDmList.add(dm);

        return validDmList;
    }

    @Override
    public DM delete(Long id) throws CloneNotSupportedException {
        for(DM dm:dmArrayList){
            if(dm.getId()==id){
                DM ret = dm.clone();
                dmArrayList.remove(dm);
                return ret;
            }
        }

        return null;
    }

    @Override
    public DM setUnvalid(Long id) throws CloneNotSupportedException {
        for(DM dm:dmArrayList){
            if(dm.getId()==id){
                DM ret = dm.clone();
                dm.setValid(false);
                return ret;
            }
        }

        return null;
    }
}
