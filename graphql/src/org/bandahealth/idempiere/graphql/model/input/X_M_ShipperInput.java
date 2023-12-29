package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.util.Env;

/**
 * Generated Model for M_Shipper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperInput extends MShipper implements I_M_ShipperInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_BPartnerInput C_BPartner;
	 private I_M_ShipperCfgInput M_ShipperCfg;
	 private I_M_ShippingProcessorInput M_ShippingProcessor;

	/**
	 * Standard constructor
	 */
	public X_M_ShipperInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Shipper_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Shipper_UU();
	}

	/**
	 * Set Shipper Configuration.
	 *
	 * @param M_ShipperCfg Shipper Configuration
	 */
	public void setM_ShipperCfg(I_M_ShipperCfgInput M_ShipperCfg) {
		this.M_ShipperCfg = M_ShipperCfg;
		X_M_ShipperCfg foreignEntity;
		if (M_ShipperCfg != null &&
				(foreignEntity = new Query(getCtx(), X_M_ShipperCfg.Table_Name, X_M_ShipperCfg.COLUMNNAME_M_ShipperCfg_UU + "=?", get_TrxName())
						.setParameters(M_ShipperCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShipperCfg_ID(foreignEntity.get_ID());
		} else {
			this.setM_ShipperCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	public I_M_ShipperCfgInput getM_ShipperCfg() {
		return M_ShipperCfg;
	}

	/**
	 * Set Shipping Processor.
	 *
	 * @param M_ShippingProcessor Shipping Processor
	 */
	public void setM_ShippingProcessor(I_M_ShippingProcessorInput M_ShippingProcessor) {
		this.M_ShippingProcessor = M_ShippingProcessor;
		MShippingProcessor foreignEntity;
		if (M_ShippingProcessor != null &&
				(foreignEntity = new Query(getCtx(), MShippingProcessor.Table_Name, MShippingProcessor.COLUMNNAME_M_ShippingProcessor_UU + "=?", get_TrxName())
						.setParameters(M_ShippingProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShippingProcessor_ID(foreignEntity.get_ID());
		} else {
			this.setM_ShippingProcessor_ID(0);
		}
	}

	/**
	 * Get Shipping Processor.
	 *
	 * @return Shipping Processor
	 */
	public I_M_ShippingProcessorInput getM_ShippingProcessor() {
		return M_ShippingProcessor;
	}
}
