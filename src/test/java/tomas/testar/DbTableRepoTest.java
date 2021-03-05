package tomas.testar;

//@MicronautTest
//class DbTableRepoTest {
//    @Inject
//    DbTableRepoH2 tableRepo;
//
//
//    @Test
//    public void repoTest() {
//        DbTable dbTable = new DbTable("Hello");
//        tableRepo.save(dbTable);
//        assertEquals(1, dbTable.getID());
//        assertEquals("Hello", dbTable.getMessage());
//        final Optional<DbTable> byId = tableRepo.findById(1L);
//        assertTrue(byId.isPresent());
//        AtomicInteger i = new AtomicInteger();
//        tableRepo.findAll().forEach(dbTable1 -> i.getAndIncrement());
//        assertEquals(1, i.get());
//        assertEquals(1, tableRepo.getByMessageEqual("Hello").size());
//
//
//    }
//
//}
