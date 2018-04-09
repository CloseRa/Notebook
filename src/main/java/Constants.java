package main.java;

/**
 * Interface for storing constants
 *
 * @autor Vlad
 */
public interface Constants {
    String STARTMESSAGE = "Commands :\n add - add person\n del - delete last added person\n find - find person by name surname" +
            "or by phone number\n" + " sort - sort by surname or birth date\n exit - close program.";
    String CHOOSE = "Add employee or manager?\n Commands:\n e - add employee\n m - add manager";
    String EMPLOYEE = "e";
    String ENTERNAME = "Enter a name: ";
    String ENTERSURNAME = "Enter a surname: ";
    String ENTERBIRTHYEAR = "Enter a year of birthday: ";
    String ENTERPHONE = "Enter a phone number: ";
    String ENTERDEPARTMENT = "Enter a department: ";
    String ENTERMANAGER = "Enter a manager: ";
    String NAME = "Name: ";
    String BYNAME = "n";
    String BYSURNAME = "sn";
    String BYPHONENUM = "pn";
    String SURNAME = "Surname: ";
    String BIRTHYEAR = "Date of birthday: ";
    String PHONENUMBER = "Phone number: ";
    String MANAGER = "m";
    String DEPARTMENT = "Department: ";
    String ENTERDELETE = "Enter 'del' to remove last added";
    String DELETE = "del";
    String EXIT = "exit";
    String SEARCH = "find";
    String STARTSEARCH = "Commands:\n n - search by name\n sn - search by surname\n pn - search by phonenum";
    String ADDPERSON = "add";
    String SORT = "sort";
    String BYBIRTHYEAR = "bd";
    String ENTERSORT = "Enter 'sn' to sort by surname, or 'bd' to sort by birthdate";
    String INPUTERROR = "Incorrect data. Try again.";
}
