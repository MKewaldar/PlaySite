import org.junit.Test;
import play.Application;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;

import static junit.framework.TestCase.assertEquals;
import static play.test.Helpers.*;
/**
 * Tests responsible for evaluation the workings of the route system
 *
 * @author Marlon Kewaldar
 */

public class RouteTest {

    private final Application fakeAppWithMemoryDb = fakeApplication(inMemoryDatabase("test"));

    /**
     * Tests the routing to the home page, which should return code 200 (OK)
     */
    @Test
    public void testGoodRoute() {
        //Create a fake request using the Helpers package, which can mock certain objects
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method(GET)
                .uri("/");

        Result result = route(fakeAppWithMemoryDb, request);
        // OK = Code 200
        assertEquals(OK, result.status());
    }

    /**
     * Tests the routing to a non-existant page, which should return code 404 (NOT_FOUND)
     */
    @Test
    public void testBadRoutePageIsMissing() {
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method(GET)
                .uri("/rarqafafafgwerqwcqaf25/12481481489");

        Result result = route(fakeAppWithMemoryDb, request);
        //BAD_REQUEST = error 400
        assertEquals(NOT_FOUND, result.status());
    }
}
