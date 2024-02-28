import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/Format"})
@MultipartConfig
public class FormatServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Part filePart = request.getPart("file");

        // получить входной поток из части запроса
        InputStream fileContent = filePart.getInputStream();

        // прочитать содержимое файла в строку
        String fileContentAsString = new BufferedReader(new InputStreamReader(fileContent))
                .lines().collect(Collectors.joining("\n"));

        String result = getResultString(fileContentAsString);

        // создать страницу с результатом запроса
        fillHtmlCode(out, result);

        out.flush();
        out.close();
    }

    private String getResultString(String text)
    {
        // абзацы
        String[] paragraphs = text.split("\n");

        StringBuilder formattedText = new StringBuilder();
        for (String paragraph : paragraphs)
        {
            // добавление отступа в начало абзаца и убирание лищних пробелов
            paragraph = "   " + paragraph.trim();

            // ограничение длины строки до 80 символов
            int lineLength = 0;
            StringBuilder formattedParagraph = new StringBuilder();
            for (int i = 0; i < paragraph.length(); i++)
            {
                char ch = paragraph.charAt(i);

                if (lineLength == 80)
                {
                    formattedParagraph.append("\n");
                    lineLength = 0;
                }
                else
                {
                    // первый символ не пробел, кроме абзацных пробелов
                    if (!(lineLength == 0 && Character.isWhitespace(ch) && i > 2))
                    {
                        formattedParagraph.append(ch);
                        lineLength++;
                    }
                }
            }

            // добавление отформатированного абзаца к итоговому тексту
            formattedText.append(formattedParagraph).append("\n");
        }

        return formattedText.toString();
    }

    private void fillHtmlCode(PrintWriter out, String result)
    {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"ru\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Форматирование текста</title>");
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">\n");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<br><br><br><br>");
        out.println("<div class=\"container-fluid col-sm-6\" id=\"container\">");
        out.println("<div class=\"row justify-content-center\">");
        out.println("<div class=\"\">");
        out.println("<h2>Выберите .txt файл для загрузки:</h2>");
        out.println("<form action=\"Format\" method=\"POST\" enctype=\"multipart/form-data\">");
        out.println("<div class=\"input-group mb-3\">");
        out.println("<input type=\"file\" class=\"form-control mt-2\" name=\"file\" accept=\".txt\">");
        out.println("<button class=\"btn btn-primary mt-2\" type=\"submit\">Обработать</button>");
        out.println("</div>");
        out.println("</form>");
        out.println("<label for=\"text-content\">Результат:</label>");
        out.println("<textarea class=\"form-control\" id=\"text-content\" rows=\"20\" readonly>");
        out.println(result);
        out.println("</textarea>");
        out.println("<a class=\"btn btn-success mt-3\" id=\"download-btn\">Скачать</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("<script src=\"script.js\"></script>");
        out.println("</body>");
        out.println("</html>");
    }
}
