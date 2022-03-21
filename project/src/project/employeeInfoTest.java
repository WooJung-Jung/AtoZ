package project;

import org.junit.jupiter.api.*;
import java.util.HashMap;

public class employeeInfoTest {
    EmployeeInfo employeeInfo;

    @Test
    @DisplayName("HashMap 리턴")
    void returnHashMap() {
        employeeInfo = new EmployeeInfo();

        HashMap<Integer, Employee> hashMap = employeeInfo.getInfoTable("employeeNum");
        Assertions.assertEquals(true, hashMap.isEmpty());
        Assertions.assertEquals(0, hashMap.size());
    }
}
