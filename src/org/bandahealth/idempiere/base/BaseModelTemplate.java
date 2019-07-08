package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Trx;

public abstract class BaseModelTemplate<T extends PO> {

	protected CLogger LOGGER = CLogger.getCLogger(getClass());

	private Properties context;
	private String transactionName;

	public BaseModelTemplate() {
	}

	public BaseModelTemplate(String transactionName, Properties context) {
		this.transactionName = transactionName;
		this.context = context;
	}

	public T getInstance() {
		T instance = findInstance();
		if (instance == null) {
			return createInstance();
		}

		return instance;
	}

	protected abstract T createInstance();

	protected abstract T findInstance();

	protected String getTransactionName() {
		return this.transactionName;
	}

	protected Properties getContext() {
		return this.context;
	}

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
