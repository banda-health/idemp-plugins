package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MExpenseType;
import org.compiere.model.MProduct;
import org.compiere.model.MResource;
import org.compiere.model.MResourceType;
import org.compiere.model.X_I_Product;

public class MProduct_BH extends MProduct {

	/**
	 * Column name BH_HasExpiration
	 */
	public static final String COLUMNNAME_BH_HasExpiration = "BH_HasExpiration";

	public MProduct_BH(Properties ctx, int M_Product_ID, String trxName) {
		super(ctx, M_Product_ID, trxName);
	}

	public MProduct_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MProduct_BH(MExpenseType et) {
		super(et);
	}

	public MProduct_BH(MResource resource, MResourceType resourceType) {
		super(resource, resourceType);
	}

	public MProduct_BH(X_I_Product impP) {
		super(impP);
	}

	/**
	 * Get Has Expiration.
	 *
	 * @return Has Expiration
	 */
	public boolean isBH_HasExpiration() {
		Object oo = get_Value(COLUMNNAME_BH_HasExpiration);
		if (oo != null) {
			if (oo instanceof Boolean) {
				return ((Boolean) oo).booleanValue();
			}
			return "Y".equals(oo);
		}
		return false;
	}

	/**
	 * Set Has Expiration.
	 *
	 * @param BH_HasExpiration Has Expiration
	 */
	public void setBH_HasExpiration(boolean BH_HasExpiration) {
		set_Value(COLUMNNAME_BH_HasExpiration, Boolean.valueOf(BH_HasExpiration));
	}
}
