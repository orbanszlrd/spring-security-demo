insert into users (username, password, enabled) values ('owner', '$2a$10$NWTmSQ7coMixXDIdiiuzvehnris9nyuOlIKuAtTebTFSpcCoRsENy', true);
insert into users (username, password, enabled) values ('admin', '$2a$10$Q5eZmoPv/S1/Dg3lPw8QBuxuTq1a5QInfDl.g9AQPP/qDUQziVqEK', true);
insert into users (username, password, enabled) values ('user', '$2a$10$U5ot/8aRaQ1cTGuKcuNzbuRpskNegsexTMbfinkCGqeMK4gx/C9Ti', true);

insert into authorities (username, authority) values ('owner', 'ROLE_OWNER');
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('user', 'ROLE_USER');

