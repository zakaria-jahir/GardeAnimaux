import com.example.garde.Controller.ClientController;
import com.example.garde.Entity.Client;
import com.example.garde.Service.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClientControllerTest {

    @Mock
    private Service service;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getClients() {
        // Arrange
        List<Client> clients = Arrays.asList(new Client(), new Client());
        when(service.showClients()).thenReturn(clients);

        // Act
        List<Client> result = clientController.getClients();

        // Assert
        assertEquals(clients, result);
        verify(service, times(1)).showClients();
    }

    @Test
    void addClient() {
        // Arrange
        Client client = new Client();
        when(service.addClient(client)).thenReturn(client);

        // Act
        Client result = clientController.add(client);

        // Assert
        assertEquals(client, result);
        verify(service, times(1)).addClient(client);
    }

    @Test
    void updateClient_Success() {
        // Arrange
        Client client = new Client();
        when(service.updateClient(client)).thenReturn(client);

        // Act
        ResponseEntity<Object> result = clientController.update(client);

        // Assert
        assertEquals(ResponseEntity.ok(client), result);
        verify(service, times(1)).updateClient(client);
    }

    @Test
    void updateClient_NotFound() {
        // Arrange
        Client client = new Client();
        when(service.updateClient(client)).thenReturn(null);

        // Act
        ResponseEntity<Object> result = clientController.update(client);

        // Assert
        assertEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found"), result);
        verify(service, times(1)).updateClient(client);
    }

    @Test
    void deleteClient() {
        // Arrange
        int clientId = 1;
        when(service.deleteClinet(clientId)).thenReturn("client removed !!" + clientId);

        // Act
        String result = clientController.delete(clientId);

        // Assert
        assertEquals("client removed !!1", result);
        verify(service, times(1)).deleteClinet(clientId);
    }

    @Test
    void getClientById() {
        // Arrange
        int clientId = 1;
        Client client = new Client();
        when(service.getClientById(clientId)).thenReturn(client);

        // Act
        Client result = clientController.getClinetById(clientId);

        // Assert
        assertEquals(client, result);
        verify(service, times(1)).getClientById(clientId);
    }

    @Test
    void getClientByNom() {
        // Arrange
        String nom = "John";
        List<Client> clients = Arrays.asList(new Client(), new Client());
        when(service.getClientByNom(nom)).thenReturn(clients);

        // Act
        List<Client> result = clientController.getByName(nom);

        // Assert
        assertEquals(clients, result);
        verify(service, times(1)).getClientByNom(nom);
    }

    @Test
    void login_Success() {
        // Arrange
        Client client = new Client();
        when(service.auth(client)).thenReturn(client);

        // Act
        ResponseEntity<?> result = clientController.login(client);

        // Assert
        assertEquals(ResponseEntity.ok(client), result);
        verify(service, times(1)).auth(client);
    }

    @Test
    void login_Unauthorized() {
        // Arrange
        Client client = new Client();
        when(service.auth(client)).thenReturn(null);

        // Act
        ResponseEntity<?> result = clientController.login(client);

        // Assert
        assertEquals(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Invalid credentials\"}"), result);
        verify(service, times(1)).auth(client);
    }
}
