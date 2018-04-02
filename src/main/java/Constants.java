package main.java;
/**
 * Interface for storing constants
 * @autor Vlad
 */
public interface Constants {
    String STARTMESSAGE = "Commands :\n add - add person\n delete - delete person\n find - find person by name surname" +
            "or by phone number\n" + " sort - sort by surname or birth date\n exit - close program.";
    String CHOOSE = "Add employee or manager?\n Commands:\n employee - add employee\n manager - add manager";
    String EMPLOYEE = "employee";
    String ENTERNAME = "Enter a name: ";
    String ENTERSURNAME = "Enter a surname: ";
    String ENTERBIRTHYEAR = "Enter a date of birthday(dd/mm/yyyy): ";
    String ENTERPHONE = "Enter a phone number: ";
    String ENTERDEPARTMENT = "Enter a department: ";
    String ENTERMANAGER = "Enter a manager: ";
    String NAME = "Name: ";
    String BYNAME = "name";
    String BYSURNAME = "surname";
    String BYPHONENUM = "phonenum";
    String SURNAME = "Surname: ";
    String BIRTHYEAR = "Date of birthday: ";
    String PHONENUMBER = "Phone number: ";
    String MANAGER = "manager";
    String DEPARTMENT = "Department: ";
    String ENTERDELETE = "Enter 'delete' to remove last added";
    String DELETE = "delete";
    String EXIT = "exit";
    String SEARCH = "find";
    String STARTSEARCH = "Commands:\n name - search by name\n surname - search by surname\n phonenum - search by phonenum";
    String ADDPERSON = "add";
    String SORT = "sort";
    String BYBIRTHYEAR = "birthyear";
    String ENTERSORT = "Enter 'surname' to sort by surname, or 'birthdate' to sort by birthdate";
}
