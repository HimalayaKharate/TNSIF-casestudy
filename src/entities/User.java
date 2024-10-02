package entities;

public class User {
    private int userId;
    private String userName;
    private String email;

    public User() {
    }

    public User(int userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public User(User user){
        this(user.userId,user.userName,user.email);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-30s |", getUserId(), getUserName(), getEmail());
    }
}
