package org.bandahealth.idempiere.base;

import java.util.Properties;

import com.chuboe.test.populate.ChuBoePopulateVO;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Trx;

public abstract class BaseModelTemplate<T extends PO> {

	protected CLogger LOGGER = CLogger.getCLogger(getClass());

	protected ChuBoePopulateVO valueObject;

	public BaseModelTemplate(ChuBoePopulateVO valueObject) {
		this.valueObject = valueObject;
	}

	public T getInstance() {
		T instance = findInstance();
		if (instance == null) {
			return createInstance();
		} else {
			setFields(instance);
		}

		return instance;
	}

	protected abstract T createInstance();

	protected abstract T findInstance();

	protected abstract void setFields(T instance);

	/**
	 * Commit active transaction
	 */
	protected void commit() {
		try {
			Trx trx = null;
			if (getTransactionName() != null)
				trx = Trx.get(getTransactionName(), false);
			if (trx != null && trx.isActive()) {
				trx.commit(true);
			}
		} catch (Exception ex) {
			LOGGER.severe("Failed Committing Transaction: " + ex.getLocalizedMessage());
		}
	}

	/**
	 * Rollback active transaction
	 */
	protected void rollback() {
		Trx trx = null;
		if (getTransactionName() != null)
			trx = Trx.get(getTransactionName(), false);
		if (trx != null && trx.isActive()) {
			trx.rollback();
		}
	}

	/**
	 * Close active transaction
	 */
	protected void close() {
		Trx trx = null;
		if (getTransactionName() != null)
			trx = Trx.get(getTransactionName(), false);
		if (trx != null) {
			trx.close();
		}
	}
}
