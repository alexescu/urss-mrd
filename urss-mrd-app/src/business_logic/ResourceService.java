package business_logic;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import controllers.ResourceController;
import data_access.Resource;

@Path("/resources")
public class ResourceService {

	@Path("/resource")
	@GET
	@Produces("application/json")
	public ArrayList<Resource> getResource(){
		ResourceController controller = new ResourceController();
		return controller.readResources();
	}	
}
