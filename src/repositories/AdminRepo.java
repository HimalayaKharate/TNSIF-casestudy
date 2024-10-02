package repositories;

import entities.Admin;
import validation_service.AdminValidationService;

import java.util.ArrayList;
import java.util.List;

public class AdminRepo {

    AdminValidationService adminValidationService = new AdminValidationService();
    private final List<Admin> admins;

    public AdminRepo() {
        admins = new ArrayList<Admin>();
    }

    // Validates and Adds Admin
    public void add(Admin admin) {
        if (adminValidationService.validateAdmin(admin, admins)) {
            admins.add(admin);
        }else{
            System.out.println("Invalid Admin");
        }
    }

    // Validates and add List of Admins
    public void addAdmins(List<Admin> admins) {
        for (Admin admin : admins) {
            if(adminValidationService.validateAdmin(admin, admins)) {
                admins.add(admin);
            }
        }
    }

    // finds admin by email
    public Admin findAdminByEmail(String email) {
        return admins.stream().filter(admin -> admin.getEmail().equals(email)).findFirst().orElse(null);
    }

    // finds admin by Username
    public Admin findAdminByUsername(String username) {
        return admins.stream().filter(admin -> admin.getEmail().equals(username)).findFirst().orElse(null);
    }

    // finds admin by Id
    public Admin findAdminById(int id) {
        return admins.stream().filter(admin-> admin.getUserId() == id).findFirst().orElse(null);
    }

    //List all Admins
    public  List<Admin> findAllAdmins() {
        return admins;
    }
}
