package project;

import java.util.ArrayList;

public abstract class ConditionalCommand implements Command {
    Searcher searcher;
    ArrayList<Employee> result;

    public ConditionalCommand(Searcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public void execute(CmdInfo cmdInfo, EmployeeInfo info, EmployeeInfoMgr infoMgr) {
        result = executeImpl(cmdInfo, info, infoMgr, searcher);
    }

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public ArrayList<Employee> getResult() {
        return result;
    }
    abstract ArrayList<Employee> executeImpl(CmdInfo cmdInfo, EmployeeInfo info, EmployeeInfoMgr infoMgr, Searcher searcher);
}
