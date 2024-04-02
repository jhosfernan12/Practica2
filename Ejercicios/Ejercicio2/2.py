class Inventario:
    def __init__(self):
        self.productosDisponibles = {}
        self.productosAgotados = {}
        self.listaFacturas = []

    def AgregarProducto(self, producto, cantidad):
        if cantidad > 0:
            self.productosDisponibles[producto] = cantidad
        else:
            print("La cantidad debe ser mayor que 0")

    def RealizarPedido(self, pedido):
        factura = {}
        pedidoExitoso = True  
        productosNoDisponibles = []

        for producto, cantidad in pedido.items():
            if producto in self.productosDisponibles:
                if self.productosDisponibles[producto] >= cantidad:
                    self.productosDisponibles[producto] -= cantidad
                    factura[producto] = cantidad
                else:
                    print(f"No hay suficiente stock de {producto}")
                    pedidoExitoso = False  
            else:
                print(f"El producto {producto} no existe en el inventario")
                pedidoExitoso = False  
                productosNoDisponibles.append(producto)

        if not pedidoExitoso and len(productosNoDisponibles) == len(pedido):
            print("Pedido no realizado por falta de stock")

        if pedidoExitoso:
            self.listaFacturas.append(factura)
            print("Pedido realizado correctamente =)")

    def ActualizarAgotados(self):
        for producto, cantidad in self.productosDisponibles.items():
            if cantidad == 0:
                self.productosAgotados[producto] = 0
                del self.productosDisponibles[producto]
                print(f"El producto {producto} se a agotado")


inventario = Inventario()
inventario.AgregarProducto("InkaChips", 50)
inventario.AgregarProducto("Doritos", 50)
inventario.AgregarProducto("Gomitas", 30)

pedido = {"InkaChips": 8, "Doritos": 6, "Gomitas": 4}
inventario.RealizarPedido(pedido)
inventario.ActualizarAgotados()
