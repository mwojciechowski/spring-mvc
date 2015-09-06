package pl.adalberti.edu.spring.mvc;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Mike on 2015-09-06.
 */
@Service
@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)

public class RequestHandlerImpl implements RequestHandler {
    public void handleRequest() {
        Object obj = new Object();
    }
}
