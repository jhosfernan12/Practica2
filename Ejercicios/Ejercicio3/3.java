class Nave 
{
    private String modelo;
    private int capacidadCombustible;
    private int consumoCombustiblePorHora;

    public Nave(String modelo, int capacidadCombustible, int consumoCombustiblePorHora) 
    {
        this.modelo = modelo;
        this.capacidadCombustible = capacidadCombustible;
        this.consumoCombustiblePorHora = consumoCombustiblePorHora;
    }

    public int calcularCombustibleRestante(int duracionVueloHoras) 
    {
        int combustibleNecesario = duracionVueloHoras * consumoCombustiblePorHora;
        int combustibleRestante = capacidadCombustible - combustibleNecesario;
        return combustibleRestante;
    }
}

class Mision 
{
    private String destino;
    private int duracionHoras;
    private int tripulacionNecesaria;

    public Mision(String destino, int duracionHoras, int tripulacionNecesaria) 
    {
        this.destino = destino;
        this.duracionHoras = duracionHoras;
        this.tripulacionNecesaria = tripulacionNecesaria;
    }

    public void simulacion(Nave nave) 
    {
        System.out.println("Simulando mision hacia " + destino + "...");
        if (nave.calcularCombustibleRestante(duracionHoras) >= 0) 
        {
            System.out.println("La nave tiene suficiente combustible para llegar a " + destino);
            System.out.println("Se necesitan " + tripulacionNecesaria + " tripulantes como minimo");
        } 
        else 
        {
            System.out.println("La nave no tiene suficiente combustible para llegar a " + destino);
            System.out.println("!La misión ha fracasado!");
        }
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Nave nave1 = new Nave("Aurora", 10000, 1000);
        Mision mision1 = new Mision("Titan", 10, 5);
        Nave nave2 = new Nave("Sunbeam", 5000, 500);
        Mision mision2 = new Mision("Niese 581D", 10000, 200);

        mision2.simulacion(nave2);
        mision1.simulacion(nave1);
    }
}
