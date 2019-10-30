# idemp-rest
Exposes iDempiere services via REST (JSON). 

#USAGE: 
 - Generate session token: http://localhost:8080/BHGO/services/rs/auth/session
 - Every request should pass a session token in the Authorization header (i.e Bearer *token*).
 - REST services should have URLS prefixed with /rs/auth/ e.g http://localhost:8080/BHGO/services/rs/auth/bpartner/create

