package dio.bootcamp.diospringsecurityjwt.dtos;

public class Sessao {
    private String login;
    private String token;

//getters e setters

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
