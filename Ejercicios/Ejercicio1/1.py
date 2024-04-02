import random

class Auto:
    def __init__(self, nombre):
        self.nombre = nombre
        self.distanciaRecorrida = 0
    
    def avanzar(self):
        distanciaAvance = random.randint(1, 6)  
        self.distanciaRecorrida += distanciaAvance

    def obtenerDistanciaRecorrida(self):
        return self.distanciaRecorrida


class Carrera:
    def __init__(self, distanciaTotal):
        self.distanciaTotal = distanciaTotal
    
    def Carrera(self):
        while jugador.obtenerDistanciaRecorrida() < self.distanciaTotal and computadora.obtenerDistanciaRecorrida() < self.distanciaTotal:
            jugador.avanzar()
            computadora.avanzar()
        
        if jugador.obtenerDistanciaRecorrida() >= self.distanciaTotal and computadora.obtenerDistanciaRecorrida() >= self.distanciaTotal:
            return "Empate "
        elif jugador.obtenerDistanciaRecorrida() >= self.distanciaTotal:
            return "GANASTE CAPO !!"
        else:
            return "PERDISTE =("

jugador = Auto("Tu")
computadora = Auto("PC")
carrera = Carrera(100)
resultado = carrera.Carrera()
print(resultado)
