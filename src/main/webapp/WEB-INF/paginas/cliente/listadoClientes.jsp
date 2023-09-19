<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_UE"/>
<!-- List of clients -->
<section id="clientes">
    <div class="container">  
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Saldo</th>
                                <th></th>
                            </tr>

                        </thead>
                        <tbody>
                           
                            <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                <tr>
                                    
                                    <td>${status.count}</td>
                                    <td>${cliente.nombre} ${cliente.apellido}</td>
                                    <td><f:formatNumber value= "${cliente.saldo}" type="currency"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
            <!-- Start of cards -->
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <f:formatNumber value="${saldoTotal}" type="currency"/>
                        </h4>

                    </div>
                </div>
                <div class="card text-center" bg-success text-white mb-3>
                    <div class="card-body">
                        <h3>Total Clientes</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalClientes} 
                        </h4>
                    </div> 

                </div>

            </div>

        </div>
        <!-- End of cards -->

    </div>
</div>

</section>

<!<!-- Add modal client -->

<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>