import java.io.File;
import lotto.mvc.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class Application {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        String docBase = new File(".").getAbsolutePath();
        Context context = tomcat.addContext("", docBase);

        WebConfig.registerFilters(context);
        WebConfig.registerServlet(context);

        tomcat.start();
        tomcat.getServer().await();
    }

}
