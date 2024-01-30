package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_EDI;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_EDI - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_EDIInput extends X_C_BP_EDI implements I_C_BP_EDIInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Sequence;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mM_Warehouse;
	private I_AD_Ref_ListInput mEDIType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BP_EDI_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BP_EDIInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (AD_Sequence != null) {
			// Since an entity was passed, make sure it's in the DB
			MSequence_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Sequence", "AD_Sequence_UU=?", get_TrxName())
							.setParameters(AD_Sequence.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Sequence_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Sequence with UUID " + AD_Sequence.getUUID());
			}
		} else {
			this.setAD_Sequence_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_BP_EDI_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
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
		if (EDIType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(EDIType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEDIType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + EDIType.getUUID());
			}
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
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UUID " + M_Warehouse.getUUID());
			}
		} else {
			this.setM_Warehouse_ID(0);
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
