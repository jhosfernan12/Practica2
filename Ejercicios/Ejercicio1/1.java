package Ejercicios; 
import java.util.Random;

class Auto {
    private String nombre;
    private int distanciaRecorrida;

    public Auto(String nombre) 
    {
        this.nombre = nombre;
        distanciaRecorrida = 0;
    }

    public void avanzar() {
        Random rd = new Random();
        int distanciaAvance = rd.nextInt(6) + 1;
        distanciaRecorrida += distanciaAvance;
    }

    public int obtenerDistanciaRecorrida() 
    {
        return distanciaRecorrida;
    }
}

class Carrera {
    private int distanciaTotal;

    public Carrera(int distanciaTotal) 
    {
        this.distanciaTotal = distanciaTotal;
    }

    public String empezarCarrera() {
        Auto jugador = new Auto("Tu");
        Auto computadora = new Auto("PC");

        while (jugador.obtenerDistanciaRecorrida() < distanciaTotal && computadora.obtenerDistanciaRecorrida() < distanciaTotal) {
            jugador.avanzar();
            computadora.avanzar();
        }

        if (jugador.obtenerDistanciaRecorrida() >= distanciaTotal && computadora.obtenerDistanciaRecorrida() >= distanciaTotal) {
            return "! EMPATE !";
        } else if (jugador.obtenerDistanciaRecorrida() >= distanciaTotal) {
            return "GANASTE CAPO !!";
        } else {
            return "PERDISTE =(";
        }
    }
}

public class Main 
{
    public static void main(String[] args) {
        Carrera carrera = new Carrera(100);
        String resultado = carrera.empezarCarrera();
        System.out.println(resultado);
    }
}
