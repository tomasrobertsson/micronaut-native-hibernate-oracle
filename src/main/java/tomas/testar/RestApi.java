package tomas.testar;

import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tomas.testar.domain.DbTable;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class RestApi {
    private static final Logger LOG = LoggerFactory.getLogger(RestApi.class);

    @Inject
    public DbTableRepo tableRepo;


    @Get("/all")
    public List<DbTable> getAll() {
        List<DbTable> dbTables = new ArrayList<>();
        tableRepo.findAll().forEach(dbTable -> dbTables.add(dbTable));
        LOG.info("get all {}", dbTables.size());
        return dbTables;
    }

    @Get("/id/{id}")
    public Optional<DbTable> getById(@PathVariable Long id) {
        LOG.info("find by id");
        return tableRepo.findById(id);
    }

    @Post("/create")
    public DbTable createMessage(@Body Message message) {
        DbTable dbTable = new DbTable(message.getMessage());
        tableRepo.save(dbTable);
        LOG.info("new message saved  {}", message);
        return  dbTable;
    }


}
