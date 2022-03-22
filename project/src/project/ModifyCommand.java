package project;

import java.util.ArrayList;

public class ModifyCommand extends ConditionalCommand{
    public ModifyCommand(Searcher searcher) {
        super(searcher);
    }

    @Override
    ArrayList<Employee> executeImpl(CmdInfo cmdInfo, EmployeeInfo info, EmployeeInfoMgr infoMgr, Searcher searcher) {
        return infoMgr.modify(info.getInfoTable("employeeNum"), searcher, cmdInfo.commandData);
    }
}
