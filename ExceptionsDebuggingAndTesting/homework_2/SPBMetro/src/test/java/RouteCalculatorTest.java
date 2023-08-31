import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        Station A1 = new Station("A1", line1);
        Station A2 = new Station("A2", line1);
        Station A3 = new Station("A3", line1);
        line1.addStation(A1);
        line1.addStation(A2);
        line1.addStation(A3);

        Station B1 = new Station("B1", line2);
        Station B2 = new Station("B2", line2);
        Station B3 = new Station("B3", line2);
        line2.addStation(B1);
        line2.addStation(B2);
        line2.addStation(B3);

        Station C1 = new Station("C1", line3);
        Station C2 = new Station("C2", line3);
        Station C3 = new Station("C3", line3);
        line3.addStation(C1);
        line3.addStation(C2);
        line3.addStation(C3);

        List<Station> changeAB = new ArrayList<>();
        changeAB.add(A2);
        changeAB.add(B1);

        List<Station> changeAC = new ArrayList<>();
        changeAC.add(A1);
        changeAC.add(C1);

        stationIndex.addStation(A1);
        stationIndex.addStation(A2);
        stationIndex.addStation(A3);
        stationIndex.addStation(B1);
        stationIndex.addStation(B2);
        stationIndex.addStation(B3);
        stationIndex.addStation(C1);
        stationIndex.addStation(C2);
        stationIndex.addStation(C3);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addConnection(changeAB);
        stationIndex.addConnection(changeAC);


        route.add(new Station("A1", line1));
        route.add(new Station("A2", line1));
        route.add(new Station("A3", line1));

    }

    public void testCalculateDuration() {

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 5.0;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithNoTransfer() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("A1"), stationIndex.getStation("A3"));
        List<Station> expected = List.of(stationIndex.getStation("A1"), stationIndex.getStation("A2"), stationIndex.getStation("A3"));
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithOneTransfer() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("C3"), stationIndex.getStation("A3"));
        List<Station> expected = List.of(stationIndex.getStation("C3"), stationIndex.getStation("C2"), stationIndex.getStation("C1"), stationIndex.getStation("A1"), stationIndex.getStation("A2"), stationIndex.getStation("A3"));
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithTwoTransfer() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("C3"), stationIndex.getStation("B3"));
        List<Station> expected = List.of(stationIndex.getStation("C3"), stationIndex.getStation("C2"), stationIndex.getStation("C1"), stationIndex.getStation("A1"), stationIndex.getStation("A2"), stationIndex.getStation("B1"), stationIndex.getStation("B2"), stationIndex.getStation("B3"));
        assertEquals(expected, actual);
    }

}