/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jacartavisa.business;

/**
 *
 * @author mechack-kasongo
 */

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/pages/*")
public class SessionControlFilter implements Filter {
   
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialisation du filtre
    }

    public void doFilter(ServletRequest request, 
            ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Vérifier si l'utilisateur est connecté en vérifiant la présence de l'attribut de session "email"
        String email= (String) httpRequest.getSession().getAttribute("user");
       
        if (email == null) {
            // L'utilisateur n'est pas connecté, rediriger vers la page de connexion
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.xhtml");
        } else {
            // L'utilisateur est connecté, laisser la requête continuer
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        // Nettoyage du filtre
    }
}
