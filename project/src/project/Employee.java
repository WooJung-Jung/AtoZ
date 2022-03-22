package project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    private Integer employeeNum;
    private String name;
    private String cl;
    private String phoneNum;
    private String birthday;
    private String certi;
    private final int ENTRY_YEAR_OFFSET = 1000000;

    public Employee(String employeeNum, String name, String cl, String phoneNum, String birthday, String certi) throws ParseException {
        this.employeeNum = Integer.parseInt(employeeNum);
        this.name = name;
        this.cl = cl;
        this.phoneNum = phoneNum;
        this.birthday = birthday;
        this.certi = certi;
    }

    public Integer getEmployeeNum() { return employeeNum; }
    public String getName() { return name; }
    public String getFirstName() { return name.substring(0, name.indexOf(' ')); }
    public String getLastName() { return name.substring(name.indexOf(' ') + 1); }
    public String getCl() { return cl; }
    public String getPhoneNum() { return phoneNum; }
    public String getBirthday() { return birthday; }
    public String getBirthdayYear() { return birthday.substring(0,4); }
    public String getBirthdayMonth() { return birthday.substring(4,6); }
    public String getBirthdayDay() {return birthday.substring(6); }
    public String getCerti() { return certi; }

    public String print() {
        return employeeNum + ","
                + name + ","
                + cl  + ","
                + phoneNum + ","
                + birthday + ","
                + certi;
    }
    
    public static String printAll(List<Employee> list) {
    	String ret = "";
		for(Employee emp : list) {
			ret += emp.print();
		}
    	return ret;
    }

    public void modify(String field, String value) throws ParseException {
        switch (field) {
            case "name":
                this.name = value;
                break;
            case "cl":
                this.cl = value;
                break;
            case "phoneNum":
                this.phoneNum = value;
                break;
            case "birthday":
                this.birthday = value;
                break;
            case "certi":
                this.certi = value;
                break;
        }
    }

    public Integer getEntryYear() {
        return employeeNum / ENTRY_YEAR_OFFSET;
    }

    public Integer getExtraNumber() {
        return employeeNum % ENTRY_YEAR_OFFSET;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!obj.getClass().equals(Employee.class)) return false;

        Employee employee = (Employee)obj;
        if(this.getEmployeeNum().equals(employee.getEmployeeNum())) return true;
        return false;
    }
}
