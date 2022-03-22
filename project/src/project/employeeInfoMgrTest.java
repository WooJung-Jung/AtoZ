package project;

import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.ArrayList;
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
            ArrayList<Data> data = new ArrayList<Data>();
            String[] strArray = inputCmdData.split(",");

            data.add(new Data("employeeNum", strArray[0]));
            data.add(new Data("name", strArray[1]));
            data.add(new Data("cl", strArray[2]));
            data.add(new Data("phoneNum", strArray[3]));
            data.add(new Data("birthday", strArray[4]));
            data.add(new Data("certi", strArray[5]));

            Assertions.assertEquals(0, employeeInfo.getInfoTable("employeeNum").size());
            Assertions.assertEquals(true, employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), data));
            Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());
            Assertions.assertEquals(true, employeeInfo.getInfoTable("employeeNum").containsKey(15123099));
            Assertions.assertEquals(expectOutData, employeeInfo.getInfoTable("employeeNum").get(15123099).print());
        }
    }

    @Nested
    @DisplayName("When employee exist")
    class WhenExist {
        @Mock
        private Searcher searcher;
        private final Integer employeeNum = 15123099;
        private final String searchString = "employeeNum,15123099";
        private ArrayList<Data> cmdData = new ArrayList<Data>();
        private ArrayList<Data> newData = new ArrayList<Data>();
        @BeforeEach
        void init() {
            searcher = mock(Searcher.class);
            cmdData.add(new Data("employeeNum","15123099"));

            String[] strArray = inputCmdData.split(",");

            newData.add(new Data("employeeNum", strArray[0]));
            newData.add(new Data("name", strArray[1]));
            newData.add(new Data("cl", strArray[2]));
            newData.add(new Data("phoneNum", strArray[3]));
            newData.add(new Data("birthday", strArray[4]));
            newData.add(new Data("certi", strArray[5]));

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
            searcher = mock(Searcher.class);
            employeeInfoMgr = mock(EmployeeInfoMgr.class);

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));
            when(employeeInfoMgr.delete(any(), any(), any())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));

            List<Employee> deleted = employeeInfoMgr.delete(employeeInfo.getInfoTable("employeeNum"), searcher, cmdData);

            Assertions.assertEquals(false, deleted.isEmpty());
            Assertions.assertEquals(1, deleted.size());
            Assertions.assertEquals(expectOutData, deleted.get(0).print());
        }

        @Test
        @DisplayName("Delete Employee by Implement")
        void delEmployeeByImpl() {
            searcher = mock(Searcher.class);
            employeeInfoMgr = new EmployeeInfoMgr();
            employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), newData);

            Assertions.assertEquals(1, employeeInfo.getInfoTable("employeeNum").size());

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));

            List<Employee> deletedList = employeeInfoMgr.delete(employeeInfo.getInfoTable("employeeNum"), searcher, cmdData);

            Assertions.assertEquals(false, deletedList.isEmpty());
            Assertions.assertEquals(1, deletedList.size());
            Assertions.assertEquals(expectOutData, deletedList.get(0).print());
            Assertions.assertEquals(false, employeeInfo.getInfoTable("employeeNum").containsKey(employeeNum));
            Assertions.assertEquals(0, employeeInfo.getInfoTable("employeeNum").size());
        }

        @Test
        @DisplayName("Search Employee by Mock")
        void SearchEmployeeByMock() {
            searcher = mock(Searcher.class);
            employeeInfoMgr = mock(EmployeeInfoMgr.class);

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));
            when(employeeInfoMgr.search(any(), any(), any())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));

            List<Employee> findedList = employeeInfoMgr.search(employeeInfo.getInfoTable("employeeNum"), searcher, cmdData);

            Assertions.assertEquals(false, findedList.isEmpty());
            Assertions.assertEquals(1, findedList.size());
            Assertions.assertEquals(expectOutData, findedList.get(0).print());
        }

        @Test
        @DisplayName("Search Employee by Impl")
        void SearchEmployeeByImpl() {
            searcher = mock(Searcher.class);
            employeeInfoMgr = new EmployeeInfoMgr();
            employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), newData);

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));

            List<Employee> findedList = employeeInfoMgr.search(employeeInfo.getInfoTable("employeeNum"), searcher, cmdData);

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

            searcher = mock(Searcher.class);
            employeeInfoMgr = mock(EmployeeInfoMgr.class);

            cmdData.clear();
            cmdData.add(new Data("name", "FB NTAWR"));
            cmdData.add(new Data("cl","CL3"));

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));
            try {
                when(employeeInfoMgr.modify(any(), any(), any())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));

                List<Employee> prevList = employeeInfoMgr.modify(employeeInfo.getInfoTable("employeeNum"), searcher, cmdData);

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

            cmdData.clear();
            cmdData.add(new Data("name", "VXIHXOTH JHOP"));
            cmdData.add(new Data("cl","CL4"));

            searcher = mock(Searcher.class);
            employeeInfoMgr = new EmployeeInfoMgr();
            employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), newData);

            when(searcher.Search(any(), anyString())).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));

            try {
                List<Employee> prevList = employeeInfoMgr.modify(employeeInfo.getInfoTable("employeeNum"), searcher, cmdData);

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