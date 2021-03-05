package tomas.testar.properties;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MailPropsTest {

    @Inject
    MailProps mailProps;

    @Test
    public void testProps() {
//        assertEquals(2, mailProps.getUsers().size());
//        final User user = mailProps.getUsers().get(1);
//        assertEquals("yeallow", user.getColors().getPrimary());

    }
}
