import com.google.common.collect.ImmutableMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.db.Database;
import play.db.Databases;
import play.db.evolutions.Evolution;
import play.db.evolutions.Evolutions;

import java.sql.Connection;

import static junit.framework.TestCase.assertTrue;

/**
 * @author Marlon Kewaldar
 * Test responsible for ensuring a proper connection to a MySQL database can take place
 */
public class DatabaseTest {

    private Database db;

    //Arrange
    @Before
    public void initDb() {
        db = Databases.createFrom(
                "default",
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost/songManagerdb",
                //A simple map that serves as a configuration file of sorts
                ImmutableMap.of(
                        "username", "root",
                        "password", ""
                )
        );
    }
    /**
     * Test responsible for establishing a connection, and manipulating the database soon after
     * @throws Exception SQLException exception thrown if the method isn't written correctly
     */
    @Test
    public void testDatabaseConnection() throws Exception {
        Connection connection = db.getConnection();
        //Prepare a simple SQL statement, then inputs it
        connection.prepareStatement("insert into song values (10, 'testing')").execute();

        //Check if the previous added entry is added
        assertTrue(
                connection.prepareStatement("select * from song where id = 10")
                        .executeQuery().next()
        );
    }

    /**
     * Shuts the database down, then clean the Evolutions content
     */
    @After
    public void shutdownAndClearDb() {
        Evolutions.cleanupEvolutions(db);
        db.shutdown();
    }

}
