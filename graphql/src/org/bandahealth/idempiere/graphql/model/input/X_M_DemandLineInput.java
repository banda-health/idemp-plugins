package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.model.X_M_Demand;
import org.compiere.model.X_M_DemandLine;

import java.sql.ResultSet;

/**
 * Generated Model for M_DemandLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DemandLineInput extends X_M_DemandLine implements I_M_DemandLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Period;
	private ForeignEntityInput mM_Demand;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_DemandLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_DemandLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		MPeriod foreignEntity;
		if (get_ID() == 0 && C_Period != null &&
				(foreignEntity = new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
						.setParameters(C_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Period_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public ForeignEntityInput C_Period() {
		return mC_Period;
	}

	/**
	 * Set Demand.
	 *
	 * @param M_Demand Material Demand
	 */
	@JsonProperty("M_Demand")
	public void setM_DemandInput(ForeignEntityInput M_Demand) {
		this.mM_Demand = M_Demand;
		X_M_Demand foreignEntity;
		if (get_ID() == 0 && M_Demand != null &&
				(foreignEntity = new Query(getCtx(), "M_Demand", "M_Demand_UU=?", get_TrxName())
						.setParameters(M_Demand.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Demand_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Demand.
	 *
	 * @return Material Demand
	 */
	@JsonProperty("M_Demand")
	public ForeignEntityInput M_Demand() {
		return mM_Demand;
	}
	/**
	 * Set Demand Line.
	 *
	 * @param M_DemandLine_ID Material Demand Line
	 */

	public void setM_DemandLine_ID(int M_DemandLine_ID) {
		if (get_ID() == 0) {
			super.setM_DemandLine_ID(M_DemandLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_DemandLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_DemandLine_UU();
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 && M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}
}
