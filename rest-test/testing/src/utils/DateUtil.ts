const dateTimeFormat = new Intl.DateTimeFormat('en', {
	year: 'numeric',
	month: '2-digit',
	day: '2-digit',
	hour: 'numeric',
	minute: 'numeric',
	hour12: true,
});

export function formatDate(date?: Date): string {
	const [{ value: month }, , { value: day }, , { value: year }] = dateTimeFormat.formatToParts(date || new Date());
	return `${year}-${month}-${day}`;
}

export function formatDateAndTime(date?: Date): string {
	const [
		{ value: month },
		,
		{ value: day },
		,
		{ value: year },
		,
		{ value: hour },
		,
		{ value: minute },
		,
		{ value: dayPeriod },
	] = dateTimeFormat.formatToParts(date || new Date());
	return `${year}-${month}-${day} ${hour}:${minute} ${dayPeriod}`;
}
