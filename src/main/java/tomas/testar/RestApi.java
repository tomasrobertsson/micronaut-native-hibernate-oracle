package tomas.testar;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tomas.testar.properties.MailProps;

import javax.inject.Inject;

@Controller
public class RestApi {
    private static final Logger LOG = LoggerFactory.getLogger(RestApi.class);

//    @Inject
//    public DbTableRepo tableRepo;
    @Inject
    MailProps mailProps;

//    @Inject
//    SecretsManagerService secretsManagerService;

//    @Get("/all")
//    public List<DbTable> getAll() {
//        List<DbTable> dbTables = new ArrayList<>();
//        tableRepo.findAll().forEach(dbTable -> dbTables.add(dbTable));
//        LOG.info("get all {}", dbTables.size());
//        LOG.info("My values {}", dbTables.toString());
//        return dbTables;
//    }
//
//    @Get("/id/{id}")
//    public Optional<DbTable> getById(@PathVariable Long id) {
//        LOG.info("find by id");
//        return tableRepo.findById(id);
//    }

    @Get("/props")
    public MailProps getProps() {
        return  mailProps;
    }

//    @Post("/create")
//    public DbTable createMessage(@Body Message message) {
//        DbTable dbTable = new DbTable(message.getMessage());
//        tableRepo.save(dbTable);
//        LOG.info("new message saved  {}", message);
//        return  dbTable;
//    }
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";

//    @Get("/secret")
//    public Map<String, String> getSecret() {

//        final String db_api_user = secretsManagerService.getSecret("Db_API_User", USER_NAME);
//        return Collections.singletonMap("key", db_api_user);
//    }

}
