CREATE TABLE bbl.user_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    date_of_birth VARCHAR(50)
);