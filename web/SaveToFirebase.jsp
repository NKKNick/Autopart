<%-- 
    Document   : SaveToFirebase
    Created on : Aug 16, 2022, 10:06:23 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Autopart" %>

<% Autopart autopart = (Autopart) session.getAttribute("autopart"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- The core Firebase JS SDK is always required and must be listed first -->
        <script src="https://www.gstatic.com/firebasejs/8.10.0/firebase-app.js"></script>
        <script src="https://www.gstatic.com/firebasejs/8.6.3/firebase-database.js"></script>

        <!-- TODO: Add SDKs for Firebase products that you want to use
             https://firebase.google.com/docs/web/setup#available-libraries -->

        <script>
            // Your web app's Firebase configuration
            const firebaseConfig = {
                apiKey: "AIzaSyBYdF5IkXjF2lvEjDtBeeqawkuA-RJfcGo",
                authDomain: "apartproject-3455b.firebaseapp.com",
                databaseURL: "https://apartproject-3455b-default-rtdb.firebaseio.com",
                projectId: "apartproject-3455b",
                storageBucket: "apartproject-3455b.appspot.com",
                messagingSenderId: "343329501362",
                appId: "1:343329501362:web:09f0d36c1feb6dcc0359ab"
            };
            // Initialize Firebase
            firebase.initializeApp(firebaseConfig);
        </script>        
    </head>
    <body>
        <h2>Test Firebase 'Movie' connection</h2>

        <p>
            <input type="button" value="Save" onclick="save_autopart();" />
        </p>

        <script>
            var databaseRef = firebase.database().ref('autopart');

            window.save_autopart = function() {
                var uid = firebase.database().ref().child('autopart').push().key;

                var data = {
                    autopart_id: uid,
                    autopart_pid: '<%=autopart.getPid()%>',
                    autopart_name: '<%= autopart.getName()%>',
                    autopart_type: '<%= autopart.getType()%>',
                    autopart_price: '<%= autopart.getPrice()%>'
                }

                var updates = {};
                updates['/apart/' + uid] = data;
                firebase.database().ref().update(updates);

                alert('Autopart is created successfully!');
                reload_page();
            }

            function reload_page() {
                window.location.reload();
            }

        </script>
    </body>
</html>
