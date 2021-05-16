INSERT INTO users VALUES (1,'david@email.com', 'David', 'Cooper', 500);
INSERT INTO users VALUES (2,'anav@email.com', 'Anna', 'Vasilevich', 350);
INSERT INTO users VALUES (3,'elliot@email.com', 'Eliot', 'Rice', 500);
INSERT INTO users VALUES (4,'ironman@email.com', 'Tony', 'Stark', 700);
INSERT INTO users VALUES (5,'nemesis@email.com', 'Clair', 'Redfield', 500);

INSERT INTO account VALUES (10, 2000, 1);
INSERT INTO account VALUES (20, 800, 2);
INSERT INTO account VALUES (30, 1000, 3);
INSERT INTO account VALUES (40, 2500, 4);
INSERT INTO account VALUES (50, 22000, 5);

INSERT INTO payment_methods (user_id, payment_name) VALUES (1, 'My bank account');
INSERT INTO payment_methods (user_id, payment_name) VALUES (1, 'My mom account');
INSERT INTO payment_methods (user_id, payment_name) VALUES (2, 'Work account');
INSERT INTO payment_methods (user_id, payment_name) VALUES (3, 'My bank account');
INSERT INTO payment_methods (user_id, payment_name) VALUES (3, 'Secret account');