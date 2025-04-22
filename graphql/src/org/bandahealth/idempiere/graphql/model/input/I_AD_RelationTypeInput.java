package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_RelationType;

/**
 * Generated Interface for AD_RelationType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_RelationTypeInput extends I_AD_RelationType {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_Reference_Source.
	 *
	 * @param AD_Reference_Source AD_Reference_Source
	 */
	void setAD_Reference_SourceInput(ForeignEntityInput AD_Reference_Source);

	/**
	 * Get AD_Reference_Source.
	 *
	 * @return AD_Reference_Source
	 */
	ForeignEntityInput AD_Reference_Source();

	/**
	 * Set AD_Reference_Target.
	 *
	 * @param AD_Reference_Target AD_Reference_Target
	 */
	void setAD_Reference_TargetInput(ForeignEntityInput AD_Reference_Target);

	/**
	 * Get AD_Reference_Target.
	 *
	 * @return AD_Reference_Target
	 */
	ForeignEntityInput AD_Reference_Target();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set Role_Source.
	 *
	 * @param Role_Source If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	void setRole_SourceInput(ForeignEntityInput Role_Source);

	/**
	 * Get Role_Source.
	 *
	 * @return If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	ForeignEntityInput Role_Source();

	/**
	 * Set Role_Target.
	 *
	 * @param Role_Target If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	void setRole_TargetInput(ForeignEntityInput Role_Target);

	/**
	 * Get Role_Target.
	 *
	 * @return If set, this role will be used as label for the zoom destination instead of the destinations's window name
	 */
	ForeignEntityInput Role_Target();

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	void setTypeInput(ForeignEntityInput Type);

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	ForeignEntityInput Type();
}
