INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_POSTS');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_USERS');
INSERT INTO roles (id, name) VALUES (4, 'ROLE_ALBUMS');

-- Пароль 'admin', зашифрованный с помощью BCrypt
INSERT INTO accounts (id, username, password) VALUES (1, 'admin', '$2a$12$1jK0uj5wc7GkOI.8Vh2Hdea4xAg3dMJEONLVk3JDNQfew6SEtmKPq');
-- Пароль 'posts', зашифрованный с помощью BCrypt
INSERT INTO accounts (id, username, password) VALUES (2, 'posts', '$2a$12$DC5gtGkUNnFsyuua3Z3HnOYiBJjz8VnVidTG/3Gf3cpRialMOS/QW');
-- Пароль 'users', зашифрованный с помощью BCrypt
INSERT INTO accounts (id, username, password) VALUES (3, 'users', '$2a$12$OdW2ZU6mNkwdc1BDmPaMM.T09X297qdP5OSYiX8Uwn2Bq6VNi/Cfe');
-- Пароль 'albums', зашифрованный с помощью BCrypt
INSERT INTO accounts (id, username, password) VALUES (4, 'albums', '$2a$12$aijDlUbVKqRS8IrD4WxyEOpj.f1mtsiDDjYfMm4hPWJtwWsBHGo5i');
-- Пароль 'posts_albums', зашифрованный с помощью BCrypt
INSERT INTO accounts (id, username, password) VALUES (5, 'posts_albums', '$2a$12$ssQxOoIZxmDrXkCGYuqFbeGOygO1ROxEns2c0dhI1SKK5Uo4IDJIe');

INSERT INTO account_roles (account_id, role_id) VALUES (1, 1);
INSERT INTO account_roles (account_id, role_id) VALUES (2, 2);
INSERT INTO account_roles (account_id, role_id) VALUES (3, 3);
INSERT INTO account_roles (account_id, role_id) VALUES (4, 4);
INSERT INTO account_roles (account_id, role_id) VALUES (5, 2);
INSERT INTO account_roles (account_id, role_id) VALUES (5, 4);