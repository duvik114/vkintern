CREATE TABLE accounts (
                          id SERIAL PRIMARY KEY,
                          username VARCHAR(255) UNIQUE NOT NULL,
                          password VARCHAR(255) NOT NULL
);

CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE account_roles (
                               account_id INT NOT NULL,
                               role_id INT NOT NULL,
                               CONSTRAINT fk_account
                                   FOREIGN KEY(account_id)
                                       REFERENCES accounts(id),
                               CONSTRAINT fk_role
                                   FOREIGN KEY(role_id)
                                       REFERENCES roles(id),
                               PRIMARY KEY (account_id, role_id)
);

CREATE TABLE audit_log (
                           id SERIAL PRIMARY KEY,
                           username VARCHAR(255) NOT NULL,
                           action VARCHAR(255) NOT NULL,
                           timestamp TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                           details TEXT
);