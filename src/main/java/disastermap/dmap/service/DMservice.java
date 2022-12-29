package disastermap.dmap.service;

import disastermap.dmap.domain.DM;
import disastermap.dmap.repository.dCode;
import disastermap.dmap.repository.dCodeSet;
import disastermap.dmap.repository.DMrepository;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DMservice implements DMserviceInterface{

    private final DMrepository dMrepository;

    public DMservice(DMrepository dMrepository) {
        this.dMrepository = dMrepository;
    }

    public Long join(DM dm) throws SQLException {
        //validate
        DM res = dMrepository.save(dm);
        return (res==null?0:res.getId());
    }

    public List<DM> findDMs() throws SQLException {
        return dMrepository.findAll();
    }

    public List<DM> findValidDMs() throws SQLException {
        return dMrepository.findValidAll();
    }

    public DM findDM(Long id) throws SQLException {
        return dMrepository.findById(id);
    }

    public DM delDM(Long id) throws CloneNotSupportedException, SQLException { return dMrepository.delete(id); }

    public DM unvaildDM(Long id) throws CloneNotSupportedException, SQLException { return dMrepository.setUnvalid(id); }

    public Set<dCode> getdCodes() throws IOException {
        Reader reader = new FileReader("JSONFile.json");
        Set<dCode> set = new HashSet<>();

        String str = readerToString(reader);

        reader.close();

        JSONObject jObject = new JSONObject(str);
        JSONArray dcodes = jObject.getJSONArray("dcodes");

        for(int i=0;i<dcodes.length();i++){
            JSONObject dcode = dcodes.getJSONObject(i);
            set.add(new dCode(dcode.getString("codeNum"), dcode.getString("content")));
        }

        return set;
    }

    public String readerToString(Reader reader) throws IOException {
        char[] arr = new char[8 * 1024];
        StringBuilder buffer = new StringBuilder();
        int numCharsRead;
        while ((numCharsRead = reader.read(arr, 0, arr.length)) != -1) {
            buffer.append(arr, 0, numCharsRead);
        }
        return buffer.toString();
    }
}
