package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1L, 1L, 1L, 
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2L, 1L, 1L,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3L, 2L, 1L,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4L, 2L, 2L,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;


    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet timesheet = sut.getTimesheet(1L);
        assertTimesheetsMatch(TIMESHEET_1, timesheet);

        timesheet = sut.getTimesheet(2L);
        assertTimesheetsMatch(TIMESHEET_2, timesheet);;
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {

        Assert.assertNull(sut.getTimesheet(5L));
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {

        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1L);
        Assert.assertEquals(2, timesheets.size());
        System.out.println(timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
        System.out.println(timesheets.size());

        timesheets = sut.getTimesheetsByEmployeeId(2L);
        System.out.println(timesheets.size());
        Assert.assertEquals(2, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_3, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_4, timesheets.get(1));
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {

        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1L);
        Assert.assertEquals(3, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
        assertTimesheetsMatch(TIMESHEET_3, timesheets.get(2));

        timesheets = sut.getTimesheetsByProjectId(2L);
        Assert.assertEquals(1, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_4, timesheets.get(0));
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {

        Timesheet testTimesheet = new Timesheet(5L, 1L, 1L,
                LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 5");

        Timesheet createdTimesheet = sut.createTimesheet(testTimesheet);

        long newId = createdTimesheet.getTimesheetId();
        Assert.assertTrue(newId > 0);

        testTimesheet.setTimesheetId(newId);
        assertTimesheetsMatch(testTimesheet, createdTimesheet);
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {

        Timesheet testTimesheet = new Timesheet(5L, 1L, 1L,
                LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 5");

        Timesheet createdTimesheet = sut.createTimesheet(testTimesheet);

        long newId = createdTimesheet.getTimesheetId();
        Timesheet retrievedTimesheet = sut.getTimesheet(newId);

        assertTimesheetsMatch(createdTimesheet, retrievedTimesheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {

        Timesheet timesheetToUpdate = sut.getTimesheet(1L);

        timesheetToUpdate.setEmployeeId(1L);
        timesheetToUpdate.setProjectId(1L);
        timesheetToUpdate.setDateWorked(LocalDate.parse("2021-01-01"));
        timesheetToUpdate.setHoursWorked(1);
        timesheetToUpdate.setBillable(true);
        timesheetToUpdate.setHoursWorked(1);
        timesheetToUpdate.setDescription("I am sleepy");

        sut.updateTimesheet(timesheetToUpdate);

        Timesheet retrievedTimesheet = sut.getTimesheet(1L);
        assertTimesheetsMatch(timesheetToUpdate, retrievedTimesheet);
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {

        sut.deleteTimesheet(4L);

        Timesheet retrievedTimesheet = sut.getTimesheet(4L);
        Assert.assertNull(retrievedTimesheet);

        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(2L);
        Assert.assertEquals(0, timesheets.size());
    }

    @Test
    public void getBillableHours_returns_correct_total() {

        Double actualBillableHours = sut.getBillableHours(1L, 1L, true);
        Double expectedBillableHours = 2.5;
        Assert.assertEquals(expectedBillableHours, actualBillableHours);

        Double actual2 = sut.getBillableHours(2L, 1L, true);
        Double expected2 = 0.25;
        Assert.assertEquals(expected2, actual2);

        Double actual3 = sut.getBillableHours(2L, 2L, false);
        Double expected3 = 0.0;
        Assert.assertEquals(expected3, actual3);
        // billable is false here, am i supposed to edit code in the dao?
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
