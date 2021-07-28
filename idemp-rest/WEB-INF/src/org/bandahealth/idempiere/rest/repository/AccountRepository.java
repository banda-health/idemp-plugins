package org.bandahealth.idempiere.rest.repository;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.util.Env;

public class AccountRepository extends BaseRepository<MElementValue> {
	@Override
	protected MElementValue createModelInstance() {
		return new MElementValue(Env.getCtx(), 0, null);
	}

	@Override
	public MElementValue mapInputModelToModel(MElementValue entity) {
		try {
			MElementValue account = getByUuid(entity.getC_ElementValue_UU());
			if (account == null) {
				account = createModelInstance();
			}

			ModelUtil.setPropertyIfPresent(entity.getName(), account::setName);
			ModelUtil.setPropertyIfPresent(entity.getDescription(), account::setDescription);
			ModelUtil.setPropertyIfPresent(entity.isActiva(), account::setIsActive);

			return account;
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}
}
