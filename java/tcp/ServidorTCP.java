import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.io.*;
import java.net.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ServidorTCP {

    public static void main(String[] args) throws IOException {

        int porta = 5000;

        try (ServerSocket servidor = new ServerSocket(porta)) {

            System.out.println("[TCP] Servidor aguardando conexões na porta " + porta + "...");

            try (Socket cliente = servidor.accept();
                 BufferedReader entrada = new BufferedReader(
                         new InputStreamReader(cliente.getInputStream()));
                 PrintWriter saida = new PrintWriter(
                         cliente.getOutputStream(), true)) {

                System.out.println("[TCP] Cliente conectado: "
                        + cliente.getRemoteSocketAddress());

                String mensagem;

                while ((mensagem = entrada.readLine()) != null) {

                    System.out.println("[TCP] Recebido: " + mensagem);

                    // Encerra a conexão
                    if (mensagem.equalsIgnoreCase("sair")) {
                        saida.println("Encerrando conexão. Até mais!");
                        break;
                    }

                    // Retorna o horário atual do servidor
                    if (mensagem.equalsIgnoreCase("hora")) {

                        LocalTime horarioAtual = LocalTime.now();

                        DateTimeFormatter formato =
                                DateTimeFormatter.ofPattern("HH:mm:ss");

                        saida.println(
                                "Horário atual do servidor: "
                                        + horarioAtual.format(formato)
                        );

                    } else {

                        // Resposta padrão
                        saida.println(
                                "Monitor responde: recebi sua mensagem -> \""
                                        + mensagem + "\""
                        );
                    }
                }
            }
        }

        System.out.println("[TCP] Servidor encerrado.");
    }
}