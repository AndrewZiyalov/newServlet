package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calc")
public class ServletCalculate extends HttpServlet {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer sb = new StringBuffer();
        String line;
        response.setContentType("application/json;charset=utf-8");

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                sb.append(line);
        } catch (Exception e) {
            System.out.println("Error");
        }
        JsonObject jobj = gson.fromJson(String.valueOf(sb), JsonObject.class);

        Double a = jobj.get("a").getAsDouble();
        Double b = jobj.get("b").getAsDouble();
        String math = jobj.get("math").getAsString();

        PrintWriter pw = response.getWriter();

        if (math.contains("+")){
            Double result = a+b;
            pw.print(new Gson().fromJson("{\"result\":" + result.toString() + "}", JsonObject.class));
        }
        if (math.contains("-")){
            Double result = a-b;
            pw.print(new Gson().fromJson("{\"result\":" + result.toString() + "}", JsonObject.class));
        }
        if (math.contains("*")){
            Double result = a*b;
            pw.print(new Gson().fromJson("{\"result\":" + result.toString() + "}", JsonObject.class));
        }
        if (math.contains("/")){
            Double result = a/b;
            pw.print(new Gson().fromJson("{\"result\":" + result.toString() + "}", JsonObject.class));
        }


    }


}
