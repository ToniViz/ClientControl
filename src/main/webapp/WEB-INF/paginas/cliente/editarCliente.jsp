<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/cd32717c70.js" crossorigin="anonymous"></script>
        <title>Editar clientes</title>
    </head>
    <body>

        <!-- Header -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"></jsp:include>

            <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}"
              method="POST" class="was-validated">

            <!-- Navigation buttons -->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"></jsp:include>   
                <section id="details">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <div class="card-header"> 
                                        <h4>Editar Cliente</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label for="nombre">Nombre</label> 
                                            <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="apellido">Apellido</label> 
                                            <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email</label> 
                                            <input type="email" class="form-control" name="email" required value="${cliente.email}"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="telefono">Telefono</label> 
                                            <input type="tel" class="form-control" name="telefono" required value="${cliente.telefono}"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="saldo">Saldo</label> 
                                            <input type="number" step="any" class="form-control" name="saldo" required value="${cliente.saldo}"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </form>
            <!-- Footer -->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"></jsp:include>




        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    </body>
</html>
