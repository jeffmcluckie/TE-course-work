package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;
    private Park testPark;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
        LocalDate testDate = LocalDate.now();

        testPark = new Park(0, "Test Park", testDate, 99, false);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park park = sut.getPark(1);
        assertParksMatch(PARK_1, park);

        park = sut.getPark(2);
        assertParksMatch(PARK_2, park);
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Park park = sut.getPark(9999);
        Assert.assertNull(park);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> parkList = sut.getParksByState("AA");
        Assert.assertEquals(2, parkList.size());
        assertParksMatch(PARK_1, parkList.get(0));
        assertParksMatch(PARK_3, parkList.get(1));

        parkList = sut.getParksByState("BB");
        Assert.assertEquals(1, parkList.size());
        assertParksMatch(PARK_2, parkList.get(0));
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> parkList  = sut.getParksByState("XX");
        Assert.assertEquals(0, parkList.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Park newPark = sut.createPark(testPark);

        // Get the id from my newly created park AND make sure it is > 0
        // It should be set to something BUT we don't care what actual number that is
        Long parkId = newPark.getParkId();
        Assert.assertTrue(parkId > 0);

        // Set whatever value the ID was on my testPark, so that I can re-use
        // that assertParksMatch to check all the fields on my park instance
        testPark.setParkId(parkId);
        assertParksMatch(testPark, newPark);
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Park createdPark = sut.createPark(testPark);

        // Get id to fetch from db again & make sure that looks correct
        Long parkId = createdPark.getParkId();
        Park fetchedPark = sut.getPark(parkId);

        assertParksMatch(createdPark, fetchedPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Park parkToUpdate = sut.getPark(1);

        parkToUpdate.setHasCamping(false);
        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setArea(999);
        parkToUpdate.setParkName("Updated");

        sut.updatePark(parkToUpdate);

        Park fetchedPark = sut.getPark(1);
        assertParksMatch(parkToUpdate, fetchedPark);
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        // Get a park first to make sure it exists before we delete it
        Park parkToDelete = sut.getPark(3);
        Assert.assertNotNull(parkToDelete);

        // TODO - might also be good to validate that it is found in 2 states

        // Now let's delete it
        sut.deletePark(parkToDelete.getParkId());

        // Make sure it is gone by trying to get it again
        Park fetchedPark = sut.getPark(parkToDelete.getParkId());
        Assert.assertNull(fetchedPark);

        // ALSO make sure that the rows in the park_state table are gone
        List<Park> parkList = sut.getParksByState("CC");
        Assert.assertTrue( parkList.size() == 0 );
        // There is another park in state AA, but it should go from 2 to 1
        parkList = sut.getParksByState("AA");
        Assert.assertTrue( parkList.size() == 1 );
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        // TODO - make sure park exists & is NOT in state CC (where we will add it)

        sut.addParkToState(1, "CC");

        List<Park> fetchedParks = sut.getParksByState("CC");
        Assert.assertTrue(fetchedParks.size() == 2);
        assertParksMatch(PARK_1, fetchedParks.get(0));
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        // TODO - make sure stuff exists before we try to remove it

        sut.removeParkFromState(PARK_2.getParkId(), "BB");

        List<Park> fetchedParks = sut.getParksByState("BB");
        Assert.assertTrue(fetchedParks.size() == 0);

        // Make sure that park 2 still exists
        Park park = sut.getPark(PARK_2.getParkId());
        Assert.assertNotNull(park);
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
