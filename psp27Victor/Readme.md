# Práctica UDP - Palabra más larga

## Aplicacion: 

Esta aplicación cliente-servidor desarrollada en Java utiliza el protocolo UDP (DatagramSocket y DatagramPacket) para comunicar dos procesos. El cliente solicita una lista de palabras al usuario y las envía al servidor, el cual procesa la petición y devuelve cuál es la palabra más larga junto con su longitud, incorporando en el cliente un sistema de control de tiempos de espera (timeout) y reintentos.

## Formato de envio:

El formato que elegi es que envie un unico paquete en lugar de transmitir palabra por palabra, el cliente captura todo en una única cadena de texto (String), la codifica a un arreglo de bytes mediante .getBytes() y la encapsula de un solo DatagramPacket

Al recibir el paquete, el servidor reconstruye el String original a partir de los bytes recibidos (String str = new String(packet1.getData(), 0, packet1.getLength());) y divide el array con un .split("  ") despues compara el tamaño de cada elemento con .length() para saber cual es la palabra mas larga


## Declaracion de IA

Use gemini para que me guiara por el ejercicio cuando no sabia como continuar.