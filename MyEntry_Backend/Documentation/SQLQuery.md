# SQL Query to start :

## Authentation and Authorizations:

- For Session Management we have three Schemas :
        Users- UserDetails
        Role - Role Descriptions
        User-Role Mapping DB with the Foriegn keys
        
        
        create table test.role (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=MyISAM;
        create table test.user (id bigint not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=MyISAM;
        create table test.user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM;
        alter table test.user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id);
        alter table test.user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id);
        
        
        INSERT INTO test.role (id, description, name) VALUES (4, 'Admin role', 'ADMIN');
        INSERT INTO test.role (id, description, name) VALUES (5, 'User role', 'USER');

        INSERT INTO test.user_roles (user_id, role_id) VALUES (1, 4);
        INSERT INTO test.user_roles (user_id, role_id) VALUES (2, 5);
        
        
-NOTE: While running the Project change in application.properties : spring.jpa.hibernate.ddl-auto = create