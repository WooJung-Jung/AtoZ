package project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {

		ArrayList<String> input = new ArrayList<String>();

		FileIOManager ioManager = new FileIOManager();
		input = ioManager.read("D:\\code\\git\\AtoZ\\input.txt");

		if (new File("D:\\code\\git\\AtoZ\\output.txt").exists())
			new File("D:\\code\\git\\AtoZ\\output.txt").delete();

		Parser parser = new Parser();
		ArrayList<CmdInfo> cmds = parser.parse(input);

		EmployeeInfo employeeInfo = new EmployeeInfo();
		SearchOptionBuilder searchOptionBuilder = new SearchOptionBuilder();
		DisplayOptionBuilder displayOptionBuilder = new DisplayOptionBuilder();
		ArrayList<Employee> ret = new ArrayList<Employee>();
		
		for (CmdInfo cmd : cmds) {
			EmployeeInfoMgr employeeInfoMgr = new EmployeeInfoMgr();
			
			searchOptionBuilder.changeSearchStrategy(cmd.commandData.get(0).column, cmd.option.opt2, "");
			displayOptionBuilder.changeDisplayStrategy(cmd.option.opt1);
			
			if ("ADD".equals(cmd.command)) {
				employeeInfoMgr.add(employeeInfo.getInfoTable("employeeNum"), cmd.commandData);
			} 
			else if ("DEL".equals(cmd.command)) {
				ret = employeeInfoMgr.delete(employeeInfo.getInfoTable("employeeNum"), searchOptionBuilder.getSearcher(), cmd.commandData);
			} 			
			else if ("SCH".equals(cmd.command)) {			
				ret = employeeInfoMgr.search(employeeInfo.getInfoTable("employeeNum"), searchOptionBuilder.getSearcher(), cmd.commandData);
			} 
			else if ("MOD".equals(cmd.command)) {
				ret = employeeInfoMgr.modify(employeeInfo.getInfoTable("employeeNum"), searchOptionBuilder.getSearcher(), cmd.commandData);
			}

			if ("ADD".equals(cmd.command) == false) {
				ioManager.write("D:\\code\\git\\AtoZ\\output.txt", displayOptionBuilder.getPlayer().Display(cmd.command, ret));
			}
			ret.clear();
		}
	}
}
