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

class Data{
	String column, value;
	Data(String column, String value){
		this.column = column;
		this.value = value;
	}
}

class Variable {
	String command;
	Option option;
	ArrayList<Data> data;
}

public class Parser {
	ArrayList<Variable> parse(ArrayList<String> strs) {
		
		ArrayList<Variable> result = new ArrayList<Variable>();
		
		for (int i = 0; i < strs.size(); i++) {
			String[] strArray = strs.get(i).split(",");
			Variable var = new Variable();
			
			var.command = strArray[0];
			var.option = new Option(strArray[1], strArray[2], strArray[3]);
			
			if(!commandValid(strArray[0])){
				continue;
			}
			if(!optionValid(new Option(strArray[1], strArray[2], strArray[3]))) {
				continue;
			}
			
			
			if("ADD".equals(var.command)){
				if(employeeNumValid(strArray[4]) 
						&& clValid(strArray[6])
						&& phoneNumValid(strArray[7])
						&& birthdayValid(strArray[8])
						&& certiValid(strArray[9])) {
					var.data = new ArrayList<Data>();
					var.data.add(new Data("employeeNum", strArray[4]));
					var.data.add(new Data("name", strArray[5]));
					var.data.add(new Data("cl", strArray[6]));
					var.data.add(new Data("phoneNum", strArray[7]));
					var.data.add(new Data("birthday", strArray[8]));
					var.data.add(new Data("certi", strArray[9]));
				}
			}
			
			else if("DEL".equals(var.command) || "SCH".equals(var.command)){
				var.data = new ArrayList<Data>();
				var.data.add(new Data(strArray[4], strArray[5]));
			}
			
			else if("MOD".equals(var.command)) {
				var.data = new ArrayList<Data>();
				var.data.add(new Data(strArray[4], strArray[5]));
				var.data.add(new Data(strArray[6], strArray[7]));
			}
			result.add(var);
		}
		
		return result;
	}

	boolean commandValid(String cmd) {
		return "ADD".equals(cmd) || "DEL".equals(cmd) || "SCH".equals(cmd) || "MOD".equals(cmd);
	}

	boolean optionValid(Option opts) {	
		String opt1Regex = "^(\\s|-p)$";
		String opt2Regex = "^(\\s|-[flmyd])$";
		
		return Pattern.matches(opt1Regex, opts.opt1)
				&& Pattern.matches(opt2Regex, opts.opt2)
				&& (" ".equals(opts.opt3));
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
		return Pattern.matches("^\\d{8}$", str);
	}
	
	boolean certiValid(String str) {
		return Pattern.matches("^(ADV|PRO|EX)$", str);
	}
}
