package tomas.testar;

import io.micronaut.runtime.Micronaut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
//    @Inject
//    PrimaryRepositoryOperations repositoryOperations;

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

//    @PostConstruct
//    public void prepare() {
//        LOG.info("Post construct {}", repositoryOperations.getClass().getName());
//    }
}
