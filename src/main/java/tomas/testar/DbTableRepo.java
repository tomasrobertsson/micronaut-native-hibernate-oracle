package tomas.testar;


import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import tomas.testar.domain.DbTable;

import java.util.List;


@JdbcRepository(dialect = Dialect.ORACLE)
public interface DbTableRepo extends CrudRepository<DbTable, Long> {

    List<DbTable> getByMessageEqual(String message);

}
