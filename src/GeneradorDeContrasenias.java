import java.util.Scanner;
public class GeneradorDeContrasenias {
    private static final String CONSONANTESMAYUS = "BCDFGHJKLMNÑPQRSTVXZWY";
    private static final String CONSONANTESMINUS = "abcdfghjklmnñpqrstvzyx";
    private static final String VOCALESMAYUS = "AEIOU";
    private static final String VOCALESMINUS = "aeiou";
    private static final String NUMEROS = "0123456789";
    private static final String SIMBOLOS = "!#$%&/()=?*[]_:><,.-{}´+";
    private static final int NUM_PARES = 2;
    private static final int NUM_NUMS = 2;
    private static final int NUM_SIMB = 1;

    private static final String Otra = "N";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        do {
            String password = "";
            for (int i = 0; i < NUM_PARES; i++) {
                password += generaPar();
            }
            for (int i = 0; i < NUM_NUMS; i++) {
                password += getAlea(NUMEROS);
            }
            for (int i = 0; i < NUM_SIMB; i++) {
                password += getAlea(SIMBOLOS);
            }
            System.out.println(password + " >Pulse N para generar una nueva password");
            respuesta = scanner.next();
        } while (respuesta.equalsIgnoreCase(Otra));
        System.out.println("FIN");
        scanner.close();
    }

    private static char getAlea(String opciones) {
        int pos = (int) (Math.random() * opciones.length());
        return opciones.charAt(pos);
    }

    private static String generaPar() {
        String par = "";
        if (Math.random() < 0.25) {
            par += getAlea(VOCALESMAYUS);
            par += getAlea(CONSONANTESMAYUS);
            par += getAlea(VOCALESMINUS);
            par += getAlea(CONSONANTESMINUS);
        } else{
            par += getAlea(VOCALESMAYUS);
            par += getAlea(CONSONANTESMAYUS);
            par += getAlea(VOCALESMINUS);
            par += getAlea(CONSONANTESMINUS);
        }
        return par;
    }
}


