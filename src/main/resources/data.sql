INSERT INTO users VALUES (1,'david@email.com', 'David', 'Cooper', 500);
INSERT INTO users VALUES (2,'anav@email.com', 'Anna', 'Vasilevich', 350);
INSERT INTO users VALUES (3,'elliot@email.com', 'Eliot', 'Rice', 500);
INSERT INTO users VALUES (4,'ironman@email.com', 'Tony', 'Stark', 700);
INSERT INTO users VALUES (5,'nemesis@email.com', 'Clair', 'Redfield', 500);

INSERT INTO payment_methods (user_id, payment_name) VALUES (1, 'My bank account');
INSERT INTO payment_methods (user_id, payment_name) VALUES (1, 'My mom account');
INSERT INTO payment_methods (user_id, payment_name) VALUES (2, 'Work account');
INSERT INTO payment_methods (user_id, payment_name) VALUES (3, 'My bank account');
INSERT INTO payment_methods (user_id, payment_name) VALUES (3, 'Secret account');
