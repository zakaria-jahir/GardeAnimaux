import com.example.garde.Entity.Reservation;
import com.example.garde.Service.Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
public class ReservationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service service;

    @Container
    private static final GenericContainer<?> mySQLContainer = new GenericContainer<>("mysql:8.0")
            .withEnv("MYSQL_DATABASE", "GardeTest")
            .withEnv("MYSQL_USER", "root")
            .withEnv("MYSQL_PASSWORD", "password");

    @Test
    public void testGetReservations() throws Exception {
        List<Reservation> mockReservations = Arrays.asList(new Reservation(), new Reservation());
        when(service.showReservations()).thenReturn(mockReservations);

        mockMvc.perform(MockMvcRequestBuilders.get("/reservations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(mockReservations.size()));
    }

    @Test
    public void testReserver() throws Exception {
        Reservation mockReservation = new Reservation();
        when(service.reserver(mockReservation)).thenReturn(mockReservation);

        mockMvc.perform(MockMvcRequestBuilders.post("/reserver")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // Assuming the Reservation class has an 'id' property
    }

    @Test
    public void testUpdate() throws Exception {
        Reservation mockReservation = new Reservation();
        when(service.updateReservation(mockReservation)).thenReturn(mockReservation);

        mockMvc.perform(MockMvcRequestBuilders.put("/updateReservation")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void testDelete() throws Exception {
        when(service.deleteReservation(1)).thenReturn("Deleted successfully");

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteReservation/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted successfully"));
    }

    @Test
    public void testGetReservationById() throws Exception {
        Reservation mockReservation = new Reservation();
        when(service.getReservationById(1)).thenReturn(mockReservation);

        mockMvc.perform(MockMvcRequestBuilders.get("/reservation/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void testGetClientReservations() throws Exception {
        List<Reservation> mockReservations = Arrays.asList(new Reservation(), new Reservation());
        when(service.getClientReservations(1)).thenReturn(mockReservations);

        mockMvc.perform(MockMvcRequestBuilders.get("/clientReservations/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(mockReservations.size()));
    }
}
