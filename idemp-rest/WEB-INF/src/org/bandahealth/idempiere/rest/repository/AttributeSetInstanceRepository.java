package org.bandahealth.idempiere.rest.repository;

import org.compiere.model.MAttributeSet;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.util.Env;

import java.util.List;

public class AttributeSetInstanceRepository extends BaseRepository<MAttributeSetInstance> {
	private final AttributeSetRepository attributeSetRepository;

	public AttributeSetInstanceRepository() {
		attributeSetRepository = new AttributeSetRepository();
	}

	@Override
	protected MAttributeSetInstance createModelInstance() {
		return new MAttributeSetInstance(Env.getCtx(), 0, null);
	}

	@Override
	public MAttributeSetInstance mapInputModelToModel(MAttributeSetInstance entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public List<Object> getDefaultJoinClauseParameters() {
		return attributeSetRepository.getDefaultWhereClauseParameters();
	}

	@Override
	public String getDefaultJoinClause() {
		return "JOIN " + MAttributeSet.Table_Name + " ON " + MAttributeSet.Table_Name + "." +
				MAttributeSet.COLUMNNAME_M_AttributeSet_ID + "=" + MAttributeSetInstance.Table_Name + "." +
				MAttributeSetInstance.COLUMNNAME_M_AttributeSet_ID + " AND " +
				attributeSetRepository.getDefaultWhereClause();
	}
}
