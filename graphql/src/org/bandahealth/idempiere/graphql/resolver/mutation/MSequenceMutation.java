package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.util.Env;

import java.util.Properties;

public class MSequenceMutation extends X_AD_SequenceMutation {

	/**
	 * 	Get next Document No for table (when the document doesn't have a c_doctype)
	 *	@return document no or null
	 */
	public String AD_SequenceGetDocumentNumber(String TableName, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		Repository.setCopyOfPropertiesForNestedThreadUsage(idempiereContext);
		return MSequence_BH.getDocumentNo(Env.getAD_Client_ID(idempiereContext), TableName, null);
	}
}
