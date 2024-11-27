/**********************************************************************************************************************/
-- Disable the NHIF insurers
/**********************************************************************************************************************/
UPDATE c_bpartner
SET
	isactive = 'N'
WHERE
	name IN ('NHIF FFS', 'NHIF Fixed FFS', 'NHIF National Scheme')
	AND bh_locked = 'Y';

SELECT
	register_migration_script('202411080925_GO-3120.sql')
FROM
	dual;
