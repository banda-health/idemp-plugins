package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Shipper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ShipperInput extends MShipper implements I_M_ShipperInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mM_ShipperCfg;
	private ForeignEntityInput mM_ShippingProcessor;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_Shipper_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ShipperInput(@JsonProperty("UU") String UU) {
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
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}
	/**
	 * Set Shipper.
	 *
	 * @param M_Shipper_ID Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper_ID")
	public void setM_Shipper_IDFromJson(int M_Shipper_ID) {
		if (get_ID() == 0) {
			super.setM_Shipper_ID(M_Shipper_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_Shipper_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_Shipper_UU();
	}

	/**
	 * Set Shipper Configuration.
	 *
	 * @param M_ShipperCfg Shipper Configuration
	 */
	@JsonProperty("M_ShipperCfg")
	public void setM_ShipperCfgInput(ForeignEntityInput M_ShipperCfg) {
		this.mM_ShipperCfg = M_ShipperCfg;
		if (M_ShipperCfg != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_ShipperCfg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShipperCfg", "M_ShipperCfg_UU=?", get_TrxName())
							.setParameters(M_ShipperCfg.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_ShipperCfg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShipperCfg with UU " + M_ShipperCfg.getUU());
			}
		} else {
			this.setM_ShipperCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	@JsonProperty("M_ShipperCfg")
	public ForeignEntityInput M_ShipperCfg() {
		return mM_ShipperCfg;
	}

	/**
	 * Set Shipping Processor.
	 *
	 * @param M_ShippingProcessor Shipping Processor
	 */
	@JsonProperty("M_ShippingProcessor")
	public void setM_ShippingProcessorInput(ForeignEntityInput M_ShippingProcessor) {
		this.mM_ShippingProcessor = M_ShippingProcessor;
		if (M_ShippingProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			MShippingProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShippingProcessor", "M_ShippingProcessor_UU=?", get_TrxName())
							.setParameters(M_ShippingProcessor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_ShippingProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShippingProcessor with UU " + M_ShippingProcessor.getUU());
			}
		} else {
			this.setM_ShippingProcessor_ID(0);
		}
	}

	/**
	 * Get Shipping Processor.
	 *
	 * @return Shipping Processor
	 */
	@JsonProperty("M_ShippingProcessor")
	public ForeignEntityInput M_ShippingProcessor() {
		return mM_ShippingProcessor;
	}
}
