## RESPOSTAS 4.6 

## 1.Se o cliente for iniciado antes do servidor, a tentativa de conexão falhará. Isso acontece porque, no TCP, o cliente precisa estabelecer uma conexão com um servidor que já esteja executando e “escutando” naquela porta.
## 2. O TCP garante a ordem das mensagens por meio dos números de sequência (sequence numbers). Cada segmento TCP recebe uma identificação referente à posição dos dados no fluxo. O receptor usa esses números para reorganizar os segmentos caso eles cheguem fora de ordem
## 3. No código atual, o servidor não atende dois clientes simultaneamente. se um segundo cliente tentar se conectar enquanto o primeiro ainda estiver conectado, ele pode até ficar aguardando na fila de conexões do sistema operacional.


## RESPOSTAS 5.6 

## 1- Com o servidor UDP desligado, o cliente pode enviar a mensagem mesmo assim, porque o UDP é um protocolo sem conexão.

## 2- Dois exemplos reais de aplicações que usam UDP são streaming de áudio/vídeo em tempo real e DNS. No streaming ao vivo, como uma chamada de voz ou vídeo, é mais importante receber os dados rapidamente do que recuperar cada pacote perdido.O DNS também utiliza UDP na maior parte das consultas tradicionais. As mensagens costumam ser pequenas e a comunicação é simples: o cliente pergunta e o servidor responde. Se uma resposta não chegar, o cliente pode simplesmente fazer uma nova consulta.

## 3- Sim, seria possível criar no servidor UDP um registro dos clientes que enviaram mensagens. A arquitetura mudaria porque o servidor passaria a manter estado sobre os clientes. Seria necessário decidir, por exemplo, quando considerar um cliente “ativo”, quando removê-lo da lista e como detectar que ele deixou de participar

## RESPOSTAS 6.7

## 1.	No multicast, o servidor envia uma única mensagem para o endereço do grupo multicast, e a infraestrutura de rede se encarrega de entregá-la aos participantes inscritos naquele grupo. Portanto, o multicast pode reduzir significativamente o tráfego quando a mesma informação precisa ser distribuída para muitos clientes.
## 2- O TTL (Time-to-Live) determina até onde um pacote multicast pode se propagar pela rede. A cada roteador atravessado, o valor do TTL é reduzido. Quando chega a zero, o pacote não é encaminhado adiante. Assim, o TTL evita que mensagens multicast circulem indefinidamente e permite controlar seu alcance.
## 3- Não. Se um cliente estiver offline no momento em que um aviso multicast for enviado, ele não receberá automaticamente essa mensagem quando voltar.


## RESPOSTAS 7.6

## 1. A partir desse momento, aquela mesma conexão TCP deixa de transportar uma conversa HTTP convencional e passa a usar o protocolo WebSocket. A conexão permanece aberta e torna-se bidirecional (full-duplex)

## 2. No Multicast, os clientes entram em um grupo multicast, identificado por um endereço IP específico. O servidor não precisa manter uma conexão individual com cada cliente: ele envia um datagrama para o endereço do grupo, e a própria infraestrutura de rede distribui o pacote aos participantes. No WebSocket, cada cliente estabelece sua própria conexão com o servidor. O servidor conhece as conexões abertas e, para fazer um broadcast, percorre essas conexões e envia a mensagem para cada uma delas.
## 3. O WebSocket já estabelece um protocolo de mensagens (frames) e permite comunicação bidirecional contínua. Além disso, possui uma vantagem muito importante para um mural web em tempo real: os navegadores possuem suporte nativo a WebSocket por JavaScript.Assim, depois de estabelecida a conexão, o servidor pode enviar um novo aviso imediatamente aos clientes, sem que cada cliente precise ficar perguntando repetidamente ao servidor se existe uma nova mensagem.







