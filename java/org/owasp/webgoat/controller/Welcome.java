/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.owasp.webgoat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rlawson
 */
@Controller
public class Welcome {

    private static final String WELCOMED = "welcomed";

    @RequestMapping(value = "welcome.mvc", method = RequestMethod.GET)
    public ModelAndView welcome(HttpServletRequest request,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        // set the welcome attribute
        // this is so the attack servlet does not also 
        // send them to the welcome page
        HttpSession session = request.getSession();
        if (session.getAttribute(WELCOMED) == null) {
            session.setAttribute(WELCOMED, "true");
        }
        //@TODO put stuff here the welcome page needs to access
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome");

        return model;

    }
}
