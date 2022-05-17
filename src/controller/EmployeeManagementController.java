package controller;


import service.IEmployeeManagementService;

import static service.EmployeeManagementService.getEmployeeManagementService;
import static view.EmployeeManagement.getEmployeeManagement;
import static view.InputValidator.getInt;

public final class EmployeeManagementController  {
    private static EmployeeManagementController employeeManagementController;
    private final IEmployeeManagementService employeeManagementService;

    public static EmployeeManagementController getEmployeeManagementController() {
        if (employeeManagementController == null) {
            employeeManagementController = new EmployeeManagementController(getEmployeeManagementService());
        }
        return employeeManagementController;
    }

    public EmployeeManagementController(IEmployeeManagementService employeeManagementService) {
        this.employeeManagementService = employeeManagementService;
    }

    public void invokeAction() {
        getEmployeeManagement().display();
        switch (getInt("")) {

            case 0 -> employeeManagementService.hireEmployee();
            case 1 -> employeeManagementService.dismissEmployee();
            case 2 -> employeeManagementService.employeeStatus();
            case 3 -> employeeManagementService.showEmployees();
            case 4 -> {
            }
            default -> {
                System.out.println("Please choose and option from 0 to " + (getEmployeeManagement().getActions().size() - 1));
                invokeAction();
            }
        }
    }
}
