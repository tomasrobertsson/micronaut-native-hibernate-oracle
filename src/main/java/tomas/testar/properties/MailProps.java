package tomas.testar.properties;

import io.micronaut.context.annotation.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("mail")
public class MailProps {
    private String username;
    private List<User> users;

    public String getUsername() { return username; }
    public void setUsername(String value) { this.username = value; }

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> value) { this.users = value; }
}
