package org.bandahealth.idempiere.base.model;

import org.compiere.model.MProductPO;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

public class MProductPO_BH extends MProductPO {

	/**
	 * Column name DiscontinuedBy
	 */
	public static final String COLUMNNAME_DiscontinuedBy = "DiscontinuedBy";

	public MProductPO_BH(Properties ctx, int ignored, String trxName) {
		super(ctx, ignored, trxName);
	}

	public MProductPO_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Set Discontinued by.
	 *
	 * @param DiscontinuedBy Discontinued By
	 */
	public void setDiscontinuedBy(Timestamp DiscontinuedBy) {
		set_Value(COLUMNNAME_DiscontinuedBy, DiscontinuedBy);
	}

	/**
	 * Get Discontinued by.
	 *
	 * @return Discontinued By
	 */
	public Timestamp getDiscontinuedBy() {
		return (Timestamp) get_Value(COLUMNNAME_DiscontinuedBy);
	}
}
