/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseLibro;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 9/07/2021
 *
 */
public class Libro {

    private static int idSiguiente = 1;

    private String nombre;
    private String autor;
    private String isbn;
    private int cantidad;
    private int id;

    public Libro(String nombre, String autor, int cantidad) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = generarISBN();
        this.cantidad = cantidad;
        this.id = idSiguiente++;
    }

    //Metodo que nos generara el ISBN
    private String generarISBN() {
        String cadena = "";
        int n = 0;
         char a;
        for (int i = 0; i < 10; i++) {
            n = (int) Math.floor(Math.random() * (2 - 1 + 1)) + 1;
            if (n == 1) {//MAYUSCULAS
                n = (int) Math.floor(Math.random() * (90 - 65 + 1)) + 65;
                a=(char)n;
                cadena += a;
            } else {
                n = (int) Math.floor(Math.random() * (57 - 48 + 1)) + 48;
                 a=(char)n;
                cadena += a;
            }
        }

        return cadena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNombre: " + nombre + "\nAutor: " + autor + "\nISBN: " + isbn + "\nCantidad: " + cantidad;
    }

}
