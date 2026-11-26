import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteAdivino {

    public static void main(String [] args){

        try{

            Socket socket = new Socket("localhost", 5000);

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);

            while(true){
                System.out.print("Introduce un número (o ADIOS para salir): ");

                String mensaje = scanner.nextLine();

                pw.println(mensaje);

                String respuesta = br.readLine();

               if (respuesta ==  null){
                  break;

               }



               System.out.println("Servidor: " + respuesta);

               if (respuesta.equals("OK Hasta luego")  || respuesta.startsWith("ACIERTO")){

                    break;
               }

            }



            socket.close();
            scanner.close();

        } catch (IOException e) {
            System.out.println(e);
        }


    }



}
