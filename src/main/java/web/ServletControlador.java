/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class is a Servlet Controller of the application
 * @author Toni
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    /**
     * Contains the logic for Do Get services. Redirects to appropriate methods
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
                    break;
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    /**
     * Default acción of the app: List all clients and theirs balances
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("Clientes =" + clientes);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", calcularSaldoTotal(clientes));
       
        response.sendRedirect("clientes.jsp");
    }

    /**
     * Calculate the total balance of all clients
     * @param clientes
     * @return: total balance
     */
    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }

    /**
     * Select a client by his ID
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       
        String parametro = request.getParameter("idCliente");
        int idCliente = Integer.parseInt(parametro);
        ClienteDaoJDBC edCliente = new ClienteDaoJDBC();
        Cliente cliente = edCliente.buscar(idCliente);
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    /**
     * Contains the logic for Do Post services. Redirects to appropriate methods
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
                    break;
                
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
   /**
    * Modify a client with the form data and update his information in the database
    * @param request
    * @param response
    * @throws IOException
    * @throws ServletException 
    */ 
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String parametro = request.getParameter("idCliente");
        int idCliente = Integer.parseInt(parametro);
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null) {
            saldo = Double.parseDouble(saldoString);
        }

        
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

        
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

       
        this.accionDefault(request, response);
    }
    
    /**
     * Delete a client from the database
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String parametro = request.getParameter("idCliente");
        int idCliente = Integer.parseInt(parametro);
        

       
        Cliente cliente = new Cliente(idCliente);

        
        int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

       
        this.accionDefault(request, response);
    }

    /**
     * Insert a client with his information in the database
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null) {
            saldo = Double.parseDouble(saldoString);
        }

        
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);

       
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

       
        this.accionDefault(request, response);
    }
}
