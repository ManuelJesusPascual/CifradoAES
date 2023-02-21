import javax.crypto.spec.SecretKeySpec;
import java.io.*;

public class Descifrar {
    public static void main(String[] args) {
        try{
            SecretKeySpec clave = Calculos.obtenerClave("1234567891234567");
            FileReader fr = new FileReader(new File("src/credentials.cre"));
            BufferedReader br = new BufferedReader(fr);
            String textoCifrado = br.readLine();
            String textoDescifrado = Calculos.descifrar(clave,textoCifrado.getBytes());
            System.out.println(textoDescifrado);
            br.close();
            fr.close();

        }catch (FileNotFoundException e){
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
            throw new RuntimeException(e);
        }

    }
}
