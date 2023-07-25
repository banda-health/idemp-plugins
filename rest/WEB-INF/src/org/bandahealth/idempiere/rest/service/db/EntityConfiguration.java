package org.bandahealth.idempiere.rest.service.db;

public class EntityConfiguration {

	private boolean shouldUseContextClientId;
	private boolean shouldFetchFromSystemClient;

	public boolean isShouldUseContextClientId() {
		return shouldUseContextClientId;
	}

	public void setShouldUseContextClientId(boolean shouldUseContextClientId) {
		this.shouldUseContextClientId = shouldUseContextClientId;
	}

	public boolean isShouldFetchFromSystemClient() {
		return shouldFetchFromSystemClient;
	}

	public void setShouldFetchFromSystemClient(boolean shouldFetchFromSystemClient) {
		this.shouldFetchFromSystemClient = shouldFetchFromSystemClient;
	}

}
