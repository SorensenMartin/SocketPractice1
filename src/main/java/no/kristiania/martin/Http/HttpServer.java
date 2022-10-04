package no.kristiania.martin.Http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpServer {

    public HttpServer(int port) {

    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");

        var serverSocket = new ServerSocket(8080);

        var clientSocket = serverSocket.accept();

        var request = new HttpMessage(clientSocket);
        System.out.println(request.getStartLine());
        System.out.println(request.httpHeaders);

        var body = "<html><h1>Hellæ world!</h1></hmtl>";
        var contentLength = body.getBytes().length;
        clientSocket.getOutputStream().write((
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html; charset=utf-8\r\n" +
                "Content-Length: " + contentLength + "\r\n" +
                "\r\n" +
                body).getBytes(StandardCharsets.UTF_8));

    }

    public int getPort() {
        return 0;
    }
}
