package project;

import java.util.ArrayList;
import java.util.regex.Pattern;

class Option {
	String opt1, opt2, opt3;

	public Option(String opt1, String opt2, String opt3) {
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
	}
}

class Data {
	String column, value;

	Data(String column, String value) {
		this.column = column;
		this.value = value;
	}
}

class CmdInfo {
	String command;
	Option option;
	ArrayList<Data> data;
}

public class Parser {
	ArrayList<CmdInfo> parse(ArrayList<String> strs) {

		ArrayList<CmdInfo> result = new ArrayList<CmdInfo>();

		try {
			for (int i = 0; i < strs.size(); i++) {
				String[] strArray = strs.get(i).split(",");
				CmdInfo cmdInfo = new CmdInfo();

				cmdInfo.command = strArray[0];
				cmdInfo.option = new Option(strArray[1], strArray[2], strArray[3]);

				cmdInfo.data = new ArrayList<Data>();
				if ("ADD".equals(cmdInfo.command) && strArray.length - 4 == 6) {
					cmdInfo.data.add(new Data("employeeNum", strArray[4]));
					cmdInfo.data.add(new Data("name", strArray[5]));
					cmdInfo.data.add(new Data("cl", strArray[6]));
					cmdInfo.data.add(new Data("phoneNum", strArray[7]));
					cmdInfo.data.add(new Data("birthday", strArray[8]));
					cmdInfo.data.add(new Data("certi", strArray[9]));
				}

				else if (("DEL".equals(cmdInfo.command) || "SCH".equals(cmdInfo.command)) && strArray.length - 4 == 2) {
					cmdInfo.data.add(new Data(strArray[4], strArray[5]));
				}

				else if ("MOD".equals(cmdInfo.command) && strArray.length - 4 == 4) {
					cmdInfo.data.add(new Data(strArray[4], strArray[5]));
					cmdInfo.data.add(new Data(strArray[6], strArray[7]));
				}
				else
					continue;

				if (commandValid(cmdInfo.command) && optionValid(cmdInfo.option)&& dataValid(cmdInfo.data)) {
					result.add(cmdInfo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	boolean commandValid(String cmd) {
		return "ADD".equals(cmd) || "DEL".equals(cmd) || "SCH".equals(cmd) || "MOD".equals(cmd);
	}

	boolean optionValid(Option opts) {
		String opt1Regex = "^(\\s|-p)$";
		String opt2Regex = "^(\\s|-[flmyd])$";

		return Pattern.matches(opt1Regex, opts.opt1) && Pattern.matches(opt2Regex, opts.opt2)
				&& (" ".equals(opts.opt3));
	}

	boolean dataValid(ArrayList<Data> data) {
		for (Data d : data) {
			switch (d.column) {
			case "employeeNum":
				if (!employeeNumValid(d.value))
					return false;
				break;
			case "cl":
				if (!clValid(d.value))
					return false;
				break;
			case "phoneNum":
				if (!phoneNumValid(d.value))
					return false;
				break;
			case "birthday":
				if (!birthdayValid(d.value))
					return false;
				break;
			case "certi":
				if (!certiValid(d.value))
					return false;
				break;
			default:
				break;
			}
		}

		return true;
	}

	boolean employeeNumValid(String str) {
		return Pattern.matches("^\\d{8}$", str);
	}

	boolean clValid(String str) {
		return Pattern.matches("^CL[1-4]$", str);
	}

	boolean phoneNumValid(String str) {
		return Pattern.matches("^010-\\d{4}-\\d{4}$", str);
	}

	boolean birthdayValid(String str) {
		return Pattern.matches("^(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])$", str);
	}

	boolean certiValid(String str) {
		return Pattern.matches("^(ADV|PRO|EX)$", str);
	}
}
