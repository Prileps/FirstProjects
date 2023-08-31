import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;



import java.time.LocalTime;
import java.time.ZoneId;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        return airport.getTerminals().stream().
                flatMap(e -> e.getFlights().stream()).filter(t -> t.getType().
                        equals(Flight.Type.DEPARTURE)).filter(time -> time.getDate().
                        toInstant().atZone(ZoneId.systemDefault()).toLocalTime().
                        isBefore(LocalTime.now().plus(2, ChronoUnit.HOURS)) && time.getDate().
                        toInstant().atZone(ZoneId.systemDefault()).toLocalTime().
                        isAfter(LocalTime.now())).
                collect(Collectors.toList());

    }
}