package controller;

import model.News;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.NewsDAO;

/**
 *
 * @author Thaycacac
 */
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // get most and five recent article
            NewsDAO articles = new NewsDAO();
            News mostRecentArticle = articles.getRecentArticle(1).get(0);
            request.setAttribute("mostRecentNew", mostRecentArticle);
            request.setAttribute("newCurrent", mostRecentArticle);
            ArrayList<News> fiveRecentAticle = articles.getRecentArticle(5);
            request.setAttribute("fiveRecentNew", fiveRecentAticle);

        } catch (Exception ex) {
            
        }
    }

}
