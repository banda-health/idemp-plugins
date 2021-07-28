package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.ProcessParameterRepository;
import org.compiere.model.MProcessPara;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.PROCESS_PARAMETERS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcessParameterRestService {
	private final ProcessParameterRepository processParameterRepository;

	public ProcessParameterRestService() {
		processParameterRepository = new ProcessParameterRepository();
	}

	@GET
	@Path("/processes")
	public Map<Integer, List<MProcessPara>> getByProcessIds(@QueryParam("ids") Set<Integer> ids) {
		return processParameterRepository.getGroupsByIds(MProcessPara::getAD_Process_ID,
				MProcessPara.COLUMNNAME_AD_Process_ID, ids);
	}
}
