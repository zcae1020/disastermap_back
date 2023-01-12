package disastermap.dmap.controller;

import disastermap.dmap.domain.DM;
import disastermap.dmap.service.DMserviceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = apiController.class)
class apiControllerWebMvcTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DMserviceInterface dmService;

    @BeforeEach
    void initEach() throws SQLException {
        List<DM> dmList = new ArrayList<>();
        DM dm1 = new DM();
        dm1.setId(0L);
        dm1.setContent("홍수");
        dm1.setDisasterCode("code");

        DM dm2 = new DM();
        dm2.setId(1L);
        dm2.setContent("홍수");
        dm2.setDisasterCode("code");

        DM dm3 = new DM();
        dm3.setId(2L);
        dm3.setContent("홍수");
        dm3.setDisasterCode("code");

        dmList.add(dm1);
        dmList.add(dm2);
        dmList.add(dm3);

        when(dmService.findValidDMs()).thenReturn(dmList);
    }

    @Test
    void getDmList() throws Exception {

        mockMvc.perform(get("/api"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(equalTo(0)))
                .andExpect(jsonPath("$[1].content").value(equalTo("홍수")));
    }
}