<%-- 
    Document   : updateProduct
    Created on : Aug 16, 2022, 9:20:46 AM
    Author     : HP
--%>

<%@page import="model.Autopart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <h1>แก้ไขอะไหล่ของคุณ</h1>
        <%
            Autopart autopart = (Autopart) session.getAttribute("autopart");
        %>
        <form action="AddapartLab6">
            รหัสสินค้า:<input type="text" name="pid" value="<%= autopart.getPid()%>"><br/>
            ชื่อ: <input type="text" name="name" value="<%= autopart.getName()%>"><br/>
            ประเภท: <input type="text" name="type" value="<%= autopart.getType()%>"><br/>
            ราคา <input type="text" name="price" value="<%= autopart.getPrice()%>"><br/>
            <input type="submit" value="แก้ไข">
        </form>
        <% session.removeAttribute("autopart"); %>
    </body>
</html>
