package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delete")
public class ServletDelete extends HttpServlet {

    Model model = Model.getInstance();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{

        StringBuffer sb = new StringBuffer();
        String line;

        try{
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }
        }catch (Exception e){
            System.out.println("Error");
        }

        JsonObject jsonObject = gson.fromJson(String.valueOf(sb), JsonObject.class);

        int id = jsonObject.get("id").getAsInt();

        model.delete(id);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson("Пользователь удален"));
        pw.print(gson.toJson(model.getFromList()));

    }

}
