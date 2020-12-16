package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.UserRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path(IRestConfigs.USERS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRestService {

	private final UserRepository userRepository;

	public UserRestService() {
		userRepository = new UserRepository();
	}

	@GET
	public List<MUser_BH> get(@QueryParam("ids") Set<Integer> ids) {
		return new ArrayList<>(userRepository.getByIds(ids).values());
	}
}
