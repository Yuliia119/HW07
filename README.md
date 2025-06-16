1. Клиент подключается к серверу (ServerSocket.accept()).

2. Сервер:
добавляет его в список клиентов через sender.addClient(socket);
запускает ChatServerReceiver в новом потоке.

---
Класс ChatServerReceiver — читает сообщения от одного клиента.
String message = reader.readLine();messageBox.put(message); // ставит в очередь
Полученное сообщение добавляется в общую очередь сообщений messageBox.
Это очередь типа BlockingQueue<String>, она безопасна для многопоточности.

---
Класс ChatServerSender — рассылает сообщения всем клиентам.
String message = messageBox.take();clients.forEach(c -> c.println(message));
Он постоянно берёт сообщение из очереди messageBox.
И отправляет его всем подключённым клиентам (PrintWriter каждого клиента хранится в Set).

---
 Что получает каждый клиент
Клиенты, подключённые к серверу, получают через socket.getInputStream():
свои сообщения (если они ушли в очередь), и сообщения от других клиентов.

