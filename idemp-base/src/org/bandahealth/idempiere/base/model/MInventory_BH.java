package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MWarehouse;

public class MInventory_BH extends org.compiere.model.MInventory {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7140493467408459522L;
	private Integer updateReasonId;

	public MInventory_BH(Properties ctx, int M_Inventory_ID, String trxName) {
		super(ctx, M_Inventory_ID, trxName);
	}

	public MInventory_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MInventory_BH(MWarehouse wh, String trxName) {
		super(wh, trxName);
	}

	public Integer getUpdateReasonId() {
		return updateReasonId;
	}

	public void setUpdateReasonId(Integer updateReasonId) {
		this.updateReasonId = updateReasonId;
	}
	
}
