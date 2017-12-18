import org.junit.Test;
import play.Application;
import play.test.Helpers;
import play.test.TestBrowser;
import play.test.WithBrowser;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.*;

/**
 * @author Marlon Kewaldar
 * Test responsible for ensuring any browser can access the page
 */
public class BrowserTest extends WithBrowser {


    /**
     * Start a mock-application with a H2 Database
     * @return Application object that serves the code
     */
    public Application provideApplication() {
        return fakeApplication(inMemoryDatabase());
    }

    /**
     * Stars a mock browser (Chrome, Firefox, Safari?) that browses the application
     *
     * @param port port on which the browser connects
     * @return TestBrowser browser to connect to the application
     */
    public TestBrowser provideBrowser(int port) {
        return Helpers.testBrowser(port);
    }


    /**
     * Check if the content of the HTML page given has the welcome message in its body
     */
    @Test
    public void indexContentContainsMessage() {
        browser.goTo("http://localhost:" + play.api.test.Helpers.testServerPort() + "/songs");
        browser.goTo("/");
        assertTrue(browser.pageSource().contains("Welcome to the Song Manager!"));
    }

    /**
     * Check if the content of the HTML page renders correctly
     */
    @Test
    public void indexContentIsNotNull() {
        browser.goTo("http://localhost:" + play.api.test.Helpers.testServerPort() + "/songs");
        browser.goTo("/");
        assertNotNull(browser.pageSource());
    }

    /**
     * Check if the application throws an error message if user goes to a random page
     */
    @Test
    public void indexThrowsErrorIfUrlIsInvalid() {
        browser.goTo("http://localhost:" + play.api.test.Helpers.testServerPort() + "/songs");
        browser.goTo("/je3i12jrij09sdu09");
        assertTrue(browser.pageSource().contains("Action Not Found"));
    }

}
