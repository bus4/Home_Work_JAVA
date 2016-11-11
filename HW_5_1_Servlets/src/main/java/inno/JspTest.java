package inno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Альберт on 09.11.2016.
 */
@WebServlet (urlPatterns = "/jsptest")
public class JspTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "new message";
        req.setAttribute("mes",message);
        req.getRequestDispatcher("/jsptest.jsp").forward(req,resp);
    }
}
