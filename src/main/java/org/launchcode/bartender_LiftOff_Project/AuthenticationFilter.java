package org.launchcode.bartender_LiftOff_Project;

import org.launchcode.bartender_LiftOff_Project.controllers.AuthenticationController;
import org.launchcode.bartender_LiftOff_Project.controllers.data.UserRepository;
import org.launchcode.bartender_LiftOff_Project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends HandlerInterceptorAdapter {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> whitelist = Arrays.asList("/login","/register","/logout","/cocktails", "/");

    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            //changed from path.startsWith to path.equals to restrict CRUD operations to logged in users
            if (path.equals(pathRoot)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean preHandle (HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {
        if (isWhitelisted(request.getRequestURI())) {
            // returning true indicates that the request may proceed
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {
            return true;
        }

        // The user is NOT logged in
        response.sendRedirect("/login");
        return false;
    }
}
