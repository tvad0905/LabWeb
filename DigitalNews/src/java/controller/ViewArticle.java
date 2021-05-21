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
public class ViewArticle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            NewsDAO articleDao = new NewsDAO();
            // get most recent article
            News mostRecentArticle = articleDao.getRecentArticle(1).get(0);
            request.setAttribute("mostRecentNew", mostRecentArticle);
            ArrayList<News> fiveRecentAticle = articleDao.getRecentArticle(5);
            request.setAttribute("fiveRecentNew", fiveRecentAticle);

            News article = articleDao.getArticleById(id);
            // check article exist or not
            if (article == null) {
                request.setAttribute("error", "Not found new");
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            } else {
                request.setAttribute("newCurrent", article);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            
        }
    }

}
