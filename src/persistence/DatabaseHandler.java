package persistence;
import core.BookingEvent;
import java.sql.*;

/**
 * Created by Sereni on 12/3/16.
 */
class RecordNotFoundException extends Exception{}

// todo write a script to create tables
public class DatabaseHandler {

    private String databaseName = "jdbc:sqlite:development.db";

    /**
     * Creates a database entry from a BookingEvent object.
     * **/
    public void makeBooking(BookingEvent booking) throws SQLException {
        String sql = "insert into bookings ()" +  // todo fill in the values when decided on fields
                     String.format("values ()");
        update(sql);
    }

    public BookingEvent getBooking(int number) throws SQLException, RecordNotFoundException {
        String sql = String.format("select * from bookings where number=%d;", number);
        ResultSet results = select(sql);
        if (!results.next()) {
            throw new RecordNotFoundException();
        }
        BookingEvent booking = new BookingEvent();
        // todo fill in the fields when you know what the schema is
        // does BookingEvent have setters, direct access, or a constructor?
        return booking;
    }

    public void cancelBooking(int number) throws SQLException {
        String sql = String.format("update bookings set canceled=1 where number=%d;", number);
        update(sql);
    }

    /**
     * Get the next available booking number from the database.
     */
    public int getNextBookingNumber() throws SQLException {
        String sql = "select number from bookings order by number desc limit 1;";
        ResultSet results = select(sql);
        if (results.next()) {
            return results.getInt(0);
        } else return 1;
    }

    // todo load all info on rooms and convert it into whatever the core code expects.
    // also decide how to store it
    public void getRooms() {

    }

    public float getRate(Date date) {
		return 0;}

    public void setRate(Date date, float rate){}

    public int getBasePrice(String roomType) {
		return 0;}

    public void setBasePrice(String roomType, int price) {}

    /**
     * Establishes connection to the database and performs update with given SQL command.
     */
    private void update(String sql) throws SQLException {
        Connection connection;
        Statement statement;

        connection = DriverManager.getConnection(databaseName);  // todo make it find it
        connection.setAutoCommit(false);
        statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        connection.commit();
        connection.close();

    }

    /**
     * Establishes connection to the database and performs select with given SQL command.
     * @param sql: command to execute.
     * @return ResultSet of rows matching the query.
     * @throws SQLException if any of the underlying operations fail.
     */
    private ResultSet select(String sql) throws SQLException {
        Connection connection;
        Statement statement;

        connection = DriverManager.getConnection(databaseName);
        connection.setAutoCommit(false);
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        statement.close();
        connection.close();
        return result;
    }


}
