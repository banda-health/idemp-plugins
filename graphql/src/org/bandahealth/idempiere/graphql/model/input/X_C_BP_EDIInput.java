package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_EDI;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_EDI - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BP_EDIInput extends X_C_BP_EDI implements I_C_BP_EDIInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Sequence;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mM_Warehouse;
	private I_AD_Ref_ListInput mEDIType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_BP_EDIInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_BP_EDI(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Sequence.
	 *
	 * @param AD_Sequence Document Sequence
	 */
	@JsonProperty("AD_Sequence")
	public void setAD_SequenceInput(ForeignEntityInput AD_Sequence) {
		this.mAD_Sequence = AD_Sequence;
		MSequence_BH foreignEntity;
		if (AD_Sequence != null &&
				(foreignEntity = new Query(getCtx(), "AD_Sequence", "AD_Sequence_UU=?", get_TrxName())
						.setParameters(AD_Sequence.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Sequence_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Sequence_ID(0);
		}
	}

	/**
	 * Get Sequence.
	 *
	 * @return Document Sequence
	 */
	@JsonProperty("AD_Sequence")
	public ForeignEntityInput AD_Sequence() {
		return mAD_Sequence;
	}
	/**
	 * Set EDI Definition.
	 *
	 * @param C_BP_EDI_ID Electronic Data Interchange
	 */

	public void setC_BP_EDI_ID(int C_BP_EDI_ID) {
		if (get_ID() == 0) {
			super.setC_BP_EDI_ID(C_BP_EDI_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BP_EDI_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_BP_EDI_UU();
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set EDI Type.
	 *
	 * @param EDIType EDI Type
	 */
	@JsonProperty("EDIType")
	public void setEDITypeInput(I_AD_Ref_ListInput EDIType) {
		this.mEDIType = EDIType;
		MRefList_BH foreignEntity;
		if (EDIType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(EDIType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEDIType(foreignEntity.getValue());
		} else {
			this.setEDIType(null);
		}
	}

	/**
	 * Get EDI Type.
	 *
	 * @return EDI Type
	 */
	@JsonProperty("EDIType")
	public I_AD_Ref_ListInput EDIType() {
		return mEDIType;
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
