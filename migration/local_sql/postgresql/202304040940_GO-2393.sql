-- Create the expired-stock-cleaning process

-- Add the process to the correct roles

-- Ensure the base clean process is available to the correct roles

SELECT
	register_migration_script('202304040940_GO-2393.sql')
FROM
	dual;
