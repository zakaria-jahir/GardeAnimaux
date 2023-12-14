import com.example.garde.Controller.ReservationController;
import com.example.garde.Entity.Reservation;
import com.example.garde.Service.Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservationControllerTest {

    @Mock
    private Service service;

    @InjectMocks
    private ReservationController reservationController;

    @Test
    public void testGetReservations() {
        // Mocking the service method
        when(service.showReservations()).thenReturn(Arrays.asList(new Reservation(), new Reservation()));

        // Calling the controller method
        List<Reservation> reservations = reservationController.getReservations();

        // Verifying the result
        assertEquals(2, reservations.size());
    }

    @Test
    public void testReserver() {
        // Mocking the service method
        when(service.reserver(any(Reservation.class))).thenReturn(new Reservation());

        // Calling the controller method
        Reservation reservation = reservationController.reserver(new Reservation());

        // Verifying the result
        assertEquals(Reservation.class, reservation.getClass());
    }

    @Test
    public void testUpdate() {
        // Mocking the service method
        when(service.updateReservation(any(Reservation.class))).thenReturn(new Reservation());

        // Calling the controller method
        Reservation reservation = reservationController.update(new Reservation());

        // Verifying the result
        assertEquals(Reservation.class, reservation.getClass());
    }

    @Test
    public void testDelete() {
        // Mocking the service method
        when(service.deleteReservation(anyInt())).thenReturn("Deleted successfully");

        // Calling the controller method
        ResponseEntity<String> response = reservationController.delete(1);

        // Verifying the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted successfully", response.getBody());
    }

    @Test
    public void testGetReservationById() {
        // Mocking the service method
        when(service.getReservationById(anyInt())).thenReturn(new Reservation());

        // Calling the controller method
        Reservation reservation = reservationController.getReservationById(1);

        // Verifying the result
        assertEquals(Reservation.class, reservation.getClass());
    }

    @Test
    public void testGetClientReservations() {
        // Mocking the service method
        when(service.getClientReservations(anyInt())).thenReturn(Arrays.asList(new Reservation(), new Reservation()));

        // Calling the controller method
        List<Reservation> reservations = reservationController.getClientReservations(1);

        // Verifying the result
        assertEquals(2, reservations.size());
    }
}
