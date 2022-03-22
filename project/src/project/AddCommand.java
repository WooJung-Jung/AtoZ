package project;

import java.util.ArrayList;

public class AddCommand implements Command{
    @Override
    public void execute(CmdInfo cmdInfo, EmployeeInfo info, EmployeeInfoMgr infoMgr) {
        infoMgr.add(info.getInfoTable("employeeNum"), cmdInfo.commandData);
    }

    @Override
    public boolean hasResult() {
        return false;
    }

    @Override
    public ArrayList<Employee> getResult() {
        return null;
    }
}
