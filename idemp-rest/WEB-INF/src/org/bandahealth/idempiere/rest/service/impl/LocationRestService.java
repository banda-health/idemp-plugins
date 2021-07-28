package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.LocationRepository;
import org.compiere.model.MLocation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.LOCATIONGS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocationRestService {

	private final LocationRepository locationRepository;

	public LocationRestService() {
		locationRepository = new LocationRepository();
	}

	@GET
	public Map<Integer, MLocation> getByIds(@QueryParam("ids") Set<Integer> ids) {
		return locationRepository.getByIds(ids);
	}
}
