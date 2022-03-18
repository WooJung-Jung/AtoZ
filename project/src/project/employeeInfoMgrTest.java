package project;

import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class employeeInfoMgrTest {
    private EmployeeInfo employeeInfo = new EmployeeInfo();
    private Employee employee;
    private EmployeeInfoMgr employeeInfoMgr;
    private final String inputCmdData = "15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";

    @Nested
    @DisplayName("When add employee")
    class WhenAdd {
        @Test
        @DisplayName("Add Employee by Implement")
        void addEmployeeByImpl() {
            final String expectOutData = inputCmdData;

            employeeInfoMgr = new EmployeeInfoMgr();

            Assertions.assertEquals(0, employeeInfo.getInfoTable("employeeNum").size());
            Assertions.assertEquals(true, employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), inputCmdData));
            Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());
            Assertions.assertEquals(true, employeeInfo.getInfoTable("employeeNum").containsKey(15123099));
            Assertions.assertEquals(expectOutData, employeeInfo.getInfoTable("employeeNum").get(15123099).print());
        }
    }
}
