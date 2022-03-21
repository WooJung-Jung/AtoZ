package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class EmployeeTest {
    private Employee employee;
    private final String inputCmdData = "15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";

    @BeforeEach
    void init() {
        try {
            String[] arrStr = inputCmdData.split(",");
            employee = new Employee(arrStr[0], arrStr[1], arrStr[2], arrStr[3], arrStr[4], arrStr[5]);
        } catch (Exception ex) {
            Assertions.fail();
        }
    }

    @Test
    @DisplayName("입사년도 2자리 리턴")
    void getEntryYear() {
        int year = employee.getEntryYear();
        Assertions.assertEquals(15, year);
    }

    @Test
    @DisplayName("사번정보 6자리 리턴")
    void getExtraNumber() {
        int num = employee.getExtraNumber();
        Assertions.assertEquals(123099, num);
    }
}
