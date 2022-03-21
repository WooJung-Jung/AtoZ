package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        int emp1Num = emp1.employeeNum;
        int emp2Num = emp2.employeeNum;

        if(emp1Num < 69000000) emp1Num = emp1Num*100000000;
        if(emp2Num < 69000000) emp2Num = emp2Num*100000000;
        if (emp1Num > emp2Num) {
            return 1;
        } else if (emp1Num < emp2Num) {
            return -1;
        }
        return 0;
    }
}

public abstract class option {

    private ArrayList<Employee> allEmployee;

    public option(ArrayList<Employee> allEmp) {
        this.allEmployee = allEmp;
    }

    public abstract ArrayList<Employee> optionPlay(String opt, ArrayList<Employee> empList);

    public ArrayList<Employee> firstOption(String opt, ArrayList<Employee> empList){
        ArrayList<Employee> employee = empList;
        Collections.sort(employee, new EmployeeComparator());
        while(employee.size()>5){
            employee.remove(5);
        }
        return employee;
    }

    public String[] splitOption(String opt){
        return opt.split(",");
    }

    public void printEmp(String opt, ArrayList<Employee> empList){
        String[] splitOpt = splitOption(opt);
        if(empList.size() == 0) {
            System.out.println(splitOpt[0] + ",NONE");
        }else if(splitOpt[1] == "") {
            System.out.println(splitOpt[0] + "," + empList.size());
        }
        for(Employee i:empList) {
            System.out.println(splitOpt[0] + "," + i.employeeNum + "," + i.firstName + "," + i.lastName + "," + i.cl + "," + i.phoneNum + "," + i.birthday + "," + i.certi);
        }
    }

    public ArrayList<Employee> secondOption(String opt, String type, String findStr) {
        ArrayList<Employee> employee = new ArrayList<Employee>();
        if (opt.equals("")) {
            return employee;
        }
        employee = allEmployee;
        if (type.equals("name")) {
            if (opt.equals("-f")) {
                return (ArrayList<Employee>) employee.stream().filter(a -> a.firstName.equals(findStr)).collect(Collectors.toList());
            } else if (opt.equals("-l")) {
                return (ArrayList<Employee>) employee.stream().filter(a -> a.lastName.equals(findStr)).collect(Collectors.toList());
            }
        } else if (type.equals("phoneNum")) {
            if (opt.equals("-m")) {
                employee = (ArrayList<Employee>) allEmployee.stream().filter(a -> a.phoneNum.split("-")[1].equals(findStr)).collect(Collectors.toList());
            } else if (opt.equals("-l")) {
                employee = (ArrayList<Employee>) allEmployee.stream().filter(a -> a.phoneNum.split("-")[2].equals(findStr)).collect(Collectors.toList());
            }
        } else if (type.equals("birthday")) {
            if (opt.equals("-y")) {
                employee = (ArrayList<Employee>) allEmployee.stream().filter(a -> a.birthday.getMonth() + "" == findStr).collect(Collectors.toList());
            } else if (opt.equals("-m")) {
                employee = (ArrayList<Employee>) allEmployee.stream().filter(a -> a.birthday.getMonth() + "" == findStr).collect(Collectors.toList());
            } else if (opt.equals("-d")) {
                employee = (ArrayList<Employee>) allEmployee.stream().filter(a -> a.birthday.getDay() + "" == findStr).collect(Collectors.toList());
            }
        }
        return employee;
    }


}
