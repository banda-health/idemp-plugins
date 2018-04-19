package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MExpenseType;
import org.compiere.model.MProduct;
import org.compiere.model.MResource;
import org.compiere.model.MResourceType;
import org.compiere.model.X_I_Product;

public class MProduct_BH extends MProduct {

	private static final long serialVersionUID = 1L;

	public static String COLUMNNAME_BH_HAS_EXPIRATION = "BH_HasExpiration";

	public MProduct_BH(MExpenseType et) {
		super(et);
	}

	public MProduct_BH(MResource resource, MResourceType resourceType) {
		super(resource, resourceType);
	}

	public MProduct_BH(Properties ctx, int M_Product_ID, String trxName) {
		super(ctx, M_Product_ID, trxName);
	}

	public MProduct_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MProduct_BH(X_I_Product impP) {
		super(impP);
	}

	public boolean hasExpiration() {
		Boolean hasExpiration = (Boolean) get_Value(COLUMNNAME_BH_HAS_EXPIRATION);
		if (hasExpiration == null) {
			return false;
		}
		return hasExpiration.booleanValue();
	}

	public void setHasExpiration(boolean columnnameBhHasExpiration) {
		set_Value(COLUMNNAME_BH_HAS_EXPIRATION, Boolean.valueOf(columnnameBhHasExpiration));
	}

}
