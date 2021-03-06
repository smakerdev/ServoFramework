package test.controllers;

import org.servoframework.annotation.Route;
import org.servoframework.request.Request;
import org.servoframework.response.Response;
import test.models.Data;
import test.models.User;

import java.util.HashMap;

/**
 * Created by unidev on 2017. 7. 4..
 */

public class SubRouter {
    private static User user = new User();
    private static Data data = new Data();

    @Route(route="/sub", method = Route.RouteMethod.GET)
    public static void index(Request req, Response res) {
        res.setHeader("Content-Type", "text/html; charset=utf-8");
        user.init();

        String result = user.find(req.getParameter("name"));

        res.write(result);

        user.close();
        res.end();
    }

    @Route(route="/update", method = Route.RouteMethod.GET)
    public static void update(Request req, Response res) {
        res.setHeader("Content-Type", "text/html");
        user.init();

        user.update("name", "","");

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        
        res.json(map);

        user.close();
        res.end();
    }

    @Route(route="/count", method = Route.RouteMethod.GET)
    public static void count(Request req, Response res) {
        res.setHeader("Content-Type", "text/html");
        user.init();

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("result", user.count());
        res.json(map);

        user.close();
        res.end();
    }
}
