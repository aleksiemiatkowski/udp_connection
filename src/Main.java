import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(3333);

        byte[] buf = new byte[1000];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        //1
        int suma=0;
        for(int i=0; i<4; i++) {

            socket.receive(packet);
            System.out.println("Odebrano datagram: [" + new String(buf).trim() + "]");
            suma = suma + Integer.valueOf(new String(buf).trim());
        }

        String s = String.valueOf(suma);

        byte bufor[] = new byte[100];
        String data = s;

        bufor = data.getBytes();
        socket.send(new DatagramPacket(bufor, bufor.length,
                packet.getAddress(), packet.getPort()));
        System.out.println("Odeslano datagram: [" + new String(bufor).trim() + "]");

        //2
        byte[] buf2 = new byte[100];
        DatagramPacket packete = new DatagramPacket(buf2, buf2.length);
        socket.receive(packete);
        System.out.println("Odebrano datagram: [" + new String(buf2).trim() + "]");

        String st = (new String(buf2).trim()).replace("7","");

        byte buforek[] = new byte[100];
        String datal = st;

        buforek = datal.getBytes();
        socket.send(new DatagramPacket(buforek, buforek.length,
                packet.getAddress(), packet.getPort()));
        System.out.println("Odeslano datagram: [" + new String(buforek).trim() + "]");

        //3

        byte[] buf3 = new byte[100];
        DatagramPacket packeten = new DatagramPacket(buf3, buf3.length);
        socket.receive(packeten);
        System.out.println("Odebrano datagram: [" + new String(buf3).trim() + "]");

        int x = Integer.valueOf(new String(buf3).trim());

        int wynik = 0;
        int counter = 0;
        boolean lol = true;

        while(lol == true){
            counter++;
            wynik = (int) Math.pow(counter,7);
            if(wynik >= x)
                lol=false;

        }
        System.out.println(counter);

        byte buforek2[] = new byte[100];
        String datap = String.valueOf(counter-1);

        buforek2 = datap.getBytes();
        socket.send(new DatagramPacket(buforek2, buforek2.length,
                packet.getAddress(), packet.getPort()));
        System.out.println("Odeslano datagram: [" + new String(buforek2).trim() + "]");

        //flaga
        byte[] buf4 = new byte[100];
        DatagramPacket packeten4 = new DatagramPacket(buf4, buf4.length);
        socket.receive(packeten4);
        System.out.println("Odebrano datagram: [" + new String(buf4).trim() + "]");

    }
}