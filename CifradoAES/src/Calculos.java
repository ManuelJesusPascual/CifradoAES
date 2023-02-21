import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Calculos {

    public static SecretKeySpec obtenerClave(String contrasena) {

        byte[] pass = contrasena.getBytes();
        SecretKeySpec clave = new SecretKeySpec(pass, "AES");
        return clave;


    }

    public static byte[] cifrar(SecretKeySpec clave,String textoACifrar){
        try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,clave);
            byte[] textoCifrado = cipher.doFinal(textoACifrar.getBytes());
            return textoCifrado;
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("El algoritmo seleccionado no ha sido encontrado");
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            System.out.println("La clave introducida no tiene 16, 24 o 32 bytes");
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            System.out.println("Esa clave no es la misma que se uso para encriptar");
            throw new RuntimeException(e);
        }


    }

    public static String descifrar(SecretKeySpec clave,byte[] textoCifrado){
        try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,clave);
            byte[] textoDescifradoArray = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
            String textoDescifrado = new String(textoDescifradoArray);
            return textoDescifrado;
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("El algoritmo seleccionado no ha sido encontrado");
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            System.out.println("La clave introducida no tiene 16, 24 o 32 bytes");
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            System.out.println("Esa clave no es la misma que se uso para encriptar");
            throw new RuntimeException(e);
        }

    }

    public static byte[] pasarAB64(byte[] cifrado){

        return Base64.getEncoder().encode(cifrado);

    }

}
