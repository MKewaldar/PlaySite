package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.Counter;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Marlon Kewaldar
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton
public class CountController extends Controller {

    private final Counter counter;

    /**
     *
     * @param counter Counter object
     */
    @Inject
    public CountController(Counter counter) {
       this.counter = counter;
    }

    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     * @return Result results the page
     */
    public Result count() {
        return ok(Integer.toString(counter.nextCount()));
    }

}
