package tomas.testar;


import io.micronaut.context.annotation.Replaces;
import io.micronaut.data.annotation.Repository;


@Repository
@Replaces(DbTableRepo.class)
public interface DbTableRepoH2 extends DbTableRepo {

}
