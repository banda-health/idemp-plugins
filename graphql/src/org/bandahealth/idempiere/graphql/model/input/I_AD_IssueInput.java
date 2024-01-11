package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Issue;

/**
 * Generated Interface for AD_Issue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_IssueInput extends I_AD_Issue {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_AssetInput(ForeignEntityInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	ForeignEntityInput A_Asset();

	/**
	 * Set AD_Form.
	 *
	 * @param AD_Form Special Form
	 */
	void setAD_FormInput(ForeignEntityInput AD_Form);

	/**
	 * Get AD_Form.
	 *
	 * @return Special Form
	 */
	ForeignEntityInput AD_Form();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_Process.
	 *
	 * @param AD_Process Process or Report
	 */
	void setAD_ProcessInput(ForeignEntityInput AD_Process);

	/**
	 * Get AD_Process.
	 *
	 * @return Process or Report
	 */
	ForeignEntityInput AD_Process();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(ForeignEntityInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	ForeignEntityInput AD_Window();

	/**
	 * Set IsReproducible.
	 *
	 * @param IsReproducible Problem can re reproduced in Gardenworld
	 */
	void setIsReproducibleInput(I_AD_Ref_ListInput IsReproducible);

	/**
	 * Get IsReproducible.
	 *
	 * @return Problem can re reproduced in Gardenworld
	 */
	I_AD_Ref_ListInput IsReproducible();

	/**
	 * Set IssueSource.
	 *
	 * @param IssueSource Issue Source
	 */
	void setIssueSourceInput(I_AD_Ref_ListInput IssueSource);

	/**
	 * Get IssueSource.
	 *
	 * @return Issue Source
	 */
	I_AD_Ref_ListInput IssueSource();

	/**
	 * Set IsVanillaSystem.
	 *
	 * @param IsVanillaSystem The system was NOT compiled from Source - i.e. standard distribution
	 */
	void setIsVanillaSystemInput(I_AD_Ref_ListInput IsVanillaSystem);

	/**
	 * Get IsVanillaSystem.
	 *
	 * @return The system was NOT compiled from Source - i.e. standard distribution
	 */
	I_AD_Ref_ListInput IsVanillaSystem();

	/**
	 * Set R_IssueKnown.
	 *
	 * @param R_IssueKnown Known Issue
	 */
	void setR_IssueKnownInput(ForeignEntityInput R_IssueKnown);

	/**
	 * Get R_IssueKnown.
	 *
	 * @return Known Issue
	 */
	ForeignEntityInput R_IssueKnown();

	/**
	 * Set R_IssueProject.
	 *
	 * @param R_IssueProject Implementation Projects
	 */
	void setR_IssueProjectInput(ForeignEntityInput R_IssueProject);

	/**
	 * Get R_IssueProject.
	 *
	 * @return Implementation Projects
	 */
	ForeignEntityInput R_IssueProject();

	/**
	 * Set R_IssueSystem.
	 *
	 * @param R_IssueSystem System creating the issue
	 */
	void setR_IssueSystemInput(ForeignEntityInput R_IssueSystem);

	/**
	 * Get R_IssueSystem.
	 *
	 * @return System creating the issue
	 */
	ForeignEntityInput R_IssueSystem();

	/**
	 * Set R_IssueUser.
	 *
	 * @param R_IssueUser User who reported issues
	 */
	void setR_IssueUserInput(ForeignEntityInput R_IssueUser);

	/**
	 * Get R_IssueUser.
	 *
	 * @return User who reported issues
	 */
	ForeignEntityInput R_IssueUser();

	/**
	 * Set R_Request.
	 *
	 * @param R_Request Request from a Business Partner or Prospect
	 */
	void setR_RequestInput(ForeignEntityInput R_Request);

	/**
	 * Get R_Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	ForeignEntityInput R_Request();

	/**
	 * Set SystemStatus.
	 *
	 * @param SystemStatus Status of the system - Support priority depends on system status
	 */
	void setSystemStatusInput(I_AD_Ref_ListInput SystemStatus);

	/**
	 * Get SystemStatus.
	 *
	 * @return Status of the system - Support priority depends on system status
	 */
	I_AD_Ref_ListInput SystemStatus();
}
