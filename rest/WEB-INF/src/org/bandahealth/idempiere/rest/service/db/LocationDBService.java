package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.compiere.model.MLocation;
import org.compiere.model.MLocator;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LocationDBService extends BaseDBService<BaseMetadata, MLocation> {
	@Override
	public BaseMetadata saveEntity(BaseMetadata entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected BaseMetadata createInstanceWithDefaultFields(MLocation instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BaseMetadata createInstanceWithAllFields(MLocation instance) {
		return new BaseMetadata(instance);
	}

	@Override
	protected BaseMetadata createInstanceWithSearchFields(MLocation instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MLocation getModelInstance() {
		return new MLocation(Env.getCtx(), 0, null);
	}
}
