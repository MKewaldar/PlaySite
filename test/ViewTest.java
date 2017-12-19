import org.junit.Before;
import org.junit.Test;
import play.core.j.JavaContextComponents;
import play.mvc.Http;
import play.test.WithApplication;
import play.twirl.api.Content;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * A functional test starts a Play application for every test.
 */
public class ViewTest extends WithApplication {

    /**
     * Mocks a HttpContext
     */
    //Assemble
    @Before
    public void setUp() {
        //Parameters that need to be specifically defined, but whose content is unimportant in the context of this test
        Map<String, String> flashData = Collections.emptyMap();
        Map<String, Object> argData = Collections.emptyMap();
        Long id = 2L;
        //Mock the header and the request itself using Mockito
        play.api.mvc.RequestHeader header = mock(play.api.mvc.RequestHeader.class);
        Http.Request request = mock(Http.Request.class);
        final JavaContextComponents components = app.injector().instanceOf(JavaContextComponents.class);

        //Assemble the above components, passing them as parameters for the context object
        Http.Context context = new Http.Context(id, header, request, flashData, flashData, argData, components);
        Http.Context.current.set(context);
    }

    /**
     * Renders the index view for testing
     * @return Content view to be tested
     */
    private Content renderView() {
        return views.html.index.render();
    }

    /**
     * Asserts that the view's body is not null
     */
    @Test
    public void assertViewBodyIsNotNull() {
        assertThat("text/html").isEqualTo(renderView().contentType());
        assertThat(renderView().body()).isNotNull();
    }

    /**
     * Assert that the view's body is not empty
     */
    @Test
    public void assertViewBodyIsNotEmpty() {
        assertThat("text/html").isEqualTo(renderView().contentType());
        assertThat(renderView().body()).isNotEmpty();
    }

    /**
     * Assert that the view's body contains the welcome message
     */
    @Test
    public void assertViewIsHtmlAndViewContainsMessage() {
        assertThat("text/html").isEqualTo(renderView().contentType());
        assertThat(renderView().body()).contains("Welcome to the Song Manager!");
    }

    /**
     * Assert that the view's body does not return false information
     */
    @Test
    public void assertViewDoesNotReturnFalseInformation() {
        assertThat("css").isNotSameAs(renderView().contentType());
        assertThat(renderView().body()).isNotSameAs("This isn't on the page source.");
    }
}
