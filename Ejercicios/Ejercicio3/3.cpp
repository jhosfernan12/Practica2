#include <iostream>
#include <string>

using namespace std;

class Nave 
{
private:
    string modelo;
    int capacidadCombustible;
    int consumoCombustiblePorHora;

public:
    Nave(string modelo, int capacidadCombustible, int consumoCombustiblePorHora) 
    {
        this->modelo = modelo;
        this->capacidadCombustible = capacidadCombustible;
        this->consumoCombustiblePorHora = consumoCombustiblePorHora;
    }

    int CombustibleRestante(int duracionVueloHoras) 
    {
        int combustibleNecesario = duracionVueloHoras * this->consumoCombustiblePorHora;
        int combustibleRestante = this->capacidadCombustible - combustibleNecesario;
        return combustibleRestante;
    }
};

class Mision 
{
private:
    string destino;
    int duracionHoras;
    int tripulacionNecesaria;

public:
    Mision(string destino, int duracionHoras, int tripulacionNecesaria) 
    {
        this->destino = destino;
        this->duracionHoras = duracionHoras;
        this->tripulacionNecesaria = tripulacionNecesaria;
    }

    void Simulacion(Nave nave) 
    {
        cout << "Simulando mision hacia " << this->destino << "..." << endl;
        if (nave.CombustibleRestante(this->duracionHoras) >= 0) 
        {
            cout << "La nave tiene suficiente combustible para llegar a " << this->destino << endl;
            cout << "Se necesitan " << this->tripulacionNecesaria << " tripulantes como minimo" << endl;
        } 
        else 
        {
            cout << "La nave no tiene suficiente combustible para llegar a " << this->destino << endl;
            cout << "!La misión ha fracasado!" << endl;
        }
    }
};

int main() 
{
    Nave nave1("Aurora", 10000, 1000);
    Mision mision1("Titan", 10, 5);
    Nave nave2("Sunbeam", 5000, 500);
    Mision mision2("Niese 581D", 10000, 200);

    mision2.Simulacion(nave2);
    mision1.Simulacion(nave1);

    return 0;
}
