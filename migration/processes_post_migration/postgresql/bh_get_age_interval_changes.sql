DROP FUNCTION IF EXISTS bh_get_age_interval_changes(timestamptz, timestamptz);
CREATE FUNCTION bh_get_age_interval_changes(_start_date timestamptz, _end_date timestamptz DEFAULT NOW())
	RETURNS table
	        (
		        years  numeric,
		        months numeric,
		        days   numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	EXTRACT(YEAR FROM AGE(_end_date, _start_date))                                                        AS years,
	EXTRACT(YEAR FROM AGE(_end_date, _start_date)) * 12 + EXTRACT(MONTH FROM AGE(_end_date, _start_date)) AS months,
	EXTRACT(DAY FROM _end_date - _start_date)                                                             AS days
$$;
