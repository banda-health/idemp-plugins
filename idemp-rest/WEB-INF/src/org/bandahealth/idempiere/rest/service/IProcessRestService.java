package org.bandahealth.idempiere.rest.service;

import org.bandahealth.idempiere.rest.model.Process;
import org.bandahealth.idempiere.rest.model.BHProcessInfo;

public interface IProcessRestService<T extends Process> {

	BHProcessInfo runProcess(BHProcessInfo request);
}