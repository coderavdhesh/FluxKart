CREATE TABLE Contact (
    id INT AUTO_INCREMENT PRIMARY KEY,
    phoneNumber VARCHAR(20),
    email VARCHAR(100),
    linkedId INT,
    linkPrecedence ENUM('PRIMARY', 'SECONDARY'),
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deletedAt TIMESTAMP
);
