package services;

import entities.Admin;
import entities.Product;
import repositories.AdminRepo;

import java.util.List;
import java.util.Scanner;

public class AdminService {

    AdminRepo repo = new AdminRepo();

    public void add(Scanner scanner){
        System.out.println("Enter the id of the admin : ");
        int id = scanner.nextInt();
        System.out.println("Enter the name of the admin : ");
        String name = scanner.next();
        System.out.println("Enter the email of the admin : ");
        String email = scanner.next();
        Admin admin = new Admin(id, name, email);
        repo.add(admin);
    }

    public void getAdmins(){
        List<Admin> admins = repo.findAllAdmins();
        System.out.println(String.format("| %-10s | %-20s | %-30s |", "User ID", "User Name", "Email"));
        System.out.println("-------------------------------------------------------------");
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

}
