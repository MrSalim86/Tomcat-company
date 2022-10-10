import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

       request.getRequestDispatcher("WEB-INF/AdminSide.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String navn = request.getParameter("navn");

        Map<String, Bruger> contexBrugerMap =(Map<String, Bruger>) getServletContext().getAttribute("contexBrugerMap");

        if (!contexBrugerMap.containsKey(navn)) {

            String besked = navn + " findes ikke";
            System.out.println(besked);
            request.setAttribute("besked", besked);
            request.getRequestDispatcher("WEB-INF/AdminSide.jsp").forward(request,response);
        }

        contexBrugerMap.get(navn).setActive(false);

        String besked = navn + "er nu sat til inaktiv ";
        request.setAttribute("besked", besked);
        request.getRequestDispatcher("WEB-INF/AdminSide.jsp").forward(request,response);
    }
}
