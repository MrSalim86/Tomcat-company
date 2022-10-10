

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {


    Map<String, Bruger> brugerMap = new TreeMap<>();

    public void init()
    {
        //ServletContext servletContext = getServletContext();

        Map<String, Bruger> contexBrugerMap = new TreeMap<>();

        Bruger bruger1 = new Bruger("Mohamed", "1");
        Bruger bruger2 = new Bruger("Ali", "1");

        contexBrugerMap.put(bruger1.getNavn(),bruger1);
        contexBrugerMap.put(bruger1.getNavn(),bruger2);

        getServletContext().setAttribute("contexBrugerMap",contexBrugerMap);



    }

    private void inset(Bruger bruger) {

        brugerMap.put(bruger.getNavn(), bruger);
    }

    private void udskriv() {

        for (Map.Entry<String, Bruger> entry : brugerMap.entrySet()) {

            System.out.println(entry.toString());
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //   System.out.println("du ramte login serletten via Get");

        String loginbesked = "";


        String navn = request.getParameter("navn");
        String kode = request.getParameter("kode");

        Map<String, Bruger> contexBrugerMap = (Map<String, Bruger>) getServletContext().getAttribute("contexBrugerMap");

        if (!contexBrugerMap.containsKey(navn)) {


            loginbesked = "bruger med det navn findes ikke, prøv igen går til opret";

            request.setAttribute("loginbesked", loginbesked);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

        if (!contexBrugerMap.get(navn).getKode().equals(kode)) {

            loginbesked = "Koden er forkert, prøv igen";

            request.setAttribute("loginbesked", loginbesked);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        // alt er gået fint

        HttpSession session = request.getSession();

       // contexBrugerMap.get(navn).setActive(false);
        session.setAttribute("bruger", contexBrugerMap.get(navn));
        session.setAttribute("sessionId", session.getId());
        request.getRequestDispatcher("WEB-INF/Bruger side.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, Bruger> contexBrugerMap = (Map<String, Bruger>) getServletContext().getAttribute("contexBrugerMap");


        System.out.println("du ramte login serletten via Post");


        String opretNavn = request.getParameter("OpretNavn");
        String kode1 = request.getParameter("kode1");
        String kode2 = request.getParameter("kode2");

        String besked = "";

        if (opretNavn.equals("") || kode1.equals("") || kode2.equals("")) {
            besked = "huske alle felter skal udfyldes";

            System.out.println("opret bruger ikke udfyldt korrekt");
            // log("opret bruger ikke udfyldt korrekt");

            request.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        if (!kode1.equals(kode2)) {

            besked = "den angivende koder er forskellige, prøv igen";

            request.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }


        if (contexBrugerMap.containsKey(opretNavn)) {

            besked = "en bruger med det navn findes allerede, prøv igen";
            request.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }


        Bruger bruger = new Bruger(opretNavn, kode1);

        contexBrugerMap.put(bruger.getNavn(), bruger);

        getServletContext().setAttribute("contexBrugerMap",contexBrugerMap);

        HttpSession session = request.getSession();

        session.setAttribute("sessionId", session.getId());
        session.setAttribute("bruger", bruger);

        request.getRequestDispatcher("WEB-INF/Bruger side.jsp").forward(request, response);


    }
}
