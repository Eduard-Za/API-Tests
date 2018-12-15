import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    protected static Logger logger = LoggerFactory.getLogger("Test");

    @Before
    public void setUp() {
        logger.info("Start test");
    }

    @After
    public void tearDown() {
        logger.info("End test");
    }
}
