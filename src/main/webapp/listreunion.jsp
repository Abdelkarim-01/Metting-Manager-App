<%@page import="entities.Reuinion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style type="text/css">
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f8f8;
        }
    
        .maincontainer {
            margin: 20px auto;
            max-width: 900px;
        }
    
        #table_personne {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            border-radius: 8px;
            overflow: hidden;
        }
    
        #table_personne th, #table_personne td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
    
        #table_personne th {
            background-color: #256027;
            color: #fff;
        }
    
        #table_personne tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    
        #table_personne tr:hover {
            background-color: #ddd;
        }
    
        button {
            display: block;
            margin: 0 auto;
            color: #fff;
            border: 1px solid #34495e;
            background-color: #ffffff;
            border-radius: 6px;
            padding: 8px 12px;
            cursor: pointer;
           
            transition: background-color 0.3s ease-in-out, border-color 0.3s ease-in-out, color 0.3s ease-in-out;
        }
    button a{
        color: #fff;
    }
        .update-button {
            background-color: #256027;
        }
    
        .delete-button {
            background-color: #ff5555;
        }
    
        .consulter-button {
            background-color: #ffa500;
        }
    
        button:hover {
            background-color: transparent;
            border-color: #145e27;
        }
    
        .button-link {
            text-decoration: none;
        }
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #fff;
            height: 100%;
        }

        header {
            background-color: #256027;
            display: flex;
            justify-content: center;
            color: #fff;
            height:30px;
            padding: 10px 0;
            align-items: center;
        }

        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
        }

        nav li {
            
            padding: 0 30px;
        }

        nav a {
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            transition: color 0.2s ease-in-out;
        }

        nav a:hover {
            color: #ffd700;
        }

    </style>
</head>
<body>
    <header>
        <nav>
                <ul>
                    <li>
                        <a id="home" href="/ProjetReunion/AddPersonne">Home</a>
                    </li>                   
                     <li>
                        <a id="addP" href="/ProjetReunion/ConsulterPerson">Consulter Personne</a>
                    </li>
                    <li>
                        <a id="addR" href="/ProjetReunion/ConsulterReunion">Consulter Reuinion</a>
                    </li>

                </ul>
        </nav>
</header>
    <div class="maincontainer">
        <table id="table_personne">
            <tr>
                <th>ID</th>
                <th>TITRE</th>
                <th>DUREE</th>
                <th>DATE</th>
                <th>STATUS</th>
            </tr>
            <%
	            List<Reuinion> listreunion = (List<Reuinion>)request.getAttribute("listreunion");
	            for(Reuinion r :listreunion){
            %>
            <tr>
                <td><%=r.getIdReuinion()%></td>
                <td><%=r.getTitre() %></td>
                <td><%=r.getDurreeReuinion() %></td>
                <td><%=r.getDateReuinion() %></td>
                <td><button class="consulter-button"><a href='?idreunion=<%=r.getIdReuinion() %>' class='button-link'>MEMBRES</a></button></td>
            </tr>
            <%} %>
        </table>
    </div>
</body>
</html>
