import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Steps {

    private static final String APPLICATION_JSON = "application/json";

    private final InputStream jsonInputStream = this.getClass().getClassLoader().getResourceAsStream("cucumber.json");
    private final String jsonString = new Scanner(jsonInputStream, "UTF-8").useDelimiter("\\Z").next();
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    private HttpResponse response = null;

    @When("Usuarios fazem uma consulta de um cep válido")
    public void usuarios_fazem_uma_consulta_de_um_cep_válido() throws IOException {
        HttpPost request = new HttpPost("http://localhost:" + 8080 + "/consulta");
        StringEntity entity = new StringEntity(jsonString);
        request.addHeader("content-type", APPLICATION_JSON);
        request.setEntity( entity);
        response = httpClient.execute(request);
        assertEquals(200, response.getStatusLine().getStatusCode());

    }

    @Then("o servidor deve retornar o corpo e o status de sucesso")
    public void o_servidor_deve_retornar_o_corpo_e_o_status_de_sucesso() throws IOException {
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertNotNull(response.getEntity().getContent());
    }

}
