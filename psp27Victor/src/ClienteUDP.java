import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClienteUDP {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe varias palabras separadas por espacios");

        String texto =  scanner.nextLine();

        try{
            DatagramSocket socket = new DatagramSocket();

            socket.setSoTimeout(2000);

            InetAddress ipservidor = InetAddress.getByName("localhost");

            byte [] palabras = texto.getBytes();

            DatagramPacket packet = new DatagramPacket(palabras, palabras.length, ipservidor,5000);

            byte[] bufferRespuesta = new byte[1024];

            DatagramPacket packet1 =  new DatagramPacket(bufferRespuesta, bufferRespuesta.length);



            int intentos = 0;

            boolean recibido = false;

            while(intentos <3 && !recibido){

                try{

                    socket.send(packet);
                    socket.receive(packet1);
                    String str = new String(packet1.getData(), 0, packet1.getLength());
                    System.out.println(str);
                    recibido = true;


                }catch (SocketTimeoutException e){

                    intentos++;
                    System.out.println("Tiempo agotado. Reintentando (" + intentos + "/3) " +  e.getMessage());


                }


            }

            if (!recibido) {
                System.out.println("Servidor no disponible");
            }

            socket.close();

            scanner.close();



        }catch (IOException e){
            System.out.println(e.getMessage());
        }




    }



}