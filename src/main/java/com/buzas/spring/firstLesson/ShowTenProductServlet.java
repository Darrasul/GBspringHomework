package com.buzas.spring.firstLesson;

import com.buzas.spring.firstLesson.items.NonSpringProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Т.к. в данном примере нет других страниц или действий, на данном этапе /showTen вынесено как название страницы в целом
// После добавления в web.xml будет обобщающие название, а здесь добавится ', urlPatterns = "/showTen" '
@WebServlet(name = "showTenProductServlet")
public class ShowTenProductServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ShowTenProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            int cost = (int) (Math.random() * 250);
            NonSpringProduct product;
            if (i != 6){
                product = new NonSpringProduct(i, "Продукт № " + (i + 1), cost);
            } else {
                product = new NonSpringProduct(i, "Продукт № " + (i + 1), "2 доллара");
            }
            resp.getWriter().printf("<h4> %d | %s | %s </h4>", product.getId(), product.getTitle(), product.getCost());
            resp.getWriter().printf("<h5/>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}
