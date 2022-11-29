package org.bandahealth.idempiere.base.callback;

import java.util.Properties;

public interface ProcessCallback<T> {

	public void onSuccess(Properties context, String transactionName);
	
	public void onError(T result, Properties context, String transactionName);

}
