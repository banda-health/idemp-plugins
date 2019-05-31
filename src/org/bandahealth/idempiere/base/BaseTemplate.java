package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Trx;

public abstract class BaseTemplate<T extends PO> {

	protected CLogger LOGGER = CLogger.getCLogger(getClass());

	protected abstract String getTrxName();

	protected abstract Properties getCtx();

	public abstract T getInstance(int... args);

	/**
	 * Commit active transaction
	 */
	protected void commit() {
		try {
			Trx trx = null;
			if (getTrxName() != null)
				trx = Trx.get(getTrxName(), false);
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
		if (getTrxName() != null)
			trx = Trx.get(getTrxName(), false);
		if (trx != null && trx.isActive()) {
			trx.rollback();
		}
	}

	/**
	 * Close active transaction
	 */
	protected void close() {
		Trx trx = null;
		if (getTrxName() != null)
			trx = Trx.get(getTrxName(), false);
		if (trx != null) {
			trx.close();
		}
	}
}
