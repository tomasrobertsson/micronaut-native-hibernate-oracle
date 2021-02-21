package tomas.testar;


import io.micronaut.context.annotation.Replaces;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;


@JdbcRepository(dialect = Dialect.H2)
@Replaces(DbTableRepo.class)
public interface DbTableRepoH2 extends DbTableRepo {

}
