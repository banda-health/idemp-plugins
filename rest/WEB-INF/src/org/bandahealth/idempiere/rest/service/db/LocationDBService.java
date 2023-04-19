package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Location;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MLocation;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class LocationDBService extends BaseDBService<Location, MLocation> {
	@Override
	public Location saveEntity(Location entity) {
		try {
			// set location
			MLocation location = new Query(Env.getCtx(), MLocation.Table_Name,
					MLocation.COLUMNNAME_C_Location_UU + " =?", null).setParameters(entity.getUuid()).first();
			if (location == null) {
				location = new MLocation(Env.getCtx(), 0, null);
			}

			if (StringUtil.isNotNullAndEmpty(entity.getAddress1())) {
				location.setAddress1(entity.getAddress1());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getAddress2())) {
				location.setAddress2(entity.getAddress2());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getAddress3())) {
				location.setAddress3(entity.getAddress3());
			}

			location.saveEx();

			return createInstanceWithAllFields(location);

		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
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
