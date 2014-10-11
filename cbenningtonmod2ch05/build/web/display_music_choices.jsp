<%-- 
    Document   : display_music_choices
    Created on : Feb 3, 2013, 12:05:42 AM
    Author     : Casey
--%>

<%@page import="org.omg.PortableInterceptor.USER_EXCEPTION"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Casey's Java Servlets and JSPs</title>
    </head>
    <body>
        <%@ page import="business.*, data.*" %>

        <%
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("emailAddress");
        %>

        <h1>Thanks for joining our email list, <%= firstName%> <%= lastName%>.</h1>

        <p>To make another entry, click on the Back <br>
            button in your browser or the Return button shown <br>
            below.</p>

        <form action="join_email_list.html" method="get">
            <input type="submit" value="Return">
        </form>

        <p>We'll use email to notify you whenever we have new releases for these types of music:
            <br>
            <%
                String[] music = request.getParameterValues("music");
                // returns the values of items selected in list box.
                for (int i = 0; i < music.length; i++) {
            %>
            <%= music[i]%>  <br>
            <%
                }
            %>
        </p>
    </body>
</html>