package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.rest.model.Account;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MElementValue;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class AccountDBService extends BaseDBService<Account, MElementValue> {

	private CLogger log = CLogger.getCLogger(AccountDBService.class);

	@Override
	public Account saveEntity(Account entity) {
		try {
			MElementValue account = getEntityByUuidFromDB(entity.getUuid());
			if (account == null) {
				account = getModelInstance();
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					account.setC_ElementValue_UU(entity.getUuid());
				}
			}

			if (StringUtil.isNotNullAndEmpty(entity.getName())) {
				account.setName(entity.getName());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				account.setDescription(entity.getDescription());
			}

			account.setIsActive(entity.getIsActive());

			account.saveEx();

			return createInstanceWithAllFields(getEntityByUuidFromDB(account.getC_ElementValue_UU()));

		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Account createInstanceWithDefaultFields(MElementValue instance) {
		try {
			return new Account(instance.getC_ElementValue_UU(), instance.getName(), instance.getDescription(),
					instance.getValue());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Account createInstanceWithAllFields(MElementValue instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected Account createInstanceWithSearchFields(MElementValue instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected MElementValue getModelInstance() {
		return new MElementValue(Env.getCtx(), 0, null);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
