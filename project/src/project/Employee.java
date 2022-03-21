package project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private Integer employeeNum;
    private String firstName;
    private String lastName;
    private String cl;
    private String phoneNum;
    private Date birthday;
    private String certi;
    private final int ENTRY_YEAR_OFFSET = 1000000;

    public Employee(String employeeNum, String name, String cl, String phoneNum, String birthday, String certi) throws ParseException {
        this.employeeNum = Integer.parseInt(employeeNum);
        this.firstName = name.substring(0, name.indexOf(' '));
        this.lastName = name.substring(name.indexOf(' ') + 1);
        this.cl = cl;
        this.phoneNum = phoneNum;
        this.birthday = new SimpleDateFormat("yyyyMMdd").parse(birthday);
        this.certi = certi;
    }

    public Integer getEmployeeNum() { return employeeNum; }
    public String getName() { return firstName + " " + lastName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCl() { return cl; }
    public String getPhoneNum() { return phoneNum; }
    public Date getBirthday() { return birthday; }
    public String getCerti() { return certi; }

    public String print() {
        return employeeNum + ","
                + firstName + " " + lastName + ","
                + cl  + ","
                + phoneNum + ","
                + new SimpleDateFormat("yyyyMMdd").format(birthday) + ","
                + certi;
    }

    public void modify(String field, String value) throws ParseException {
        switch (field) {
            case "name":
                this.firstName = value.substring(0, value.indexOf(' '));
                this.lastName = value.substring(value.indexOf(' ') + 1);
                break;
            case "cl":
                this.cl = value;
                break;
            case "phoneNum":
                this.phoneNum = value;
                break;
            case "birthday":
                this.birthday = new SimpleDateFormat("yyyyMMdd").parse(value);
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
}
