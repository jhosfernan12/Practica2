#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Inventario 
{
private:
    vector<pair<string, int>> productosDisponibles;
    vector<string> productosAgotados;
    vector<vector<pair<string, int>>> listaFacturas;

public:
    void AgregarProducto(string producto, int cantidad) 
    {
        if (cantidad > 0) 
        {
            productosDisponibles.push_back(make_pair(producto, cantidad));
        } 
        else 
        {
            cout << "La cantidad debe ser mayor que 0" << endl;
        }
    }

    void RealizarPedido(vector<pair<string, int>> pedido) 
    {
        vector<pair<string, int>> factura;
        bool pedidoExitoso = true;
        vector<string> productosNoDisponibles;

        for (auto& item : pedido) 
        {
            string producto = item.first;
            int cantidad = item.second;

            bool encontrado = false;
            for (auto& disponible : productosDisponibles) 
            {
                if (disponible.first == producto) 
                {
                    encontrado = true;
                    if (disponible.second >= cantidad) 
                    {
                        disponible.second -= cantidad;
                        factura.push_back(make_pair(producto, cantidad));
                    } 
                    else 
                    {
                        cout << "No hay suficiente stock de " << producto << endl;
                        pedidoExitoso = false;
                    }
                    break;
                }
            }

            if (!encontrado) 
            {
                cout << "El producto " << producto << " no existe en el inventario =(" << endl;
                pedidoExitoso = false;
                productosNoDisponibles.push_back(producto);
            }
        }

        if (!pedidoExitoso && productosNoDisponibles.size() == pedido.size()) 
        {
            cout << "Pedido no realizado por falta de stock" << endl;
        }

        if (pedidoExitoso) 
        {
            listaFacturas.push_back(factura);
            cout << "Pedido realizado correctamente =)" << endl;
        }
    }

    void ActualizarAgotados() 
    {
        for (auto it = productosDisponibles.begin(); it != productosDisponibles.end();) 
        {
            if (it->second == 0) 
            {
                productosAgotados.push_back(it->first);
                it = productosDisponibles.erase(it);
            } 
            else 
            {
                ++it;
            }
        }

        for (auto& agotado : productosAgotados) 
        {
            cout << "El producto " << agotado << " se ha agotado." << endl;
        }
    }
};

int main() 
{
    Inventario inventario;
    inventario.AgregarProducto("InkaChips", 50);
    inventario.AgregarProducto("Doritos", 50);
    inventario.AgregarProducto("Gomitas", 30);

    vector<pair<string, int>> pedido = {{"InkaChips", 8}, {"Doritos", 6}, {"Gomitas", 4}, {"Helenas", 2}};
    inventario.RealizarPedido(pedido);
    inventario.ActualizarAgotados();

    return 0;
}
