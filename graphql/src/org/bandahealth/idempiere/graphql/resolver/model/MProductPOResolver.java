package org.bandahealth.idempiere.graphql.resolver.model;

import org.compiere.model.MProductPO;

import java.sql.Timestamp;

public class MProductPOResolver extends X_M_Product_POResolver {
	// TODO: Potentially remove this method if it appears on the model at some point (not there now)
	public Timestamp DiscontinuedBy(MProductPO entity) {
		return null;
	}
}
