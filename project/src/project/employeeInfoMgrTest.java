package project;

import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
        private SearchStrategy searcher;
        private final Integer employeeNum = 15123099;
        private final String searchString = "employeeNum,15123099";

        @BeforeEach
        void init() {
            searcher = mock(SearchStrategy.class);

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
            searcher = mock(SearchStrategy.class);
            employeeInfoMgr = mock(EmployeeInfoMgr.class);

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));
            when(employeeInfoMgr.delete(any(), any(), anyString())).thenReturn(Arrays.asList(employee));

            List<Employee> deleted = employeeInfoMgr.delete(employeeInfo.getInfoTable("employeeNum"), searcher, searchString);

            Assertions.assertEquals(false, deleted.isEmpty());
            Assertions.assertEquals(1, deleted.size());
            Assertions.assertEquals(expectOutData, deleted.get(0).print());
        }

        @Test
        @DisplayName("Delete Employee by Implement")
        void delEmployeeByImpl() {
            searcher = mock(SearchStrategy.class);
            employeeInfoMgr = new EmployeeInfoMgr();
            employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), inputCmdData);

            Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));

            List<Employee> deletedList = employeeInfoMgr.delete(employeeInfo.getInfoTable("employeeNum"), searcher, searchString);

            Assertions.assertEquals(false, deletedList.isEmpty());
            Assertions.assertEquals(1, deletedList.size());
            Assertions.assertEquals(expectOutData, deletedList.get(0).print());
            Assertions.assertEquals(false, employeeInfo.getInfoTable("employeeNum").containsKey(employeeNum));
            Assertions.assertEquals(0, employeeInfo.getInfoTable("employeeNum").size());
        }

        @Test
        @DisplayName("Search Employee by Mock")
        void SearchEmployeeByMock() {
            searcher = mock(SearchStrategy.class);
            employeeInfoMgr = mock(EmployeeInfoMgr.class);

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));
            when(employeeInfoMgr.search(any(), any(), anyString())).thenReturn(Arrays.asList(employee));

            List<Employee> findedList = employeeInfoMgr.search(employeeInfo.getInfoTable("employeeNum"), searcher, searchString);

            Assertions.assertEquals(false, findedList.isEmpty());
            Assertions.assertEquals(1, findedList.size());
            Assertions.assertEquals(expectOutData, findedList.get(0).print());
        }

        @Test
        @DisplayName("Search Employee by Impl")
        void SearchEmployeeByImpl() {
            searcher = mock(SearchStrategy.class);
            employeeInfoMgr = new EmployeeInfoMgr();
            employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), inputCmdData);

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));

            List<Employee> findedList = employeeInfoMgr.search(employeeInfo.getInfoTable("employeeNum"), searcher, searchString);

            Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());
            Assertions.assertEquals(false, findedList.isEmpty());
            Assertions.assertEquals(1, findedList.size());
            Assertions.assertEquals(expectOutData, findedList.get(0).print());
            Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());
            Assertions.assertEquals(expectOutData, employeeInfo.getInfoTable("employeeNum").get(employeeNum).print());
        }

        @Test
        @DisplayName("Modify Employee by Mock")
        void ModifyEmployeeByMock() {
            String commandData = "name,FB NTAWR,cl,CL3";

            searcher = mock(SearchStrategy.class);
            employeeInfoMgr = mock(EmployeeInfoMgr.class);

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));
            try {
                when(employeeInfoMgr.modify(any(), any(), anyString())).thenReturn(Arrays.asList(employee));

                List<Employee> prevList = employeeInfoMgr.modify(employeeInfo.getInfoTable("employeeNum"), searcher, commandData);

                Assertions.assertEquals(false, prevList.isEmpty());
                Assertions.assertEquals(1, prevList.size());
                Assertions.assertEquals(expectOutData, prevList.get(0).print());
            }
            catch (Exception e) {
                Assertions.fail();
            }
        }

        @Test
        @DisplayName("Modify Employee by Implement")
        void ModifyEmployeeByImpl() {
            String commandData = "name,VXIHXOTH JHOP,cl,CL4";
            String modifiedData = "15123099,VXIHXOTH JHOP,CL4,010-3112-2609,19771211,ADV";

            searcher = mock(SearchStrategy.class);
            employeeInfoMgr = new EmployeeInfoMgr();
            employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), inputCmdData);

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));

            try {
                List<Employee> prevList = employeeInfoMgr.modify(employeeInfo.getInfoTable("employeeNum"), searcher, commandData);

                Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());
                Assertions.assertEquals(false, prevList.isEmpty());
                Assertions.assertEquals(1, prevList.size());
                Assertions.assertEquals(expectOutData, prevList.get(0).print());
                Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());
                Assertions.assertEquals(modifiedData, employeeInfo.getInfoTable("employeeNum").get(employeeNum).print());
            }
            catch (Exception ex) {
                Assertions.fail();
            }
        }
    }
}