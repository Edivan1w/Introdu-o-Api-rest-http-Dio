import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {
	
	public static final String URL_POST = "http://httpbin.org/forms/post";
	public static final String FILE_JSON = "Users\\USUÁRIO\\Desktop\\ALURA\\JAVA\\api-rest-http-ssl-Dio.json";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		//Criando um cliente.
				HttpClient client = HttpClient.newHttpClient();
				

				//Criando uma requisição
				HttpRequest request = HttpRequest.newBuilder()
						//.POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
						.timeout(Duration.ofSeconds(10))
						.uri(URI.create(URL_POST))
						.build();
				
				//enviando uma solicitação.
				client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				        .thenApply(HttpResponse::body)
				        .thenAccept(System.out::println)
				        .join();
				                     
	}

}
