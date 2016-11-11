package inno.twitter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/twitter")
public class TweeterServlet extends HttpServlet {

    public static TweetService service;

    @Override
    public void init() throws ServletException {
        service = new TweetService();

        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tweet> tweets = service.getAll();
        req.setAttribute("tweets", tweets);
      //  req.setAttribute("comments", tweets);
  //      req.setAttribute("service", service);
        req.getRequestDispatcher("/tweets.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            String message = req.getParameter("message");
            if( message != null){service.add(message);}
            resp.sendRedirect("/twitter");
        }catch (Exception e){
            System.out.println("Ошибка при добавлении сообщения" + e);
        }
//
//        try {
//            String id = req.getParameter("id");
//            Long idL = Long.parseLong(id);
//            if( id != null){service.del(idL);}
//            resp.sendRedirect("/twitter");
//
//        }catch (Exception e){
//            System.out.println("Ошибка при удалении сообщения" + e);
//        }
//
//        try {
//            String comment = req.getParameter("comment");
//            String id = req.getParameter("comId");
//            Long idL = Long.parseLong(id);
//            if( comment != null){
//                service.addComment(idL, comment);
//                }
//            resp.sendRedirect("/twitter");
//        }catch (Exception e){
//            System.out.println("Ошибка при добавлении коммента" + e);
//        }



    }


}
