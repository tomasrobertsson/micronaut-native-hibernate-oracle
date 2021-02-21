package tomas.testar;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import tomas.testar.domain.DbTable;

import javax.inject.Inject;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class DbTableRepoTest {
    @Inject
    DbTableRepoH2 tableRepo;


    @Test
    public void repoTest() {
        DbTable dbTable = new DbTable("Hello");
        tableRepo.save(dbTable);
        assertEquals(1, dbTable.getID());
        assertEquals("Hello", dbTable.getMessage());
        final Optional<DbTable> byId = tableRepo.findById(1L);
        assertTrue(byId.isPresent());
        AtomicInteger i = new AtomicInteger();
        tableRepo.findAll().forEach(dbTable1 -> i.getAndIncrement());
        assertEquals(1, i.get());
        assertEquals(1, tableRepo.getByMessageEqual("Hello").size());


    }

}
