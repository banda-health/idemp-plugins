package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MIndexColumn;
import org.compiere.model.MOrg;
import org.compiere.model.MTableIndex;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_IndexColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_IndexColumnInput extends MIndexColumn implements I_AD_IndexColumnInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_TableIndex;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_IndexColumn_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_IndexColumnInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MIndexColumn(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		MColumn foreignEntity;
		if (AD_Column != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(AD_Column.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UUID " + AD_Column.getUUID());
			}
		} else {
			super.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	@JsonProperty("AD_Column")
	public ForeignEntityInput AD_Column() {
		return mAD_Column;
	}
	/**
	 * Set Table Index Column.
	 *
	 * @param AD_IndexColumn_ID Table Index Column
	 */

	public void setAD_IndexColumn_ID(int AD_IndexColumn_ID) {
		if (get_ID() == 0) {
			super.setAD_IndexColumn_ID(AD_IndexColumn_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_IndexColumn_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_IndexColumn_UU();
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
	 * Set Table Index.
	 *
	 * @param AD_TableIndex Table Index
	 */
	@JsonProperty("AD_TableIndex")
	public void setAD_TableIndexInput(ForeignEntityInput AD_TableIndex) {
		this.mAD_TableIndex = AD_TableIndex;
		MTableIndex foreignEntity;
		if (get_ID() == 0 && AD_TableIndex != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_TableIndex", "AD_TableIndex_UU=?", get_TrxName())
							.setParameters(AD_TableIndex.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_TableIndex_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_TableIndex with UUID " + AD_TableIndex.getUUID());
			}
		}
	}

	/**
	 * Get Table Index.
	 *
	 * @return Table Index
	 */
	@JsonProperty("AD_TableIndex")
	public ForeignEntityInput AD_TableIndex() {
		return mAD_TableIndex;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UUID " + AD_EntityType.getUUID());
			}
		} else {
			super.setEntityType(null);
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
}
