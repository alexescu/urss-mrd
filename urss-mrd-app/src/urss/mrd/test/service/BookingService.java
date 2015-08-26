package urss.mrd.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import urss.mrd.test.model.Booking;

/**
 * This class is a sample webservice which will be used in an Angular function.
 * 
 */
@Path("/bookings")
public class BookingService {

	private static List<Booking> bookings = new ArrayList<Booking>()
			{{
				add(new Booking("A11","Tyrion Lannister", "Winter is NOT comming!",12345));
			}};

	@Path("/book")
	@POST
	@Consumes("application/json")
	public void book(Booking b) {
		bookings.add(b);
	}

	@Path("/bookQ")
	@GET
	public void book(@QueryParam("room") String room,@QueryParam("user") String user, @QueryParam("date") long date) {
		Booking b = new Booking();
		b.setDate(date);
		b.setReserver(user);
		b.setRoom(room);

		bookings.add(b);
	}

	@Path("/getLastBook")
	@GET
	@Produces({ "application/json" })
	public Booking getLasBooking() {
		int size = bookings.size();
		return size > 0 ? bookings.get(size - 1) : null;
	}

}
