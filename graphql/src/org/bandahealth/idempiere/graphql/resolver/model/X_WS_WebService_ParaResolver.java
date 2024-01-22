package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_WS_WebServiceTypeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_WS_WebServiceType;
import org.compiere.model.X_WS_WebService_Para;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for WS_WebService_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebService_ParaResolver extends POResolver<X_WS_WebService_Para> implements GraphQLResolver<X_WS_WebService_Para> {


	static Map<String, String> PARAMETERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "4faecb14-90aa-4546-97bb-750e2b92a981");
			put("F", "a06cad2b-3c86-4add-8093-4478a8b55cb2");
		}
	};
	public CompletableFuture<MRefList_BH> ParameterType(X_WS_WebService_Para entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getParameterType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(PARAMETERTYPE_UUIDS_BY_VALUE.get(entity.getParameterType()));
	}


	/**
	 * Get Web Service Type.
	 *
	 * @return Web Service Type
	 */
	public CompletableFuture<X_WS_WebServiceType> WS_WebServiceType(X_WS_WebService_Para entity, DataFetchingEnvironment environment) {
		if (entity.getWS_WebServiceType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_WS_WebServiceType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_WS_WebServiceTypeDataLoader.DATALOADER_WS_WebServiceType_BY_ID);
		return dataLoader.load(entity.getWS_WebServiceType_ID());
	}

}
