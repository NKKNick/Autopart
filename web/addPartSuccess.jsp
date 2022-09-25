<%-- 
    Document   : addPSuccess
    Created on : Jul 12, 2022, 8:52:08 AM
    Author     : HP
--%>

<%@page import="model.Autopart"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>เพิ่มอะไหล่</h1> <!--Lab 6 เอาข้อมูลเพิ่มเข้าไปใน jsp --> 
        <%
            Autopart autopart = (Autopart) session.getAttribute("autopart");
        %>     
        รหัสสินค้า: <%= autopart.getPid() %><br/>
        ชื่อ: <%= autopart.getName() %><br/>
        ประเภท <%= autopart.getType() %><br/>
        ราคา <%= autopart.getPrice() %><br/>
        <a href="updateProduct.jsp">แก้ไข<br/></a>
        <a href='SaveToFirebase.jsp'>save firebase</a>
    </body>
</html>
