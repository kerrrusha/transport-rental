package transportrental;

import com.kerrrusha.transportrental.TransportRentalDataApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = TransportRentalDataApplication.class)
class TransportRentalDataApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void interviewQuestionsTest() {
        String string = "hello";
        StringBuilder builder = new StringBuilder("hello");
        StringBuilder builder1 = new StringBuilder("hello");

        //boolean shouldNotCompile = string == builder;
        assertNotEquals(string, builder);
        assertNotEquals(builder, builder1);
    }

}
