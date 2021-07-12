/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import claseLibro.Libro;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 9/07/2021
 *
 */
public class Biblioteca {

    private Libro[][] matriz;
    private int contador;
    private ArrayList<Libro> listaPrestados;

    //Constructorres 
    public Biblioteca(int fila, int columna) {
        matriz = new Libro[fila][columna];
        listaPrestados = new ArrayList<Libro>();
        contador = -1;
    }

    public Biblioteca() {
        matriz = new Libro[3][3];
        listaPrestados = new ArrayList<Libro>();
        contador = -1;
    }

    //Metodo para rellenar un objeto Libro
    public Libro rellenarLibro() {
        Libro l;
        String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del libro", "Introduciendo nombre del libro", 1);
        String autor = JOptionPane.showInputDialog(null, "Introduce el Autor del libro", "Introduciendo Autor", 1);
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce cuantos libros hay de este tipo en la Biblioteca", "Introduce la cantidad", 1));
        l = new Libro(nombre, autor, cantidad);
        return l;
    }

    //Metodo para registrar un libro en la biblioteca
    public void registrarLibro(Libro l) {
        boolean encontrado = false;
        for (int i = 0; i < matriz.length && !encontrado; i++) {
            for (int j = 0; j < matriz[0].length && !encontrado; j++) {
                if (matriz[i][j] == null) {
                    matriz[i][j] = l;
                    contador++;
                    JOptionPane.showMessageDialog(null, "Libro Registrado correctamente", "Libro Registrado", 1);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Error al registrar el libro", "Error al Registrar", 2);
        }
    }

    //Metodo para elimiar un libro por ID
    public void eliminarLibro(int id) {
        boolean encontrado = false;
        for (int i = 0; i < matriz.length && !encontrado; i++) {
            for (int j = 0; j < matriz[0].length && !encontrado; j++) {
                if (matriz[i][j] != null && matriz[i][j].getId() == id) {
                    contador--;
                    JOptionPane.showMessageDialog(null, "Libro Dado de Baja: \n" + matriz[i][j].getNombre(), "Libro Dado de Baja", 1);
                    matriz[i][j] = null;
                    encontrado = true;

                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja el libro\n1.-Verifique que introducio el ID correcto", "Error al Registrar", 2);
        }
    }

    //Metodo para buscar un libro en especifico en la biblioteca
    public void buscarLibro(int id) {
        boolean encontrado = false;
        for (int i = 0; i < matriz.length && !encontrado; i++) {
            for (int j = 0; j < matriz[0].length && !encontrado; j++) {
                if (matriz[i][j] != null && matriz[i][j].getId() == id) {
                    JOptionPane.showMessageDialog(null, "Resultado de la busqueda : \n" + matriz[i][j], "Resultados Busqueda", 1);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun libro con el ID\n1.-Verifique que introducio el ID correcto", "Error al buscar", 2);
        }
    }

    //Metodo para mostrar los datos de todos los libros en la biblioteca
    public void mostrarLibrosBiblioteca() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    System.out.println("Fila: " + i + " Columna: " + j);
                    System.out.println(matriz[i][j]);
                }
            }
        }
    }

    //Metodo para prestar un libro
    public void prestarLibro(int id) {

        boolean encontrado = false;
        for (int i = 0; i < matriz.length && !encontrado; i++) {
            for (int j = 0; j < matriz[0].length && !encontrado; j++) {
                if (matriz[i][j] != null && matriz[i][j].getId() == id && matriz[i][j].getCantidad() > 0) {
                    listaPrestados.add(matriz[i][j]);
                    matriz[i][j].setCantidad(matriz[i][j].getCantidad() - 1);
                    JOptionPane.showMessageDialog(null, "El libro:\n" + matriz[i][j].getNombre() + " fue prestado", "Libro Prestado", 1);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun libro con el ID\n1.-Verifique que introducio el ID correcto", "Error al buscar", 2);
        }
    }

    //Metodo para mostrar libros prestados
    public void mostrarLibrosPrestados() {
        for (Libro i : listaPrestados) {
            System.out.println("ID: " + i.getId() + "\nLibro: " + i.getNombre());
        }
    }

    //Metodo para reponer un libro
    public void reponerLibro(int id) {
        boolean encontrado = false;
        for (int i = 0; i < matriz.length && !encontrado; i++) {
            for (int j = 0; j < matriz[0].length && !encontrado; j++) {
                if (matriz[i][j] != null && matriz[i][j].getId() == id) {
                    matriz[i][j].setCantidad(matriz[i][j].getCantidad() + 1);
                    JOptionPane.showMessageDialog(null, "El libro " + matriz[i][j].getNombre() + " fue agregado en la biblioteca"
                            + "\nCantidad: " + matriz[i][j].getCantidad(), "Agregado", 1);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun libro con el ID\n1.-Verifique que introducio el ID correcto", "Error al buscar", 2);
        }
    }

    //Metodo para verificar si la lista esta vacia 
    public boolean noEstaVacia() {
        return (contador != -1);
    }

    //Metodo para verificar si la lista tiene espacios 
    public boolean tieneEspacios() {
        return (contador != matriz.length);
    }

}
