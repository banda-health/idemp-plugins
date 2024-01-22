package org.bandahealth.idempiere.graphql.resolver.model;

import org.compiere.model.X_WS_WebServiceType;

/*
 * This class can be removed once we upgrade to iDempiere 8.2
 */

public class MWebServiceTypeResolver extends X_WS_WebServiceTypeResolver {

    /** Column name InsertParameters */
    public static final String COLUMNNAME_InsertParameters = "InsertParameters";

	public MWebServiceTypeResolver() {
		// TODO Auto-generated constructor stub
	}

	public String InsertParameters(X_WS_WebServiceType entity) {
		return (String) entity.get_Value(COLUMNNAME_InsertParameters);
	}
}
