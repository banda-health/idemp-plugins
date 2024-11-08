package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRevenueRecognitionPlan;
import org.compiere.model.Query;
import org.compiere.model.X_C_ServiceLevel;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_ServiceLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ServiceLevelInput extends X_C_ServiceLevel implements I_C_ServiceLevelInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RevenueRecognition_Plan;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_ServiceLevel_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_ServiceLevelInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (get_ID() != 0) {
			return;
		}
		if (C_RevenueRecognition_Plan != null) {
			// Since an entity was passed, make sure it's in the DB
			MRevenueRecognitionPlan foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_RevenueRecognition_Plan", "C_RevenueRecognition_Plan_UU=?", get_TrxName())
							.setParameters(C_RevenueRecognition_Plan.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_RevenueRecognition_Plan_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RevenueRecognition_Plan with UU " + C_RevenueRecognition_Plan.getUU());
			}
		} else {
			this.setC_RevenueRecognition_Plan_ID(0);
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
	@JsonProperty("C_ServiceLevel_ID")
	public void setC_ServiceLevel_IDFromJson(int C_ServiceLevel_ID) {
		if (get_ID() == 0) {
			super.setC_ServiceLevel_ID(C_ServiceLevel_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_ServiceLevel_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (get_ID() != 0) {
			return;
		}
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UU " + M_Product.getUU());
			}
		} else {
			this.setM_Product_ID(0);
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
	@JsonProperty("ServiceLevelInvoiced")
	public void setServiceLevelInvoicedFromJson(BigDecimal ServiceLevelInvoiced) {
		if (get_ID() == 0) {
			super.setServiceLevelInvoiced(ServiceLevelInvoiced);
		}
	}
	/**
	 * Set Quantity Provided.
	 *
	 * @param ServiceLevelProvided Quantity of service or product provided
	 */
	@JsonProperty("ServiceLevelProvided")
	public void setServiceLevelProvidedFromJson(BigDecimal ServiceLevelProvided) {
		if (get_ID() == 0) {
			super.setServiceLevelProvided(ServiceLevelProvided);
		}
	}
}
