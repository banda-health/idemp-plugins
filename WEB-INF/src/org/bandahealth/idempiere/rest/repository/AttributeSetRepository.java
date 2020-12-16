package org.bandahealth.idempiere.rest.repository;

import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.compiere.model.MAttributeSet;
import org.compiere.util.Env;

import java.util.Collections;
import java.util.List;

public class AttributeSetRepository extends BaseRepository<MAttributeSet> {
	@Override
	protected MAttributeSet createModelInstance() {
		return new MAttributeSet(Env.getCtx(), 0, null);
	}

	@Override
	public MAttributeSet mapInputModelToModel(MAttributeSet entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public List<Object> getDefaultWhereClauseParameters() {
		return Collections.singletonList(QueryConstants.BANDAHEALTH_PRODUCT_ATTRIBUTE_SET);
	}

	@Override
	public String getDefaultWhereClause() {
		return MAttributeSet.Table_Name + "." + MAttributeSet.COLUMNNAME_Name + "=?";
	}
}
