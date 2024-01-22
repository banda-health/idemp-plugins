package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRevenueRecognitionPlan;
import org.compiere.model.Query;
import org.compiere.model.X_C_ServiceLevel;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_ServiceLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ServiceLevelInput extends X_C_ServiceLevel implements I_C_ServiceLevelInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RevenueRecognition_Plan;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_ServiceLevelInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_ServiceLevel(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Revenue Recognition Plan.
	 *
	 * @param C_RevenueRecognition_Plan Plan for recognizing or recording revenue
	 */
	@JsonProperty("C_RevenueRecognition_Plan")
	public void setC_RevenueRecognition_PlanInput(ForeignEntityInput C_RevenueRecognition_Plan) {
		this.mC_RevenueRecognition_Plan = C_RevenueRecognition_Plan;
		MRevenueRecognitionPlan foreignEntity;
		if (get_ID() == 0 && C_RevenueRecognition_Plan != null &&
				(foreignEntity = new Query(getCtx(), "C_RevenueRecognition_Plan", "C_RevenueRecognition_Plan_UU=?", get_TrxName())
						.setParameters(C_RevenueRecognition_Plan.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_RevenueRecognition_Plan_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Revenue Recognition Plan.
	 *
	 * @return Plan for recognizing or recording revenue
	 */
	@JsonProperty("C_RevenueRecognition_Plan")
	public ForeignEntityInput C_RevenueRecognition_Plan() {
		return mC_RevenueRecognition_Plan;
	}
	/**
	 * Set Service Level.
	 *
	 * @param C_ServiceLevel_ID Product Revenue Recognition Service Level 
	 */

	public void setC_ServiceLevel_ID(int C_ServiceLevel_ID) {
		if (get_ID() == 0) {
			super.setC_ServiceLevel_ID(C_ServiceLevel_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_ServiceLevel_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_ServiceLevel_UU();
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
	/**
	 * Set Quantity Invoiced.
	 *
	 * @param ServiceLevelInvoiced Quantity of product or service invoiced
	 */

	public void setServiceLevelInvoiced(BigDecimal ServiceLevelInvoiced) {
		if (get_ID() == 0) {
			super.setServiceLevelInvoiced(ServiceLevelInvoiced);
		}
	}
	/**
	 * Set Quantity Provided.
	 *
	 * @param ServiceLevelProvided Quantity of service or product provided
	 */

	public void setServiceLevelProvided(BigDecimal ServiceLevelProvided) {
		if (get_ID() == 0) {
			super.setServiceLevelProvided(ServiceLevelProvided);
		}
	}
}
