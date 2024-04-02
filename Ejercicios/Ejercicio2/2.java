import java.util.ArrayList;
import java.util.List;

class Inventario 
{
    private List<Pair<String, Integer>> productosDisponibles;
    private List<String> productosAgotados;
    private List<List<Pair<String, Integer>>> listaFacturas;

    public Inventario() 
    {
        productosDisponibles = new ArrayList<>();
        productosAgotados = new ArrayList<>();
        listaFacturas = new ArrayList<>();
    }

    public void AgregarProducto(String producto, int cantidad) 
    {
        if (cantidad > 0) 
        {
            productosDisponibles.add(new Pair<>(producto, cantidad));
        } 
        else 
        {
            System.out.println("La cantidad debe ser mayor que 0");
        }
    }

    public void RealizarPedido(List<Pair<String, Integer>> pedido) 
    {
        List<Pair<String, Integer>> factura = new ArrayList<>();
        boolean pedidoExitoso = true;
        List<String> productosNoDisponibles = new ArrayList<>();

        for (Pair<String, Integer> item : pedido) 
        {
            String producto = item.getKey();
            int cantidad = item.getValue();

            boolean encontrado = false;
            for (Pair<String, Integer> disponible : productosDisponibles) 
            {
                if (disponible.getKey().equals(producto)) 
                {
                    encontrado = true;
                    if (disponible.getValue() >= cantidad) 
                    {
                        disponible.setValue(disponible.getValue() - cantidad);
                        factura.add(new Pair<>(producto, cantidad));
                    } else {
                        System.out.println("No hay suficiente stock de " + producto);
                        pedidoExitoso = false;
                    }
                    break;
                }
            }

            if (!encontrado) 
            {
                System.out.println("El producto " + producto + " no existe en el inventario =(");
                pedidoExitoso = false;
                productosNoDisponibles.add(producto);
            }
        }

        if (!pedidoExitoso && productosNoDisponibles.size() == pedido.size()) 
        {
            System.out.println("Pedido no realizado por falta de stock");
        }

        if (pedidoExitoso) {
            listaFacturas.add(factura);
            System.out.println("Pedido realizado correctamente =)");
        }
    }

    public void ActualizarAgotados()
     {
        for (int i = 0; i < productosDisponibles.size(); i++) 
        {
            Pair<String, Integer> disponible = productosDisponibles.get(i);
            if (disponible.getValue() == 0) {
                productosAgotados.add(disponible.getKey());
                productosDisponibles.remove(i);
                i--;
            }
        }

        for (String agotado : productosAgotados) 
        {
            System.out.println("El producto " + agotado + " se ha agotado.");
        }
    }
    public static void main(String[] args) 
    {
        Inventario inventario = new Inventario();
        inventario.AgregarProducto("InkaChips", 50);
        inventario.AgregarProducto("Doritos", 50);
        inventario.AgregarProducto("Gomitas", 30);
        inventario.AgregarProducto("Helenas", 45);

        List<Pair<String, Integer>> pedido = new ArrayList<>();
        pedido.add(new Pair<>("InkaChips", 8));
        pedido.add(new Pair<>("Doritos", 6));
        pedido.add(new Pair<>("Gomitas", 4));
        pedido.add(new Pair<>("Helenas", 2));
        pedido.add(new Pair<>("Galletas", 1));
        inventario.RealizarPedido(pedido);
        inventario.ActualizarAgotados();
    }

    static class Pair<K, V> 
    {
        private K key;
        private V value;

        public Pair(K key, V value) 
        {
            this.key = key;
            this.value = value;
        }

        public K getKey() 
        {
            return key;
        }

        public void setKey(K key) 
        {
            this.key = key;
        }

        public V getValue() 
        {
            return value;
        }

        public void setValue(V value) 
        {
            this.value = value;
        }
    }
}
