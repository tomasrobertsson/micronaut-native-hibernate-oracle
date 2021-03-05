//package tomas.testar.secrets;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.micronaut.context.annotation.Value;
//import io.micronaut.core.util.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
//import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
//import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
//import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
//import software.amazon.awssdk.services.secretsmanager.model.InvalidRequestException;
//import software.amazon.awssdk.services.secretsmanager.model.ResourceNotFoundException;
//
//import javax.inject.Singleton;
//import java.io.IOException;
//import java.security.InvalidParameterException;
//import java.util.Hashtable;
//import java.util.Map;
//import java.util.Optional;
//
//@Singleton
//
//public class AWSSecretsManagerServiceImpl implements SecretsManagerService {
//
//    private static final Logger LOG = LoggerFactory.getLogger(AWSSecretsManagerServiceImpl.class);
//
//    @Value("${aws-test-user}")
//    String DEFAULT_IAM_DEVELOP_ID = "cxloyal";
//    @Value("${aws-region}")
//    String awsRegion;
//    private Map<String, String> secretsMap = new Hashtable<>();
//
//    public AWSSecretsManagerServiceImpl() {
//        super();
//    }
//
//    private String getSecretFromMap(String secretName) {
//        if (secretsMap.containsKey(secretName)) {
//            return secretsMap.get(secretName);
//        }
//        return "";
//    }
//
//    @Override
//    public String getSecret(String secretName, String secretKey) {
//        LOG.info("GetSecret");
//        if(StringUtils.isEmpty(secretName))
//            throw  new RuntimeException("Secret name cannot be empty!");
//        if(StringUtils.isEmpty(secretKey))
//            throw  new RuntimeException("Secret key cannot be empty!");
//        String secret = getSecret(secretName);
//        if (StringUtils.isNotEmpty(secret)) {
//            return parseGetFromJson(secret, secretKey);
//        } else
//            throw  new RuntimeException("Secret not found");
//
//    }
//
//    private SecretsManagerClient getClient() {
//        LOG.info("GetClient");
//        /* Try to build credentials with IAM-name.
//        * Mostly to support developer IAM
//        /* If none found IllegalArg thrown and access by simple config tried */
//        try {
//            AwsCredentialsProvider profileCred = ProfileCredentialsProvider.builder()
//                    .profileName(DEFAULT_IAM_DEVELOP_ID)
//                    .build();
//            profileCred.resolveCredentials(); //verify loaded profile
//            LOG.info("client found {}", DEFAULT_IAM_DEVELOP_ID);
//            return SecretsManagerClient.builder() //TODO: Test specify client
//                    .credentialsProvider(profileCred)
//                    .region(Region.of(awsRegion))
//                    .build();
//
//        } catch (Exception ex) {
//            LOG.info("No client found, use default client");
//
//        }
//        return SecretsManagerClient.builder()
//                .region(Region.of(awsRegion))
//                .build();
//
//    }
//
//    protected String getSecret(String secretName) {
//        String secret = getSecretFromMap(secretName);
//        LOG.info("Secret not found in map");
//        if (secret != null && !secret.isEmpty())
//            return secret;
//
//            try(SecretsManagerClient client = getClient()) {
//
//                GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
//                        .secretId(secretName)
//                        .build();
//                GetSecretValueResponse getSecretValueResult = null;
//                try {
//                    getSecretValueResult = client.getSecretValue(getSecretValueRequest);
//
//                } catch (ResourceNotFoundException e) {
//                    LOG.error("The requested secret " + secretName + " was not found");
//                } catch (InvalidRequestException e) {
//                    LOG.error("The request was invalid due to: " + e.getMessage());
//                } catch (InvalidParameterException e) {
//                    LOG.error("The request had invalid params: " + e.getMessage());
//                } catch (Exception e) {
//                    LOG.error("Unknow exception thrown: {}", e);
//                }
//
//
//                if (getSecretValueResult == null) {
//                    return "";
//                }
//
//                Optional<String> secretResult = getSecretValueResult.getValueForField("SecretString", String.class);
//                secret = secretResult.orElse("");
//                //new secret, stored to hash
//                if (StringUtils.isNotEmpty(secret))
//                    secretsMap.put(secretName, secret);
//                else {
//                    LOG.error("Unable to retrieve secret, probably miss IAM user on local instance");
//                    throw new RuntimeException("Unable to retrieve secret, probably miss IAM user on local instance");
//                }
//            }
//
//        return secret;
//
//    }
//
//    private String parseGetFromJson(String secret, String secretKey) {
//        try {
//            LOG.info("Parse secret");
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode jsonNode = mapper.readTree(secret);
//            JsonNode node = jsonNode.get(secretKey);
//            if(node != null)
//                return node.asText();
//
//        } catch (IOException e) {
//            LOG.error("Unable to parse secret node", e);
//        }
//        throw new RuntimeException("Unable to retrieve secret by secretKey " + secretKey);
//    }
//
//
//}
