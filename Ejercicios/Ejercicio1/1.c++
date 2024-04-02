#include <iostream>
#include <random>
#include <string>

using namespace std;

class Auto 
{
private:
    string nombre;
    int distanciaRecorrida;

public:
    Auto(string nombre) 
    {
        this->nombre = nombre;
        distanciaRecorrida = 0;
    }
    void avanzar() 
    {
        random_device rd;
        mt19937 gen(rd());
        uniform_int_distribution<int> dis(1, 6);
        int distanciaAvance = dis(gen);
        distanciaRecorrida += distanciaAvance;
    }

    int obtenerDistanciaRecorrida() 
    {
        return distanciaRecorrida;
    }
};

class Carrera 
{
private:
    int distanciaTotal;

public:
   Carrera(int distanciaTotal) 
    {
        this->distanciaTotal = distanciaTotal;
    }


    string empezarCarrera() 
    {
        Auto jugador("Tu"); //Se crean aqui los objetos porque la clase utiliza las instancias
        Auto computadora("PC");

        while (jugador.obtenerDistanciaRecorrida() < distanciaTotal && computadora.obtenerDistanciaRecorrida() < distanciaTotal) 
        {
            jugador.avanzar();
            computadora.avanzar();
        }

        if (jugador.obtenerDistanciaRecorrida() >= distanciaTotal && computadora.obtenerDistanciaRecorrida() >= distanciaTotal) 
        {
            return "! EMPATE !";
        } 
        else if (jugador.obtenerDistanciaRecorrida() >= distanciaTotal) 
        {
            return "GANASTE CAPO !!";
        } 
        else 
        {
            return "PERDISTE =(";
        }
    }
};

int main() 
{

    Carrera carrera(100);
    string resultado = carrera.empezarCarrera();
    cout << resultado << endl;
    return 0;
}
