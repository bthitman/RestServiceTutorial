package core.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/time.html")
public class UnixTimeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long unixTimeInSeconds = System.currentTimeMillis() / 1000L;

        response.setContentType("text/html");
        response.getWriter().println("<h1>Unix Time</h1>");
        response.getWriter().println("<p>Current Unix Time: " + unixTimeInSeconds + "</p>");
        response.getWriter().println("<p>(<a href=\"\">Refresh</a>)</p>");
    }
}
