package inno.twitter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/twitter/del")
public class TweeterServletDel extends TweeterServlet {

  //  private TweetService service;

    @Override
    public void init() throws ServletException {
   //     service = new TweetService();
    //    super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        List<Tweet> tweets = service.getAll();
//        req.setAttribute("tweets", tweets);
//       req.getRequestDispatcher("/tweets.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

//        try {
 //       req.getServletContext();
            String id = req.getParameter("id");
            Long idL = Long.parseLong(id);
            //TweetService service = ;.getAttribute("sr");
            if( id != null){service.del(idL);}
            resp.sendRedirect("/twitter");
//
//        }catch (Exception e){
//            System.out.println("Ошибка при удалении сообщения" + e);
//        }

    }


}
