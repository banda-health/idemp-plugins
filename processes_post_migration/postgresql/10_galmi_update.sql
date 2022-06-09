-- We only want to run this script if it's the Galmi hospital
DO $$
BEGIN
	IF EXISTS (SELECT * FROM ad_client WHERE name = 'Galmi Hospital') THEN
		/**********************************************************************************************************/
		-- Inactivate some payment types that aren't needed
		/**********************************************************************************************************/
		UPDATE ad_ref_list
		SET isactive = 'N'
		WHERE ad_reference_id = 214
			AND Value != 'X';
	END IF;

END $$ language plpgsql;