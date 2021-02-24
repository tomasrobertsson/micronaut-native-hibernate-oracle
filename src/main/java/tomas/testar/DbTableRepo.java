package tomas.testar;


import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import tomas.testar.domain.DbTable;

import java.util.List;


@Repository
public interface DbTableRepo extends CrudRepository<DbTable, Long> {

    List<DbTable> getByMessageEqual(String message);

}
