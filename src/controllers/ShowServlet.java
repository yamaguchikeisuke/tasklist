package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasklist;
import utils.DBUtil;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ShowServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Tasklist m = em.find(Tasklist.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("tasklist", m);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasklists/show.jsp");
        rd.forward(request, response);
    }

}
