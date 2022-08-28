package disastermap.dmap.repository;

import java.util.ArrayList;

public class dCode {

    private String codeNum, content;

    public dCode(String codeNum, String content) {
        this.codeNum = codeNum;
        this.content = content;
    }

    public String getCodeNum() {
        return codeNum;
    }

    public String getContent() {
        return content;
    }
}
