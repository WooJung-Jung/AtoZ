package project;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {

		ArrayList<String> input = new ArrayList<String>();

		FileIOManager ioManager = new FileIOManager();
		input = ioManager.read("input.txt");

		Parser parser = new Parser();
		ArrayList<CmdInfo> cmds = parser.parse(input);

		EmployeeInfo employeeInfo = new EmployeeInfo();
		ArrayList<String> output = new ArrayList<String>();

		for (CmdInfo cmd : cmds) {
			EmployeeInfoMgr employeeInfoMgr = new EmployeeInfoMgr();

			if ("ADD".equals(cmd.command)) {
				employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), cmd.commandData);
			} 
			else if ("DEL".equals(cmd.command)) {
				SearchOptionBuilder searchOptionBuilder = new SearchOptionBuilder(cmd.commandData.get(0).column, cmd.option.opt2, "");
				output.add(Employee.printAll(employeeInfoMgr.delete(employeeInfo.getInfoTable("employeeNum"), searchOptionBuilder.getSearcher(), cmd.commandData)));
			} 			
			else if ("SCH".equals(cmd.command)) {
				SearchOptionBuilder searchOptionBuilder = new SearchOptionBuilder(cmd.commandData.get(0).column, cmd.option.opt2, "");
				output.add(Employee.printAll(employeeInfoMgr.search(employeeInfo.getInfoTable("employeeNum"), searchOptionBuilder.getSearcher(), cmd.commandData)));
			} 
			else if ("MOD".equals(cmd.command)) {
				SearchOptionBuilder searchOptionBuilder = new SearchOptionBuilder(cmd.commandData.get(0).column, cmd.option.opt2, "");
				output.add(Employee.printAll(employeeInfoMgr.modify(employeeInfo.getInfoTable("employeeNum"), searchOptionBuilder.getSearcher(), cmd.commandData)));
			}

			ioManager.write("output.txt", output);
		}
	}
}
