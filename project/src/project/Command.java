package project;

import java.util.ArrayList;

public interface Command {
    void execute(CmdInfo cmdInfo, EmployeeInfo info, EmployeeInfoMgr infoMgr);
    boolean hasResult();
    ArrayList<Employee> getResult();
}
