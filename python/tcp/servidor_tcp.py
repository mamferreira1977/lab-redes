# This is a sample Python script.
import socket
from datetime import datetime

HOST = "0.0.0.0"
PORTA = 5000

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as servidor:
    servidor.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    servidor.bind((HOST, PORTA))
    servidor.listen(1)

    print(f"[TCP] Servidor aguardando conexões na porta {PORTA}...")

    conexao, endereco = servidor.accept()

    with conexao:
        print(f"[TCP] Cliente conectado: {endereco}")

        while True:
            dados = conexao.recv(1024).decode("utf-8").strip()

            if not dados:
                break

            print(f"[TCP] Recebido: {dados}")

            if dados.lower() == "sair":
                conexao.sendall(
                    "Encerrando conexão. Até mais!\n".encode("utf-8")
                )
                break

            elif dados.lower() == "hora":
                horario_atual = datetime.now().strftime("%H:%M:%S")

                resposta = (
                    f"Horário atual do servidor: {horario_atual}\n"
                )

            else:
                resposta = (
                    f'Monitor responde: recebi sua mensagem -> "{dados}"\n'
                )

            conexao.sendall(resposta.encode("utf-8"))

print("[TCP] Servidor encerrado.")
