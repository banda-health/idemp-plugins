package org.bandahealth.idempiere.rest.repository;

import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.compiere.model.MLocation;
import org.compiere.util.Env;

public class LocationRepository extends BaseRepository<MLocation> {
	@Override
	protected MLocation createModelInstance() {
		return new MLocation(Env.getCtx(), 0, null);
	}

	@Override
	public MLocation mapInputModelToModel(MLocation entity) {
		MLocation location = getByUuid(entity.getC_Location_UU());
		if (location == null) {
			location = createModelInstance();
		}
		ModelUtil.setPropertyIfPresent(entity.getAddress1(), location::setAddress1);
		return location;
	}
}
