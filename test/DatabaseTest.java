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

    Database db;

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
        // Evolutions is a special dependency for the Java Play database that allows working with EBean
        Evolutions.applyEvolutions(db);
    }


    @Test
    public void testDatabase() throws Exception {
//        Connection connection = db.getConnection();
//        connection.prepareStatement("insert into song values (10, 'testing')").execute();
//
//        assertTrue(
//                connection.prepareStatement("select * from song where id = 10")
//                        .executeQuery().next()
//        );
//    }
    }

    @After
    public void shutdownAndClearDb() {
        Evolutions.cleanupEvolutions(db);
        db.shutdown();
    }

}
