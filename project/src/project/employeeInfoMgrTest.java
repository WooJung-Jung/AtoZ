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
    private final String expectOutData = "15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";

    @Nested
    @DisplayName("When add employee")
    class WhenAdd {
        @Test
        @DisplayName("Add Employee by Implement")
        void addEmployeeByImpl() {
            employeeInfoMgr = new EmployeeInfoMgr();

            Assertions.assertEquals(0, employeeInfo.getInfoTable("employeeNum").size());
            Assertions.assertEquals(true, employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), inputCmdData));
            Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());
            Assertions.assertEquals(true, employeeInfo.getInfoTable("employeeNum").containsKey(15123099));
            Assertions.assertEquals(expectOutData, employeeInfo.getInfoTable("employeeNum").get(15123099).print());
        }
    }

    @Nested
    @DisplayName("When employee exist")
    class WhenExist {
        @Mock
        private Option2 option2;
        private final Integer employeeNum = 15123099;

        @BeforeEach
        void init() {
            option2 = mock(Option2.class);

            try {
                String[] arrStr = inputCmdData.split(",");
                employee = new Employee(arrStr[0], arrStr[1], arrStr[2], arrStr[3], arrStr[4], arrStr[5]);
            } catch (Exception ex) {
                Assertions.fail();
            }
        }

        @Test
        @DisplayName("Delete Employee by Mock")
        void delEmployeeByMock() {
            option2 = mock(Option2.class);
            employeeInfoMgr = mock(EmployeeInfoMgr.class);

            when(option2.execute(any())).thenReturn(Arrays.asList(employee));
            when(employeeInfoMgr.delete(any(), any())).thenReturn(Arrays.asList(employee));

            List<Employee> deleted = employeeInfoMgr.delete(employeeInfo.getInfoTable("employeeNum"), option2);

            Assertions.assertEquals(false, deleted.isEmpty());
            Assertions.assertEquals(1, deleted.size());
            Assertions.assertEquals(expectOutData, deleted.get(0).print());
        }

        @Test
        @DisplayName("Delete Employee by Implement")
        void delEmployeeByImpl() {
            option2 = mock(Option2.class);
            employeeInfoMgr = new EmployeeInfoMgr();
            employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), inputCmdData);

            Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());

            when(option2.execute(any())).thenReturn(Arrays.asList(employee));

            List<Employee> deletedList = employeeInfoMgr.delete(employeeInfo.getInfoTable("employeeNum"), option2);

            Assertions.assertEquals(false, deletedList.isEmpty());
            Assertions.assertEquals(1, deletedList.size());
            Assertions.assertEquals(expectOutData, deletedList.get(0).print());
            Assertions.assertEquals(false, employeeInfo.getInfoTable("employeeNum").containsKey(employeeNum));
            Assertions.assertEquals(0, employeeInfo.getInfoTable("employeeNum").size());
        }

        @Test
        @DisplayName("Search Employee by Mock")
        void SearchEmployeeByMock() {
            option2 = mock(Option2.class);
            employeeInfoMgr = mock(EmployeeInfoMgr.class);

            when(option2.execute(any())).thenReturn(Arrays.asList(employee));
            when(employeeInfoMgr.search(any(), any())).thenReturn(Arrays.asList(employee));

            List<Employee> findedList = employeeInfoMgr.search(employeeInfo.getInfoTable("employeeNum"), option2);

            Assertions.assertEquals(false, findedList.isEmpty());
            Assertions.assertEquals(1, findedList.size());
            Assertions.assertEquals(expectOutData, findedList.get(0).print());
        }

        @Test
        @DisplayName("Search Employee by Impl")
        void SearchEmployeeByImpl() {
            option2 = mock(Option2.class);
            employeeInfoMgr = new EmployeeInfoMgr();
            employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), inputCmdData);

            when(option2.execute(any())).thenReturn(Arrays.asList(employee));

            List<Employee> findedList = employeeInfoMgr.search(employeeInfo.getInfoTable("employeeNum"), option2);

            Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());
            Assertions.assertEquals(false, findedList.isEmpty());
            Assertions.assertEquals(1, findedList.size());
            Assertions.assertEquals(expectOutData, findedList.get(0).print());
            Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());
            Assertions.assertEquals(expectOutData, employeeInfo.getInfoTable("employeeNum").get(employeeNum).print());
        }
    }
}