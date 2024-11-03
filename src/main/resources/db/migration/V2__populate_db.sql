INSERT INTO CLIENT(NAME) VALUES ( 'Igor' ),
                                ('Sergej'),
                                ('Anton'),
                                ('Ivan'),
                                ('Artur'),
                                ('Anna'),
                                ('Vlada'),
                                ('Tania'),
                                ('Ota'),
                                ('Nastia');

INSERT INTO PLANET (ID, NAME) VALUES ( 'MARS','Mars' ),
                                     ('VEN', 'Vennus'),
                                     ('SAT','Saturn'),
                                     ('EAR','Earth'),
                                     ('JUP','Jupiter');

INSERT INTO TICKET (CLIENT_ID, FROM_PLANET_ID, TO_PLANET_ID) VALUES ( 1, 'EAR', 'MARS' ),
                                                                    (2, 'VEN', 'EAR'),
                                                                    (3, 'JUP', 'SAT'),
                                                                    (4, 'EAR', 'VEN'),
                                                                    (5, 'SAT', 'JUP'),
                                                                    (6, 'MARS', 'EAR'),
                                                                    (7, 'EAR', 'MARS'),
                                                                    (8, 'JUP', 'VEN'),
                                                                    (9, 'SAT', 'EAR'),
                                                                    (10, 'MARS', 'VEN');
