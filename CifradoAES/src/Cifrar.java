import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cifrar {

    private static final Scanner snString = new Scanner(System.in);

    public static void main(String[] args) {
        try{
            System.out.println("Introduce un texto a cifrar");
            String textoACifrar = snString.nextLine();
            SecretKeySpec clave = Calculos.obtenerClave("1234567891234567");
            byte[] textoCifrado = Calculos.cifrar(clave,textoACifrar);
            byte[] textoCifrado64 = Calculos.pasarAB64(textoCifrado);
            FileWriter fw = new FileWriter(new File("src/credentials.cre"));
            fw.write(new String(textoCifrado64));
            fw.close();
        }catch (NullPointerException e){
            System.out.println("No se ha encontrado la ruta donde crear el fichero");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
            throw new RuntimeException(e);
        }

    }
}
