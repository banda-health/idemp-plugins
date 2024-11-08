package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.compiere.model.X_C_ChargeType_DocType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_ChargeType_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ChargeType_DocTypeResolver extends POResolver<X_C_ChargeType_DocType> implements GraphQLResolver<X_C_ChargeType_DocType> {



	/**
	 * Get Charge Type.
	 *
	 * @return Charge Type
	 */
	public CompletableFuture<MChargeType_BH> C_ChargeType(X_C_ChargeType_DocType entity, DataFetchingEnvironment environment) {
		if (entity.getC_ChargeType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MChargeType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeTypeDataLoader.DATALOADER_C_ChargeType_BY_ID);
		return dataLoader.load(entity.getC_ChargeType_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(X_C_ChargeType_DocType entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}

	public Boolean IsAllowNegative(X_C_ChargeType_DocType entity, DataFetchingEnvironment environment) {
		return entity.isAllowNegative();
	}

	public Boolean IsAllowPositive(X_C_ChargeType_DocType entity, DataFetchingEnvironment environment) {
		return entity.isAllowPositive();
	}

}
