package pl.nullpointerexception.SpringAop.aop;

public class AdditionalCredentialsDto implements AdditionalCredentials {

    private String username;
    private String password;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
