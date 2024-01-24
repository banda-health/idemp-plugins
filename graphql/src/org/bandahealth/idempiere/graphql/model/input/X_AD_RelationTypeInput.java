package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_RelationType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_RelationType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_RelationTypeInput extends X_AD_RelationType implements I_AD_RelationTypeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference_Source;
	private ForeignEntityInput mAD_Reference_Target;
	private I_AD_Ref_ListInput mRole_Source;
	private I_AD_Ref_ListInput mRole_Target;
	private I_AD_Ref_ListInput mType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_RelationType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_RelationTypeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_RelationType(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Source Reference.
	 *
	 * @param AD_Reference_Source Source Reference
	 */
	@JsonProperty("AD_Reference_Source")
	public void setAD_Reference_SourceInput(ForeignEntityInput AD_Reference_Source) {
		this.mAD_Reference_Source = AD_Reference_Source;
		MReference_BH foreignEntity;
		if (AD_Reference_Source != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference_Source.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Reference_Source_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UUID " + AD_Reference_Source.getUUID());
			}
		} else {
			super.setAD_Reference_Source_ID(0);
		}
	}

	/**
	 * Get Source Reference.
	 *
	 * @return Source Reference
	 */
	@JsonProperty("AD_Reference_Source")
	public ForeignEntityInput AD_Reference_Source() {
		return mAD_Reference_Source;
	}

	/**
	 * Set Target Reference.
	 *
	 * @param AD_Reference_Target Target Reference
	 */
	@JsonProperty("AD_Reference_Target")
	public void setAD_Reference_TargetInput(ForeignEntityInput AD_Reference_Target) {
		this.mAD_Reference_Target = AD_Reference_Target;
		MReference_BH foreignEntity;
		if (AD_Reference_Target != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference_Target.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Reference_Target_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UUID " + AD_Reference_Target.getUUID());
			}
		} else {
			super.setAD_Reference_Target_ID(0);
		}
	}

	/**
	 * Get Target Reference.
	 *
	 * @return Target Reference
	 */
	@JsonProperty("AD_Reference_Target")
	public ForeignEntityInput AD_Reference_Target() {
		return mAD_Reference_Target;
	}
	/**
	 * Set Relation Type.
	 *
	 * @param AD_RelationType_ID Relation Type
	 */

	public void setAD_RelationType_ID(int AD_RelationType_ID) {
		if (get_ID() == 0) {
			super.setAD_RelationType_ID(AD_RelationType_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_RelationType_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_RelationType_UU();
	}

	/**
	 * Set Source Role.
	 *
	 * @param Role_Source If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	@JsonProperty("Role_Source")
	public void setRole_SourceInput(I_AD_Ref_ListInput Role_Source) {
		this.mRole_Source = Role_Source;
		MRefList_BH foreignEntity;
		if (Role_Source != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Role_Source.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRole_Source(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Role_Source.getUUID());
			}
		} else {
			this.setRole_Source(null);
		}
	}

	/**
	 * Get Source Role.
	 *
	 * @return If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	@JsonProperty("Role_Source")
	public I_AD_Ref_ListInput Role_Source() {
		return mRole_Source;
	}

	/**
	 * Set Target Role.
	 *
	 * @param Role_Target If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	@JsonProperty("Role_Target")
	public void setRole_TargetInput(I_AD_Ref_ListInput Role_Target) {
		this.mRole_Target = Role_Target;
		MRefList_BH foreignEntity;
		if (Role_Target != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Role_Target.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRole_Target(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Role_Target.getUUID());
			}
		} else {
			this.setRole_Target(null);
		}
	}

	/**
	 * Get Target Role.
	 *
	 * @return If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	@JsonProperty("Role_Target")
	public I_AD_Ref_ListInput Role_Target() {
		return mRole_Target;
	}

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public void setTypeInput(I_AD_Ref_ListInput Type) {
		this.mType = Type;
		MRefList_BH foreignEntity;
		if (Type != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Type.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Type.getUUID());
			}
		} else {
			this.setType(null);
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public I_AD_Ref_ListInput Type() {
		return mType;
	}
}
