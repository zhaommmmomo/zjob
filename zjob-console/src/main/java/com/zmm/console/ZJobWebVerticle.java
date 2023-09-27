package com.zmm.console;

import io.vertx.core.*;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;

public class ZJobWebVerticle extends AbstractVerticle {

    private HttpServer server;
    private Router router;

    @Override
    public void init(Vertx vertx, Context context) {
        super.init(vertx, context);
        router = Router.router(vertx);
    }

    @Override
    public void start() throws Exception {
        HttpServerOptions options = new HttpServerOptions();
        server = vertx.createHttpServer(options);
        server.requestHandler(router).listen(8080).onComplete(new Handler<AsyncResult<HttpServer>>() {
            @Override
            public void handle(AsyncResult<HttpServer> event) {
                if (event.succeeded()) {

                } else {

                }
            }
        });
    }

    @Override
    public void stop() throws Exception {
        server.close();
    }
}
