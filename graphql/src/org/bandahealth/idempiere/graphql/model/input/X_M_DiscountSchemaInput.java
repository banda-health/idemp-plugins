package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_DiscountSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DiscountSchemaInput extends MDiscountSchema implements I_M_DiscountSchemaInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CumulativeLevel_RL;
	 private I_AD_Ref_ListInput DiscountType_RL;

	/**
	 * Standard constructor
	 */
	public X_M_DiscountSchemaInput(String ID) {
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
	 * Set Accumulation Level.
	 *
	 * @param CumulativeLevel_RL Level for accumulative calculations
	 */
	public void setCumulativeLevel_RL(I_AD_Ref_ListInput CumulativeLevel_RL) {
		this.CumulativeLevel_RL = CumulativeLevel_RL;
		MRefList foreignEntity;
		if (CumulativeLevel_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CumulativeLevel_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCumulativeLevel(foreignEntity.getValue());
		} else {
			this.setCumulativeLevel(null);
		}
	}

	/**
	 * Get Accumulation Level.
	 *
	 * @return Level for accumulative calculations
	 */
	public I_AD_Ref_ListInput getCumulativeLevel_RL() {
		return CumulativeLevel_RL;
	}

	/**
	 * Set Discount Type.
	 *
	 * @param DiscountType_RL Type of trade discount calculation
	 */
	public void setDiscountType_RL(I_AD_Ref_ListInput DiscountType_RL) {
		this.DiscountType_RL = DiscountType_RL;
		MRefList foreignEntity;
		if (DiscountType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DiscountType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDiscountType(foreignEntity.getValue());
		} else {
			this.setDiscountType(null);
		}
	}

	/**
	 * Get Discount Type.
	 *
	 * @return Type of trade discount calculation
	 */
	public I_AD_Ref_ListInput getDiscountType_RL() {
		return DiscountType_RL;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_DiscountSchema_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_DiscountSchema_UU();
	}
}
