package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.service.interfaces.IHotelService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class HotelServiceTest {

    @InjectMocks
    private IHotelService hotelService = new HotelService();

    @Mock
    private HotelRepository hotelRepository;

    @Test
    void addHotel() {

        Hotel hotel = new Hotel();
        hotel.setHotel_id(16);
        String city = "Mumbai";
        hotel.setCity(city);
        String hotel_name = "Four Seasons";
        hotel.setHotel_name(hotel_name);
        String address = "Mumbai";
        hotel.setAddress(address);
        String description = "Oriental Hotel";
        hotel.setDescription(description);
        double avg_rate_per_day = 5;
        hotel.setAvg_rate_per_day(avg_rate_per_day);
        String email = "fourseasons5@gmail.com";
        hotel.setEmail(email);
        String phone1 = "7635284728";
        hotel.setPhone1(phone1);
        String phone2 = "7635273428";
        hotel.setPhone2(phone2);
        String website = "FourSeasons_Link";
        hotel.setWebsite(website);

        when(hotelRepository.save(hotel)).thenReturn(hotel);

        Hotel newHotel = hotelService.addHotel(hotel);

        assertThat(newHotel.getHotel_name()).isEqualTo(hotel_name);
        assertThat(newHotel.getEmail()).isEqualTo(email);


    }

    @Test
    void removeHotel() {

        Hotel hotel = new Hotel();
        int hotel_id = 16;
        hotel.setHotel_id(hotel_id);
        String city = "Mumbai";
        hotel.setCity(city);
        String hotel_name = "Four Seasons";
        hotel.setHotel_name(hotel_name);
        String address = "Mumbai";
        hotel.setAddress(address);
        String description = "Oriental Hotel";
        hotel.setDescription(description);
        double avg_rate_per_day = 5;
        hotel.setAvg_rate_per_day(avg_rate_per_day);
        String email = "fourseasons5@gmail.com";
        hotel.setEmail(email);
        String phone1 = "7635284728";
        hotel.setPhone1(phone1);
        String phone2 = "7635273428";
        hotel.setPhone2(phone2);
        String website = "FourSeasons_Link";
        hotel.setWebsite(website);

        when(hotelRepository.findById(hotel_id)).thenReturn(Optional.of(hotel));

        hotelService.removeHotel(hotel_id);

        verify(hotelRepository,times(1)).findById(hotel_id);
        verify(hotelRepository,times(1)).deleteById(hotel_id);
    }

    @Test
    void showAllHotels() {

        Hotel hotel1 = new Hotel();
        hotel1.setHotel_id(16);
        hotel1.setCity("Mumbai");
        hotel1.setHotel_name("Four Seasons");
        hotel1.setAddress("Mumbai");
        hotel1.setDescription("Oriental Hotel");
        hotel1.setAvg_rate_per_day(5);
        hotel1.setEmail("fourseasons5@gmail.com");
        hotel1.setPhone1("7635284728");
        hotel1.setPhone2("7635273428");
        hotel1.setWebsite("FourSeasons_Link");

        Hotel hotel2 = new Hotel();
        hotel2.setHotel_id(17);
        hotel2.setCity("Pune");
        hotel2.setHotel_name("Hotel Bliss");
        hotel2.setAddress("Pune");
        hotel2.setDescription("5Star Hotel");
        hotel2.setAvg_rate_per_day(5);
        hotel2.setEmail("hotelblisspune@gmail.com");
        hotel2.setPhone1("9988766436");
        hotel2.setPhone2("9988775400");
        hotel2.setWebsite("HotelBlissPune_Link");

        Hotel hotel3 = new Hotel();
        hotel3.setHotel_id(18);
        hotel3.setCity("Kerala");
        hotel3.setHotel_name("Lake Place Inn");
        hotel3.setAddress("Kerala");
        hotel3.setDescription("RoomView with Sun Rise & Sun Set");
        hotel3.setAvg_rate_per_day(5);
        hotel3.setEmail("lakeplaceinn@gmail.com");
        hotel3.setPhone1("7636665430");
        hotel3.setPhone2("9089173428");
        hotel3.setWebsite("LakePalaceInn_Link");

        List<Hotel> list = new ArrayList<>();
        list.add(hotel1);
        list.add(hotel2);
        list.add(hotel3);

        when(hotelRepository.findAll()).thenReturn(list);

        List<Hotel> allHotels = hotelService.showAllHotels();

        assertThat(allHotels.size()).isEqualTo(3);
    }

    @Test
    void showHotel() {

        Hotel hotel = new Hotel();
        int hotel_id = 16;
        hotel.setHotel_id(hotel_id);
        String city = "Mumbai";
        hotel.setCity(city);
        String hotel_name = "Four Seasons";
        hotel.setHotel_name(hotel_name);
        String address = "Mumbai";
        hotel.setAddress(address);
        String description = "Oriental Hotel";
        hotel.setDescription(description);
        double avg_rate_per_day = 5;
        hotel.setAvg_rate_per_day(avg_rate_per_day);
        String email = "fourseasons5@gmail.com";
        hotel.setEmail(email);
        String phone1 = "7635284728";
        hotel.setPhone1(phone1);
        String phone2 = "7635273428";
        hotel.setPhone2(phone2);
        String website = "FourSeasons_Link";
        hotel.setWebsite(website);

        when(hotelRepository.findById(hotel_id)).thenReturn(Optional.of(hotel));

        Hotel newHotel = hotelService.showHotel(hotel_id);

        assertThat(newHotel.getHotel_name()).isEqualTo(hotel_name);
    }
}