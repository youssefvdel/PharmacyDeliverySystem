package controllers;

public class AuthController {
    public boolean login(String email, String password) {
        return email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }

    public void logout() {
        System.out.println("Logged out");
    }
}
