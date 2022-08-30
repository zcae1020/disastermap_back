package disastermap.dmap.repository;

import java.util.HashSet;
import java.util.Set;

public class dCodeSet {
    private Set<dCode> dCodeSet;

    public dCodeSet() {
        this.dCodeSet = new HashSet<>();

        dCodeSet.add(new dCode("01", "산사태"));
        dCodeSet.add(new dCode("02", "홍수"));
        dCodeSet.add(new dCode("03", "차량통제"));
    }

    public Set<dCode> getdCodeSet() {
        return dCodeSet;
    }
}
