export function toCamelCase(str: string) {
	return str
		.replace(/[^a-z ]/gi, '')
		.replace(/(?:^\w|[A-Z]|\b\w)/g, (ltr, idx) => (idx === 0 ? ltr.toLowerCase() : ltr.toUpperCase()))
		.replace(/\s+/g, '');
}
