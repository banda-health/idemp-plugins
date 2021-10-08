package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.rest.model.Movement;

public abstract class BaseMovementDBService<T extends Movement> extends DocumentDBService<T, MMovement_BH> {

	public BaseMovementDBService() {
	}
}
