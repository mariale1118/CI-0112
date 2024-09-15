import java.util.Scanner;

public class JuegoBatalla {
    Robot[] robots; 
    int cantidadRobots;
    
    public JuegoBatalla(int cantidad) {
        cantidadRobots = cantidad;
        robots = new Robot[cantidadRobots]; 
    }
    
    public void agregarRobot(Robot robot, int indice) {
        robots[indice] = robot; 
    }
    
    public void iniciarBatalla() {
        System.out.println("Inicia el juego");
        
        
        while (contarRobotsVivos() > 1) {
            for (int i = 0; i < cantidadRobots; i++) {
                Robot atacante = robots[i];
                
                if (atacante.estaVivo()) {
                    
                    int defensorIndex = (int)(Math.random() * cantidadRobots);
                    Robot defensor = robots[defensorIndex];
                    
                    
                    if (i != defensorIndex && defensor.estaVivo()) {
                        atacante.atacar(defensor);
                    }
                }
            }
        }
        
        mostrarGanador();
    }
    
    public int contarRobotsVivos() {
        int vivos = 0;
        for (int i = 0; i < cantidadRobots; i++) {
            if (robots[i].estaVivo()) {
                vivos++;
            }
        }
        return vivos;
    }
    
    public void mostrarGanador() {
        for (int i = 0; i < cantidadRobots; i++) {
            if (robots[i].estaVivo()) {
                System.out.println("El robot ganador es: " + robots[i].nombre);
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el número de robots (máximo 10): ");
        int cantidadRobots = scanner.nextInt();
        scanner.nextLine();  

        if (cantidadRobots > 10) {
            cantidadRobots = 10; 
        }

        JuegoBatalla juego = new JuegoBatalla(cantidadRobots);

        for (int i = 0; i < cantidadRobots; i++) {
            System.out.println("Ingrese el nombre del robot " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            
            int puntosVida = 50 + (int)(Math.random() * 51); 
            int ataque = 10 + (int)(Math.random() * 11);      
            
            Robot robot = new Robot(nombre, puntosVida, ataque);
            juego.agregarRobot(robot, i);
            
            System.out.println("Robot creado: " + nombre + " con " + puntosVida + " puntos de vida y " + ataque + " de ataque.");
        }
        
        juego.iniciarBatalla();
    }
}

