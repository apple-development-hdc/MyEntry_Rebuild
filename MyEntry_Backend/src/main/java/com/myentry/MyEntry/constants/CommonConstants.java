package com.myentry.MyEntry.constants;

public class CommonConstants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60; //Multiplied by 10000 in Service Level
    public static final String SIGNING_KEY = "myentry";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";
    public static final String LOGIN_DATE = "login_date";
    public static final String LOGOUT_DATE = "LOGIN_DATE";

    public static final String ID = "ID";
    public static final String ACTIVE_IND = "ACTIVE_IND";

    public static final String CREATED_DATE = "CREATED_DATE";
    public static final String CREATED_BY = "CREATED_BY";
    public static final String MODIFIED_DATE = "MODIFIED_DATE";
    public static final String MODIFIED_BY = "MODIFIED_BY";


    // Account Entity
    public static final String ACCOUNT = "ACCOUNT";
    public static final String ACCOUNT_NAME = "ACCOUNT_NAME";
    public static final String SHOW_ACCOUNT = "SHOW_ACCOUNT";

    // Admin Entity
    public static final String ADMIN = "ADMIN";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";

    // Asset Entity
    public static final String ASSET = "ASSET";
    public static final String ASSET_NUMBER = "ASSET_NUMBER";
    public static final String ASSET_TYPE = "ASSET_TYPE";
    public static final String MOVEMENT_ID = "MOVEMENT_ID";

    // Escort entity
    public static final String ESCORT = "ESCORT";
    public static final String EMP_ID = "EMP_ID";
    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String LOCATION = "LOCATION";
    public static final String LOCATION_NAME = "LOCATION_NAME";

    //IT ASSET entity
    public static final String ITASSET = "ITASSET";
    public static final String MOVEMENT_TYPE = "EMP_ID";
    public static final String MOVEMENT_DATE = "FIRST_NAME";
    public static final String IMAGE = "IMAGE";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String NON_ITASSET = "NON_ITASSET";
    public static final String SECURITY = "SECURITY";

    //VISITOR
    public static final String VISITOR = "VISITOR";
    public static final String VISITOR_SEQ = "VISITOR_SEQ";
    public static final String VISITOR_ID = "VISITOR_ID";
    public static final String VISITOR_TYPE = "VISITOR_TYPE";
    public static final String CONTACT_NUMBER = "CONTACT_NUMBER";
    public static final String PURPOSE = "PURPOSE";
    public static final String ESCORT_EMP_ID = "ESCORT_EMP_ID";
    public static final String LAPTOP_SERIAL_NUMBER = "LAPTOP_SERIAL_NUMBER";
    public static final String REMARKS = "REMARKS";
    public static final String IN_TIME = "IN_TIME";
    public static final String OUT_TIME = "OUT_TIME";
    public static final String ODC_LOCATION = "ODC_LOCATION";
    public static final String PROXY = "PROXY";
    public static final String EMPLOYEE_TYPE = "EMPLOYEE_TYPE";
    public static final String STATUS ="STATUS";


    public static final String ADDED = "ADDED";
    public static final String DELETED = "DELETED";

    //Super User
    public static final String SUPER_USER_USERNAME = "MyEntry";
    public static final String SUPER_USER_PASSWORD = "Wipro";

    //Image
    public static final String IMAGE_VALUE = "IMAGE_VALUE";
    public static final String IMAGE_TABLE = "IMAGE_TABLE";
    public static final String IMAGE_ID = "IMAGE_ID";
}
