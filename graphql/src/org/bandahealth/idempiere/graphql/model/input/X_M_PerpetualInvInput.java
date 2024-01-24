package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_PerpetualInv;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for M_PerpetualInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PerpetualInvInput extends X_M_PerpetualInv implements I_M_PerpetualInvInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Product_Category;
	private ForeignEntityInput mM_Warehouse;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_PerpetualInvInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_PerpetualInv(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Date last run.
	 *
	 * @param DateLastRun Date the process was last run.
	 */

	public void setDateLastRun(Timestamp DateLastRun) {
		if (get_ID() == 0) {
			super.setDateLastRun(DateLastRun);
		}
	}
	/**
	 * Set Date next run.
	 *
	 * @param DateNextRun Date the process will run next
	 */

	public void setDateNextRun(Timestamp DateNextRun) {
		if (get_ID() == 0) {
			super.setDateNextRun(DateNextRun);
		}
	}
	/**
	 * Set Perpetual Inventory.
	 *
	 * @param M_PerpetualInv_ID Rules for generating physical inventory
	 */

	public void setM_PerpetualInv_ID(int M_PerpetualInv_ID) {
		if (get_ID() == 0) {
			super.setM_PerpetualInv_ID(M_PerpetualInv_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_PerpetualInv_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_PerpetualInv_UU();
	}

	/**
	 * Set Product Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category) {
		this.mM_Product_Category = M_Product_Category;
		MProductCategory_BH foreignEntity;
		if (M_Product_Category != null &&
				(foreignEntity = new Query(getCtx(), "M_Product_Category", "M_Product_Category_UU=?", get_TrxName())
						.setParameters(M_Product_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_Category_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_Category_ID(0);
		}
	}

	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public ForeignEntityInput M_Product_Category() {
		return mM_Product_Category;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			super.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public ForeignEntityInput M_Warehouse() {
		return mM_Warehouse;
	}
}
