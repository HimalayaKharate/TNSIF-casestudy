package entities;

public class Admin extends User {


    public Admin(int userId, String userName, String email) {
        super(userId, userName, email);
    }

    public Admin(User user) {
        super(user);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
