package validation_service;

import entities.Admin;

import java.util.List;

public class AdminValidationService {

    private boolean validateEmail(String email, List<Admin> admins){
        return admins.stream().noneMatch((s)-> s.getEmail().equals(email));
    }

    private boolean validateUsername(String username, List<Admin> admins){
        return admins.stream().noneMatch((s)->s.getUserName().equals(username));
    }

    private boolean validateUserId(int userId, List<Admin> admins){
        return admins.stream().noneMatch((s)->s.getUserId() == userId);
    }

    public boolean validateAdmin(Admin admin, List<Admin> admins) {
        boolean result = this.validateUserId(admin.getUserId(), admins) && this.validateEmail(admin.getEmail(), admins) && this.validateUsername(admin.getUserName(), admins);
        return result;
    }
}
