package email;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Casey
 */
public class DisplayMusicChoicesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Casey's Java Servlets and JSPs</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Thanks for joining our email list, "+firstName+" "+lastName+".</h1>\n");
            out.println("<p>To enter another email address, click on the Back <br>\n");
            out.println("button in your browser or the Return button shown <br>\n");
            out.println("below.</p>\n");
            out.println("<form action=\"join_email_list.html\" ");
            out.println("method=\"post\">\n");
            out.println("<input type=\"submit\" value=\"Return\">\n");
            out.println("</form>\n");
            out.println("<p>We'll use email to notify you whenever we have new releases for these types of music:<br>\n");

            String[] music = request.getParameterValues("music");
            // returns the values of items selected in list box.
            for (int i = 0; i < music.length; i++) {
            out.println(music[i]+"<br>\n");
            }
            out.println("</p>\n");
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}