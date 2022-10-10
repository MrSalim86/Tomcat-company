import com.sun.net.httpserver.HttpContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@WebServlet(name = "TilEmneServlet", value = "/TilEmneServlet")
public class TilEmneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("du tilføjer et emne nu");

        HttpSession session = request.getSession();

        Set<String> emneListe = (Set<String>) session.getAttribute("emneListe");

        if (emneListe == null) {  //det vil ske første jeg kommer her forbi

            System.out.println("liste på session scopet fandtes ikke så den oprettes");

            emneListe = new TreeSet<>();
        }

        Set<String> emneListeRe = (Set<String>) session.getAttribute("emneListeRe");

        if (emneListeRe == null) {  //det vil ske første jeg kommer her forbi

            System.out.println("liste på request scopet fandtes ikke så den oprettes");

            emneListeRe = new TreeSet<>();

        }

        ServletContext httpContext = getServletContext();
        // Object stringSetContext = httpContext.getAttribute("stringSetContext");
        Set<String> stringSetContext = (Set<String>) httpContext.getAttribute("stringSetContext");

        if (stringSetContext == null) {

            stringSetContext = new TreeSet<>();
        }


        String emne = request.getParameter("emne");

        Bruger bruger = (Bruger) session.getAttribute("bruger");

        System.out.println("hvad er brugeren sat til " + bruger.isActive());

        if (bruger.isActive() ) {
            stringSetContext.add(emne);
            emneListe.add(emne);      //session
            emneListeRe.add(emne);  //request
        }

        httpContext.setAttribute("stringSetContext", stringSetContext);
        request.setAttribute("emneListRe", emneListeRe);
        request.setAttribute("antal", emneListeRe.size());
        session.setAttribute("emneListe", emneListe);
        session.setAttribute("antal", emneListe.size());


        request.getRequestDispatcher("WEB-INF/Bruger side.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
