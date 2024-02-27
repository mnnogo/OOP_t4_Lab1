import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Format"})
public class FormatServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"ru\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Форматирование текста</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Выберите .txt файл для загрузки:</h2>");
        out.println("<form action=\"Format\" method=\"POST\" enctype=\"multipart/form-data\">");
        out.println("<input type=\"file\" name=\"file\" accept=\".txt\">");
        out.println("<input type=\"submit\" value=\"Обработать\" id=\"submit\">");
        out.println("</form>");
        out.println("<label>");
        out.println("Содержимое файла: <br>");
        out.println("<textarea name=\"textContent\" rows=\"10\" cols=\"50\"></textarea>");
        out.println("</label>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
