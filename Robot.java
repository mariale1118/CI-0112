public class Robot {
    String nombre;
    int puntosDeVida;
    int ataque;
    
    public Robot(String nombre, int puntosVida, int ataque) {
        this.nombre = nombre;
        this.puntosDeVida = puntosVida;
        this.ataque = ataque;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setPuntosVida(int puntosVida) {
        this.puntosDeVida = puntosVida;
    }

    public int getPuntosVida() {
        return puntosDeVida;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }
    
    public boolean estaVivo() {
        return puntosDeVida > 0;
    }
    
    public void atacar(Robot otroRobot) {
        int daño = this.ataque;
        System.out.println(this.nombre + " ataca a " + otroRobot.getNombre() + " con " + daño + " de daño.");
        otroRobot.puntosDeVida -= daño;
        if (otroRobot.puntosDeVida < 0) {
            otroRobot.puntosDeVida = 0;
        }
        System.out.println(otroRobot.getNombre() + " tiene ahora " + otroRobot.getPuntosVida() + " puntos de vida.");
    }
}
