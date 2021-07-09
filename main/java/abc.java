import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
public class abc extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet GreetingServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome Ali "  + "Kesy ho  </h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();


    }



}