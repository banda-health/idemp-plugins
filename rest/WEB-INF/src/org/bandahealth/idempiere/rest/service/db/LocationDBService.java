package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Location;
import org.compiere.model.MLocation;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class LocationDBService extends BaseDBService<Location, MLocation> {
	@Override
	public Location saveEntity(Location entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Location createInstanceWithDefaultFields(MLocation instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Location createInstanceWithAllFields(MLocation instance) {
		return new Location(instance);
	}

	@Override
	protected Location createInstanceWithSearchFields(MLocation instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MLocation getModelInstance() {
		return new MLocation(Env.getCtx(), 0, null);
	}
}
