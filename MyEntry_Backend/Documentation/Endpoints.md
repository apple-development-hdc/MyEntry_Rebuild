# Endpoints of the Project:

### Authorization Endpoints:
    
    /signup - new user with userdetails
    /authenticate - login the user and provide the Roles to get a token (Bearer) 
    
    Then add @PreAuthorize("hasRole('ADMIN')") OR @PreAuthorize("hasRole('USER')")
    to check the Role and constraints of the API.
    