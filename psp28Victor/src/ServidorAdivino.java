import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServidorAdivino {

    public static void main(String[] args){

        try{
            ServerSocket servidor = new ServerSocket(5000);

            Socket cliente = servidor.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);

            String linea;

            int numeroSecreto = new Random().nextInt(100) + 1;

            int intentos = 0;

            while ((linea = br.readLine()) != null){

                if(linea.equalsIgnoreCase("ADIOS")){
                    pw.println("OK Hasta luego");
                    break;
                }else{

                    try{

                        int numero = Integer.parseInt(linea.trim());

                        intentos++;

                        if (numero < numeroSecreto){
                            pw.println("MAYOR");
                        } else if (numero > numeroSecreto) {
                            pw.println("MENOR");
                        } else if (numero == numeroSecreto){

                            pw.println("ACIERTO en " + intentos + " intentos" );

                        }

                    }catch (NumberFormatException e){
                        pw.println("ERR Comando no válido");
                    }

                }


            }
            cliente.close();
            servidor.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }




}
