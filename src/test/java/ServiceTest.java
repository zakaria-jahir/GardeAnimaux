import com.example.garde.Entity.*;
import com.example.garde.Repository.AdminRepository;
import com.example.garde.Repository.ClientRepository;
import com.example.garde.Repository.GardienRepository;
import com.example.garde.Repository.ReservationRepository;
import com.example.garde.Service.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceTest {

    @InjectMocks
    private Service service;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private GardienRepository gardienRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void showClients() {
        // Arrange
        List<Client> clients = new ArrayList<>();
        when(clientRepository.findAll()).thenReturn(clients);

        // Act
        List<Client> result = service.showClients();

        // Assert
        verify(clientRepository, times(1)).findAll();
        assertSame(clients, result);
    }

    @Test
    void showAdmins() {
        // Arrange
        List<Admin> admins = new ArrayList<>();
        when(adminRepository.findAll()).thenReturn(admins);

        // Act
        List<Admin> result = service.showAdmins();

        // Assert
        verify(adminRepository, times(1)).findAll();
        assertSame(admins, result);
    }

    @Test
    void showGardiens() {
        // Arrange
        List<Gardien> gardiens = new ArrayList<>();
        when(gardienRepository.findAll()).thenReturn(gardiens);

        // Act
        List<Gardien> result = service.showGardiens();

        // Assert
        verify(gardienRepository, times(1)).findAll();
        assertSame(gardiens, result);
    }

    @Test
    void showReservations() {
        // Arrange
        List<Reservation> reservations = new ArrayList<>();
        when(reservationRepository.findAll()).thenReturn(reservations);

        // Act
        List<Reservation> result = service.showReservations();

        // Assert
        verify(reservationRepository, times(1)).findAll();
        assertSame(reservations, result);
    }

    @Test
    void addClient() {
        // Arrange
        Client client = new Client();
        when(clientRepository.save(client)).thenReturn(client);

        // Act
        Client result = service.addClient(client);

        // Assert
        verify(clientRepository, times(1)).save(client);
        assertSame(client, result);
    }

    @Test
    void addAdmin() {
        // Arrange
        Admin admin = new Admin();
        when(adminRepository.save(admin)).thenReturn(admin);

        // Act
        Admin result = service.addAdmin(admin);

        // Assert
        verify(adminRepository, times(1)).save(admin);
        assertSame(admin, result);
    }

    @Test
    void addGardien() {
        // Arrange
        Gardien gardien = new Gardien();
        when(gardienRepository.save(gardien)).thenReturn(gardien);

        // Act
        Gardien result = service.addGardien(gardien);

        // Assert
        verify(gardienRepository, times(1)).save(gardien);
        assertSame(gardien, result);
    }

    @Test
    void reserver() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation.setClient(new Client());
        reservation.setGardien(new Gardien());

        when(reservationRepository.save(reservation)).thenReturn(reservation);
        when(clientRepository.findById(anyInt())).thenReturn(Optional.of(new Client()));
        when(gardienRepository.findById(anyInt())).thenReturn(Optional.of(new Gardien()));

        // Act
        Reservation result = service.reserver(reservation);

        // Assert
        verify(reservationRepository, times(1)).save(reservation);
        assertNotNull(result);
    }

    // Add similar tests for updateClient, updateAdmin, updateGardien, and updateReservation methods

    @Test
    void deleteClient() {
        // Arrange
        int clientId = 1;

        // Act
        String result = service.deleteClinet(clientId);

        // Assert
        verify(clientRepository, times(1)).deleteById(clientId);
        assertEquals("client removed !!" + clientId, result);
    }

    // Add similar tests for deleteAdmin, deleteGardien, and deleteReservation methods

    // Add tests for getClientById, getGardienById, getAdminById, and getReservationById methods

    // Add tests for getClientByNom, getAdminByNom, getGardienByNom, getGardienByTypeGardien,
    // getGardienByTypeAnimaux, and getGardiensByPriceRange methods

    // Add tests for findAdminByMail, findClientByMail, and findGardienByMail methods

    @Test
    void authClient() {
        // Arrange
        Client client = new Client();
        client.setMail("test@mail.com");
        client.setPassword("password");

        when(clientRepository.findByMail(client.getMail())).thenReturn(client);

        // Act
        Client result = service.auth(client);

        // Assert
        assertNotNull(result);
        assertSame(client, result);
    }

    @Test
    void authAdmin() {
        // Arrange
        Admin admin = new Admin();
        admin.setMail("test@mail.com");
        admin.setPassword("password");

        when(adminRepository.findByMail(admin.getMail())).thenReturn(admin);

        // Act
        Admin result = service.auth(admin);

        // Assert
        assertNotNull(result);
        assertSame(admin, result);
    }

    @Test
    void authGardien() {
        // Arrange
        Gardien gardien = new Gardien();
        gardien.setMail("test@mail.com");
        gardien.setPassword("password");

        when(gardienRepository.findByMail(gardien.getMail())).thenReturn(gardien);

        // Act
        Gardien result = service.auth(gardien);

        // Assert
        assertNotNull(result);
        assertSame(gardien, result);
    }

    @Test
    void getClientReservations() {
        // Arrange
        int clientId = 1;
        List<Reservation> reservations = new ArrayList<>();
        when(reservationRepository.findByClientId(clientId)).thenReturn(reservations);

        // Act
        List<Reservation> result = service.getClientReservations(clientId);

        // Assert
        verify(reservationRepository, times(1)).findByClientId(clientId);
        assertSame(reservations, result);
    }
}
