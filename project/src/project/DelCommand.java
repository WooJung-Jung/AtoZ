package project;

import java.util.ArrayList;

public class DelCommand extends ConditionalCommand {
    public DelCommand(Searcher searcher) {
        super(searcher);
    }

    @Override
    ArrayList<Employee> executeImpl(CmdInfo cmdInfo, EmployeeInfo info, EmployeeInfoMgr infoMgr, Searcher searcher) {
        return infoMgr.delete(info.getInfoTable("employeeNum"), searcher, cmdInfo.commandData);
    }
}
