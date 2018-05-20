<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Olimpiadas</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Cadastro</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.html">Olimpiadas</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Alterar Olimpiadas</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="ManterOlimpiadas.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="ouro">Ouro</label>
                    <input type="text" class="form-control" name="ouro" id="ouro" value="${olimpiada.ouro}" required maxlength="100" >
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="prata">Prata</label>
                    <input type="text" class="form-control" name="prata" id="prata" value="${olimpiada.prata}" maxlength="15" >
                </div>

                <div class="form-group col-md-6">
                    <label for="bronze">Bronze</label>
                    <input type="text" class="form-control" name="bronze" id="bronze" value="${olimpiada.bronze}" required maxlength="60" >
                </div>
                <div>
                <input type="hidden" class="form-control" name="ano" id="ano" value="${ano.ano}">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="Alterar">Salvar</button>
                    <a href="index.html" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</head>

</html>