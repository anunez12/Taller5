package edu.cuc.palabras;

import java.util.ArrayList;
import java.util.Objects;
import java.awt.Button; 
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author alexisdelahoz
 */
public class Palabra {
   
    private String palabra;
    private String significado;
    private ArrayList<Palabra> sinonimos = new ArrayList<>();

    public Palabra(String palabra) {
        this.palabra = palabra;
    }

    public Palabra(String palabra, String significado) {
        this.palabra = palabra;
        this.significado = significado;
    }

    public String getPalabra() {   
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.palabra);
        hash = 29 * hash + Objects.hashCode(this.significado);
        hash = 29 * hash + Objects.hashCode(this.sinonimos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Palabra other = (Palabra) obj;
        if (!Objects.equals(this.palabra, other.palabra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Palabra{" + "palabra=" + palabra + ", significado=" + significado + ", sinonimos=" + sinonimos + '}';
    }
    
    //Metodos de gestion de los sinonimos
    public void adicionarSinonimo(Palabra nuevaPalabra) {
        sinonimos.add(nuevaPalabra);
    }
    
    public boolean buscarSinonimo(Palabra nuevaPalabra) {
        return sinonimos.contains(nuevaPalabra);
    }
    
    public boolean eliminarSinonimo(Palabra nuevaPalabra) {
        return sinonimos.remove(nuevaPalabra);
    }
    
    //Metodos de la clase Palabra
    public double promedioLongitud() {
        double suma = 0;
        for (int i = 0; i < sinonimos.size(); i++) {
            Palabra actual = sinonimos.get(i);
            suma += actual.getPalabra().length();
        }
        return suma / sinonimos.size();
    }
    
    public Palabra sinonimoMayorLongitud() {
        Palabra mayor = sinonimos.get(0);
        for (int i = 0; i < sinonimos.size(); i++) {
            Palabra actual = sinonimos.get(i);
            if (actual.getPalabra().length() > mayor.getPalabra().length()) {
                mayor = actual;
            }
        }
        return mayor;
    }
    
    public ArrayList<Palabra> sinonimosInicianLetra(String letraInicial) {
        ArrayList<Palabra> listado = new ArrayList<>();
        for (int i = 0; i < sinonimos.size(); i++) {
            Palabra actual = sinonimos.get(i);
            if (actual.getPalabra().startsWith(letraInicial)) {
                listado.add(actual);
            }
        }
        return listado;
    }
    
    /**
     * Indica el número de sinonimos actuales de la palabra
     * @return la cantidad de sinonimos actuales
     */
    public int cantidadSinonimos() {
        return sinonimos.size();
    } 
    
     public static void habilitarBotones(JButton[] botones) {

        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);
        }
    }

    public static void deshabilitarBotones(JButton[] botones) {

        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);   
        }
    }
    
}
