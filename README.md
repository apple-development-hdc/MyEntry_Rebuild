      
  
<div align="center">
 
![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)
[![Build Status](https://travis-ci.com/anuragsarkar97/msgs.svg?branch=master)](https://travis-ci.com/anuragsarkar97/msgs)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/anuragsarkar97/msgs/graphs/commit-activity)
[![Ask Me Anything !](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)](https://GitHub.com/anuragsarkar97/msgs)
[![GitHub version](https://badge.fury.io/gh/anuragsarkar97%2Fmsgs.svg)](https://github.com/anuragsarkar97/msgs)

</div>

<div align="center">
  
[![ForTheBadge built-with-swag](http://ForTheBadge.com/images/badges/built-with-swag.svg)](https://GitHub.com/anuragsarakr97/)
[![forthebadge](https://forthebadge.com/images/badges/winter-is-coming.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/powered-by-responsibility.svg)](https://forthebadge.com)
</div>

```
Make branch as name/backend.
Write your OWN JUnits if you want to write

Backend Task : 

1. Authentication / Session Management:
-Introducing LDAP to create user groups and authorization -> we will recieve a accessToken from here for each TokenId (unique).
which will be passed to the header of the API.
2. Manage session through eCache-
- eCache will store key pair of tokenId ? : accessToken . This has to be checked for each API call (cache.get(tokenId)->?rule)
- then we have to check the header authorization token 
httpRequest.header("token").equals(eCache.get("token") == true :"200 OK". else "404 error".

TO LOAD FRONTEND :

1. Install Node js , react linreary then go to project dir and "npm install " then "npm start".
```
