create table bankrecord
(
   id INT AUTO_INCREMENT  PRIMARY KEY,
   bankname varchar(255) not null,
   cardnumber varchar(255) not null,
   expirydate varchar(255) not null 
);