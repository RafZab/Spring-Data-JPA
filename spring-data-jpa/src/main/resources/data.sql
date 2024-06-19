-- Wstawienie danych do tabeli addresses
INSERT INTO addresses (street, city, postal_code, country) VALUES
                                                ('123 Main St', 'Anytown', '12345', 'CountryA'),
                                                ('456 Side St', 'Othertown', '67890', 'CountryB');

-- Wstawienie danych do tabeli contacts
INSERT INTO contacts (email, phone_number) VALUES
                                               ('client1@example.com', '123-456-7890'),
                                               ('client2@example.com', '098-765-4321');

-- Wstawienie danych do tabeli clients
INSERT INTO clients (name, address_id, contact_id) VALUES
                                               ('John Doe', 1, 1),
                                               ('Jane Smith', 2, 2);

-- Wstawienie danych do tabeli payments
INSERT INTO payments (amount, payment_method) VALUES
                                               (100.50, 'Credit Card'),
                                               (200.75, 'PayPal'),
                                               (300.00, 'Bank Transfer'),
                                               (150.00, 'Credit Card'),
                                               (250.00, 'PayPal');

-- Wstawienie danych do tabeli orders
INSERT INTO orders (client_id, payment_id, order_date) VALUES
                                               (1, 1, '2023-06-01'),
                                               (1, 2, '2023-06-02'),
                                               (2, 3, '2023-06-03'),
                                               (2, 4, '2023-06-04'),
                                               (2, 5, '2023-06-05');

