package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Package_UUID_Map;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_UUID_Map - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_UUID_MapInput extends X_AD_Package_UUID_Map implements I_AD_Package_UUID_MapInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Package_UUID_Map_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Package_UUID_MapInput(@JsonProperty("UUID") String UUID) {
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
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set UUID Mapping.
	 *
	 * @param AD_Package_UUID_Map_ID UUID Mapping between client
	 */

	public void setAD_Package_UUID_Map_ID(int AD_Package_UUID_Map_ID) {
		if (get_ID() == 0) {
			super.setAD_Package_UUID_Map_ID(AD_Package_UUID_Map_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Package_UUID_Map_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Package_UUID_Map_UU();
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UUID " + AD_Table.getUUID());
			}
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}
	/**
	 * Set Source UUID.
	 *
	 * @param Source_UUID UUID from the source client
	 */

	public void setSource_UUID(String Source_UUID) {
		if (get_ID() == 0) {
			super.setSource_UUID(Source_UUID);
		}
	}
	/**
	 * Set Target UUID.
	 *
	 * @param Target_UUID New UUID created by the pack in client
	 */

	public void setTarget_UUID(String Target_UUID) {
		if (get_ID() == 0) {
			super.setTarget_UUID(Target_UUID);
		}
	}
}
