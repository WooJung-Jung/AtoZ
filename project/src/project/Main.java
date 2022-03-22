package project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("Invalid arguments error: <input file> <output file>");
			return;
		}

		String inputFile = args[0];
		String outputFile = args[1];

		IOManager ioManager = new FileIOManager();
		ArrayList<String> input = ioManager.read(inputFile);

		if (new File(outputFile).exists())
			new File(outputFile).delete();

		Parser parser = new Parser();
		ArrayList<CmdInfo> cmds = parser.parse(input);

		EmployeeInfo employeeInfo = new EmployeeInfo();
		SearchOptionBuilder searchOptionBuilder = new SearchOptionBuilder();
		DisplayOptionBuilder displayOptionBuilder = new DisplayOptionBuilder();
		
		for (CmdInfo cmd : cmds) {
			EmployeeInfoMgr employeeInfoMgr = new EmployeeInfoMgr();
			
			searchOptionBuilder.changeSearchStrategy(cmd.commandData.get(0).column, cmd.option.opt2, "");
			displayOptionBuilder.changeDisplayStrategy(cmd.option.opt1);

			Command command = CommandBuilder.createCommand(cmd, searchOptionBuilder.getSearcher());
			command.execute(cmd, employeeInfo, employeeInfoMgr);

			if (command.hasResult())
				ioManager.write(outputFile, displayOptionBuilder.getPlayer().Display(cmd.command, command.getResult()));
		}
	}
}
