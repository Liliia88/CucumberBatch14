package steps;

import pages.*;

public class PageInitializer {

    public static LoginPage login;
    public static DashboardPage dashboard;
    public static AddEmployeePage addEmployee;

    public static EmployeeListPage employeeList;
    public static QualificationsPage employeeInfo;


    public static void initializePageObjects(){
        login = new LoginPage();
        dashboard = new DashboardPage();
        addEmployee = new AddEmployeePage();
        employeeList= new EmployeeListPage();
        employeeInfo = new QualificationsPage ();

    }


}
