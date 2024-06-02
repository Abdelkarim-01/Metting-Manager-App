<%@page import="entities.Personne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>
    
    <style type="text/css">
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

        .container{
            margin-top:40px ;
            display: flex;
            justify-content: space-around;
            align-items:center ;
            height: 100%;
        }
        .addPerson , .addReunion{
            width: 100%;
            max-width: 400px; 
            height: 100%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
        }

        #titlePer {
            text-align: center;
            color: #333;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            background-color: #256027;
            color: #fff;
            padding: 10px 15px;
            width: 150px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        button:hover {
            background-color: #1c4e22;
        }
        #buttonP,#buttonR{
            display: flex;
            justify-content: center;
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
    <div class="container">
        <div class="addPerson">
            <h2 id="titlePer">Ajouter Personne</h2>
            <%
            	Personne p=(Personne)request.getAttribute("personupdate");
            if(p==null){%>
            <form action="/ProjetReunion/AddPersonne" method="get">
                <label for="nomperson">Nom</label>
                <input id="nomperson" type="text" name="nomPersonne" >
                <br>
                <label for="age">Age</label>
                <input id="age" type="number" name="age" >
                <br>
                <label for="email">Email</label>
                <input id="email" type="email" name="email" >
                <br>
                <div id="buttonP">
                    <button id="AddPerson" type="submit">Ajouter</button>
                </div>
            </form>
            <%} else { %>
                <form action="/ProjetReunion/AddPersonne" method="get">
                <label for="nomperson">Nom</label>
                <input id="nomperson" type="text" name="nomPersonne" value="<%=p.getNomPersonne()%>">
                <br>
                <label for="age">Age</label>
                <input id="age" type="number" name="age" value="<%=p.getAge()%>">
                <br>
                <label for="email">Email</label>
                <input id="email" type="email" name="email" value="<%=p.getEmail()%>">
                <br>
                <input id="date" type="hidden" name="idperson" value="<%=p.getIdPersonne()%>">
                <div id="buttonP">
                    <button id="AddPerson" type="submit">Ajouter</button>
                </div>
            </form>
            <%} %>
        </div>
        <div class="addReunion">
            <h2 id="titlePer">Ajouter Reunion</h2>
            <form action="/ProjetReunion/AddPersonne" method="get">
                <label for="titre">Titre</label>
                <input id="titre" type="text" name="titre" >
                <br>
                <label for="Durer">Duree</label>
                <input id="Durer" type="number" name="duree">
                <br>
                <label for="date">Date</label>
                <input id="date" type="date" name="date" >
                <br>
                <div id="buttonR">
                    <button id="AddReunion" type="submit">Ajouter</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
