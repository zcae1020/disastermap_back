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

    public void createExample(){
        this.dmArrayList.add(new DM(
                ++ID,
                "03",
                "[화성시청] 오늘 04:55시 기준 향남읍 풍무교 고가하부 (향남읍 630-3) 차량통제 중이니, 차량 우회 등 안전 운행하시기 바랍니다.",
                "풍무교",
                "경기 화성시 향남읍 상신리",
                new LatLng(37.0987344264014, 126.902601295029)
        ));

        this.dmArrayList.add(new DM(
                ++ID,
                "02",
                "[한강홍수통제소]오늘 04:50 진위천 평택시(동연교) 홍수주의보 발령, 방송 등을 통해 홍수상황을 확인하시고, 하천변 이용을 자제하시기 바랍니다.",
                "동연교",
                "경기 평택시 고덕면 동청리",
                new LatLng(37.0526971899244, 126.995763922141)
        ));

        this.dmArrayList.add(new DM(
                ++ID,
                "03",
                "[화성시청] 오늘 18시 기준 국도43호선(봉영로) 진안2지하차도~태안지하차도 구간 차량통제 중이니, 차량 우회 등 안전 운행하시기 바랍니다.",
                "진안2지하차도",
                "경기 화성시 진안동",
                new LatLng(37.2131834921958, 127.029827893536)
        ));

        this.dmArrayList.add(new DM(
                ++ID,
                "01",
                "[서초구청] 태풍 북상으로 인해 우면산, 청계산 등 서초구 관내 등산로(산책로)를 전면 폐쇄하오니 입산 및 산림 연접부 접근을 삼가시기 바랍니다.",
                "우면산",
                "서울 서초구 우면동 산 36",
                new LatLng(37.47087527804635, 127.00864686779337)
        ));
    }

    public DMmemoryRepository() {
        this.dmArrayList = new ArrayList<>();
        this.ID = 0L;

        createExample();
    }

    @Override
    public DM save(DM dm) {
        dm.setId(++ID);
        dmArrayList.add(dm);
//        System.out.println(dm);
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
