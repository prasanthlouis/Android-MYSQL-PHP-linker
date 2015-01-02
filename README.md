Android-MYSQL-PHP-linker
========================

My experiments with PHP used to perform CRUD operations on a MYSQL database, incorporated with Android.

I'm hosting my database on localhost using WAMP.

In order for the application to work, you'll need to set up a database using phpmyadmin

Follow the structure below:

CREATE TABLE products(
pid int(11) primary key auto_increment,
name varchar(100),
price decimal(10,2),
description text,
);


The autoincrement is a must, as it's used as a hashmap in the android implementation.

The android app provides privacy to only add and read to the database. 

You can view all entries and modify them using the phpmyadmin on your localhost.

Modify all the php files provided here accordingly, which means path, variable names, etc.
