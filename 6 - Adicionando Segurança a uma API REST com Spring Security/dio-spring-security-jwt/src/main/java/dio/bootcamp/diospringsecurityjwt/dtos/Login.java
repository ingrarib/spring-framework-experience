package dio.bootcamp.diospringsecurityjwt.dtos;

public class Login {
    private String username;
    private String password;

    //getters e setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
