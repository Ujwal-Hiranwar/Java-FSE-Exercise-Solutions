DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN from_account_id INT,
    IN to_account_id INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    DECLARE from_balance DECIMAL(10,2);

    -- check if the amount is positive
    IF amount <= 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Transfer amount must be greater than zero';
    END IF;

    -- check if source account exists and fetch its balance
    SELECT Balance INTO from_balance
    FROM Accounts
    WHERE AccountID = from_account_id;

    -- if source account has insufficient balance, throw an error
    IF from_balance < amount THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Insufficient balance in source account';
    END IF;

    -- deduct amount from source account
    UPDATE Accounts
    SET Balance = Balance - amount
    WHERE AccountID = from_account_id;

    -- add amount to destination account
    UPDATE Accounts
    SET Balance = Balance + amount
    WHERE AccountID = to_account_id;
END;
//

DELIMITER ;
