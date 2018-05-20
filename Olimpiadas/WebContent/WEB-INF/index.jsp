<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastrar Olimpiadas</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
        <!-- Barra superior com os menus de navegação -->
<c:import url ="Menu.jsp" />
        <!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="page-header">Cadastrar Olimpiadas</h3>
            <form action="ManterOlimpiadas.do" method="post">
            <div class="row">
                <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Ouro</label>
                    <input type="text" class="form-control" name="ouro" id="${olimpiada.ouro}" required maxlength="100" >
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="fone">Prata</label>
                    <input type="text" class="form-control" name="prata" id="${olimpiada.prata}" maxlength="15"  >
                </div>
              <div class="row">
                <div class="form-group col-md-6">
                    <label for="fone">Bronze</label>
                    <input type="text" class="form-control" name="bronze" id="${olimpiada.bronze}" maxlength="15"  >
                </div>
            
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="criar">Salvar</button>
                    <a href="index.html" class="btn btn-default">Cancelar</a>
         
        </div>
        </div>
      </div>
      </div>
        </form>
          </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>