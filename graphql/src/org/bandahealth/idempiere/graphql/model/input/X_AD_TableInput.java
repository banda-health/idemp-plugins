package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_TableResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.MValRule;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_TableInput extends MTable implements I_AD_TableInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Val_Rule;
	private ForeignEntityInput mAD_Window;
	private ForeignEntityInput mAccessLevel;
	private ForeignEntityInput mPO_Window;
	private ForeignEntityInput mReplicationType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Table_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_TableInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Data Access Level.
	 *
	 * @param AccessLevel Access Level required
	 */
	@JsonProperty("AccessLevel")
	public void setAccessLevelInput(ForeignEntityInput AccessLevel) {
		this.mAccessLevel = AccessLevel;
		if (AccessLevel != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_TableResolver.ACCESSLEVEL_UUIDS_BY_VALUE.containsValue(AccessLevel.getUU())) {
				throw new AdempiereException("The reference list UU of " + AccessLevel.getUU() +
						" is not in the list defined for the AccessLevel column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccessLevel.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccessLevel(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AccessLevel.getUU());
			}
		} else {
			this.setAccessLevel(null);
		}
	}

	/**
	 * Get Data Access Level.
	 *
	 * @return Access Level required
	 */
	@JsonProperty("AccessLevel")
	public ForeignEntityInput AccessLevel() {
		return mAccessLevel;
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
	 * Set Table.
	 *
	 * @param AD_Table_ID Database Table information
	 */
	@JsonProperty("AD_Table_ID")
	public void setAD_Table_IDFromJson(int AD_Table_ID) {
		if (get_ID() == 0) {
			super.setAD_Table_ID(AD_Table_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Table_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Table_UU();
	}

	/**
	 * Set Dynamic Validation.
	 *
	 * @param AD_Val_Rule Dynamic Validation Rule
	 */
	@JsonProperty("AD_Val_Rule")
	public void setAD_Val_RuleInput(ForeignEntityInput AD_Val_Rule) {
		this.mAD_Val_Rule = AD_Val_Rule;
		if (AD_Val_Rule != null) {
			// Since an entity was passed, make sure it's in the DB
			MValRule foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Val_Rule", "AD_Val_Rule_UU=?", get_TrxName())
							.setParameters(AD_Val_Rule.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Val_Rule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Val_Rule with UU " + AD_Val_Rule.getUU());
			}
		} else {
			this.setAD_Val_Rule_ID(0);
		}
	}

	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	@JsonProperty("AD_Val_Rule")
	public ForeignEntityInput AD_Val_Rule() {
		return mAD_Val_Rule;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(ForeignEntityInput AD_Window) {
		this.mAD_Window = AD_Window;
		if (AD_Window != null) {
			// Since an entity was passed, make sure it's in the DB
			MWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
							.setParameters(AD_Window.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Window_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Window with UU " + AD_Window.getUU());
			}
		} else {
			this.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public ForeignEntityInput AD_Window() {
		return mAD_Window;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UU " + AD_EntityType.getUU());
			}
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}
	/**
	 * Set Sequence.
	 *
	 * @param LoadSeq Sequence
	 */
	@JsonProperty("LoadSeq")
	public void setLoadSeqFromJson(int LoadSeq) {
		if (get_ID() == 0) {
			super.setLoadSeq(LoadSeq);
		}
	}

	/**
	 * Set PO Window.
	 *
	 * @param PO_Window Purchase Order Window
	 */
	@JsonProperty("PO_Window")
	public void setPO_WindowInput(ForeignEntityInput PO_Window) {
		this.mPO_Window = PO_Window;
		if (PO_Window != null) {
			// Since an entity was passed, make sure it's in the DB
			MWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
							.setParameters(PO_Window.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPO_Window_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Window with UU " + PO_Window.getUU());
			}
		} else {
			this.setPO_Window_ID(0);
		}
	}

	/**
	 * Get PO Window.
	 *
	 * @return Purchase Order Window
	 */
	@JsonProperty("PO_Window")
	public ForeignEntityInput PO_Window() {
		return mPO_Window;
	}

	/**
	 * Set Replication Type.
	 *
	 * @param ReplicationType Type of Data Replication
	 */
	@JsonProperty("ReplicationType")
	public void setReplicationTypeInput(ForeignEntityInput ReplicationType) {
		this.mReplicationType = ReplicationType;
		if (ReplicationType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_TableResolver.REPLICATIONTYPE_UUIDS_BY_VALUE.containsValue(ReplicationType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ReplicationType.getUU() +
						" is not in the list defined for the ReplicationType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ReplicationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setReplicationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ReplicationType.getUU());
			}
		} else {
			this.setReplicationType(null);
		}
	}

	/**
	 * Get Replication Type.
	 *
	 * @return Type of Data Replication
	 */
	@JsonProperty("ReplicationType")
	public ForeignEntityInput ReplicationType() {
		return mReplicationType;
	}
}
