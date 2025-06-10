package core.server;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;

@Slf4j
public class ServerMain {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();
        server.setHandler(context);
        URL webAppDir = ServerMain.class.getClassLoader().getResource("META-INF/resources");
        assert webAppDir != null;
        context.setResourceBase(webAppDir.toURI().toString());
        context.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/target/classes/|.*\\.jar");
        server.start();
        log.info("Server started");
        server.join();
    }
}
