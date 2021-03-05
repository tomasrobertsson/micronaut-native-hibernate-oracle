package tomas.testar.secrets;

public interface SecretsManagerService {
    String getSecret(String secretName, String secretKey);
}
