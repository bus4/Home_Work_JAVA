package inno;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Альберт on 09.11.2016.
 */
public class HelloServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        System.out.println("servlet created");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("Hello from sevlet");
        //super.doGet(req, resp);
    }
}
