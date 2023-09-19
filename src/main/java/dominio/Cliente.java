/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *  This class is client domain. It's used as application customers
 * @author Toni
 */
public class Cliente {
    //Id Client
    private int idCliente;
    //User's name
    private String nombre;
    //User's last name
    private String apellido;
    //User's email
    private String email;
    //User's telephone number
    private String telefono;
    //User's balance
    private double saldo;

    /**
     * JavaBean Constructor
     */
    public Cliente() {
    }

    /**
     * Client constructor by his ID
     * @param idCliente 
     */
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Client constructor by some parameters
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     * @param saldo 
     */
    public Cliente(String nombre, String apellido, String email, String telefono, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    /**
     * Client conctructor by all his parameters
     * @param idCliente
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     * @param saldo 
     */
    public Cliente(int idCliente, String nombre, String apellido, String email, String telefono, double saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    /**
     * Return the ID of a client
     * @return: ID
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Set the ID of a client
     * @param idCliente 
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Return the name of a client
     * @return : name
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the name of a client
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Return the last name of a client
     * @return 
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Set the last name of a client
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Return the email of a client
     * @return: email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of a client
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the number telephone of a client
     * @return: number telephone
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Set the number telephone of a client
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Return the current balance of a client
     * @return: balance
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Set the balance of a client
     * @param saldo 
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * All information about this client
     * @return: id, name, last name, telephone number, email and balance
     */
    @Override
    public String toString() {
        return "Cliente: " + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", saldo=" + saldo + '}';
    }
    
    
}
