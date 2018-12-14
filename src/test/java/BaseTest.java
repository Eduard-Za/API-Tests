import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JsonReader;

public class BaseTest {

    protected static Logger logger = LoggerFactory.getLogger(JsonReader.class);

    @Before
    public void setUp() {
        logger.info("Start test");
    }
}
