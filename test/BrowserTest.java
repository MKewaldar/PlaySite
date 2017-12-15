import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import play.Application;
import play.test.Helpers;
import play.test.TestBrowser;
import play.test.WithBrowser;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.*;

public class BrowserTest extends WithBrowser {


    public Application provideApplication() {
        return fakeApplication(inMemoryDatabase());
    }

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
}
