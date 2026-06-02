package org.bandahealth.idempiere.graphql.utils;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.compiere.model.MUser;
import org.compiere.model.PO;

import java.util.Properties;

public final class FeatureFlagMutationAuthorization {

	private FeatureFlagMutationAuthorization() {
	}

	public static void ensureSystemAdministrator(DataFetchingEnvironment environment) {
		Properties ctx = BandaGraphQLContext.getCtx(environment);
		MUser currentUser = MUser_BH.get(ctx);
		if (currentUser == null || !currentUser.isAdministrator()) {
			throw new AdempiereException("Forbidden");
		}
	}

	public static void runAsSystemAdministrator(DataFetchingEnvironment environment, Runnable action) {
		ensureSystemAdministrator(environment);
		PO.setCrossTenantSafe();
		try {
			action.run();
		} finally {
			PO.clearCrossTenantSafe();
		}
	}
}
