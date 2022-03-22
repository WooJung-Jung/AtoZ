package project;

import java.util.ArrayList;

public class SearchCommand extends ConditionalCommand{
    public SearchCommand(Searcher searcher) {
        super(searcher);
    }

    @Override
    ArrayList<Employee> executeImpl(CmdInfo cmdInfo, EmployeeInfo info, EmployeeInfoMgr infoMgr, Searcher searcher) {
        return infoMgr.search(info.getInfoTable("employeeNum"), searcher, cmdInfo.commandData);
    }
}
