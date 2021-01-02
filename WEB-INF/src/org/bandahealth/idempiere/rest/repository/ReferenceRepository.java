package org.bandahealth.idempiere.rest.repository;

import org.compiere.model.MReference;
import org.compiere.util.Env;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ReferenceRepository extends BaseRepository<MReference> {
	@Override
	protected MReference createModelInstance() {
		return new MReference(Env.getCtx(), 0, null);
	}

	@Override
	public MReference mapInputModelToModel(MReference entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	public List<MReference> getByUuids(List<String> uuids, Properties idempiereContext) {
		return getBaseQuery(MReference.COLUMNNAME_AD_Reference_UU + " IN (" +
				uuids.stream().map(uuid -> "'" + uuid + "'").collect(Collectors.joining(","))).list();
	}

	@Override
	protected boolean shouldUseContextClientId() {
		return false;
	}
}
