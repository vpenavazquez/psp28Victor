import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;


public class ServicioUDP {

    public static void main(String [] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);

            System.out.println("Servidor arrancado");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            String str = new String(packet.getData(), 0, packet.getLength());

            String[] palabras = str.split(" ");

            String masLarga = "";

            for(String palabra :palabras){
                if( palabra.length() > masLarga.length()){

                    masLarga = palabra;

                }
            }

            String respuesta = "La más larga es: " + masLarga + " (" + masLarga.length() + " letras)";

            byte[] bufferRespuesta = respuesta.getBytes();

            DatagramPacket packet2 = new DatagramPacket(bufferRespuesta, bufferRespuesta.length, packet.getAddress(), packet.getPort());

            socket.send(packet2);

            socket.close();




        }catch (IOException e){
            System.out.println(e.getMessage());

        }
    }







}