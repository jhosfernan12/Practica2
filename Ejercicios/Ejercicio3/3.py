class Nave:
    def __init__(self, modelo, capacidadCombustible, consumoCombustiblexhora):
        self.modelo = modelo
        self.capacidadCombustible = capacidadCombustible
        self.consumoCombustiblexhora = consumoCombustiblexhora

    def CombustibleRestante(self, duracionVueloHoras):
        combustibleNecesario = duracionVueloHoras * self.consumoCombustiblexhora
        combustibleRestante = self.capacidadCombustible - combustibleNecesario
        return combustibleRestante

class Mision:
    def __init__(self, destino, duracionHoras, tripulacionNecesaria):
        self.destino = destino
        self.duracionHoras = duracionHoras
        self.tripulacionNecesaria = tripulacionNecesaria

    def Simulacion(self, nave):
        print(f"Simulando mision hacia {self.destino}...")
        if nave.CombustibleRestante(self.duracionHoras) >= 0:
            print(f"La nave tiene suficiente combustible para llegar a {self.destino}")
            print(f"Se necesitan {self.tripulacionNecesaria} tripulantes como minimo")
        else:
            print(f"La nave no tiene suficiente combustible para llegar a {self.destino}")
            print("¡La misión ha fracasado! D=")

nave1 = Nave("Aurora", 10000, 1000)  
mision1 = Mision("Titan", 10, 5) 
nave2 = Nave("Sunbeam", 5000, 500)
mision2 = Mision("Niese 581D", 10000,200)

mision2.Simulacion(nave2)
mision1.Simulacion(nave1)
