package cl.bennder.backoffice.reponse;

/**
 * Created by Diego on 07-05-2017.
 */
public class LoginResponse extends ValidacionResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
