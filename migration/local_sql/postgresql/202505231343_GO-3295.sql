-- Update the tags parameters to have more-specific names
UPDATE ad_process_para
SET
	name = 'Patient Tags'
WHERE
	ad_process_para_uu IN ('e4d09b67-0da6-4be5-aca8-23ef940e9acf', '0774a443-616b-4a13-ad0a-ca65dff3ddef',
	                       '11fd71c2-400f-4f09-978d-2deeae6cdb28', '27a5e651-7811-4450-96fb-1df3161b1ebb');

SELECT
	register_migration_script('202505231343_GO-3295.sql')
FROM
	dual;
