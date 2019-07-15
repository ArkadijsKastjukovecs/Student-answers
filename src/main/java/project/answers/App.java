package project.answers;

import java.util.HashMap;
import java.util.Map;

import javax.mvc.security.Csrf;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("app")
public class App extends Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(Csrf.CSRF_PROTECTION, Csrf.CsrfOptions.EXPLICIT);
        return props;
    }
    
}
