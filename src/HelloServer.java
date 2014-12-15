
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
 
public class HelloServer
{
    
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.addServlet("MyServlet", "/*");
        server.setHandler(handler);
 
        server.start();
        server.join();
    }
}
