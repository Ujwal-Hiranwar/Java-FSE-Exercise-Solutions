DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_account_id INT;
    DECLARE v_balance DECIMAL(10,2);
    
    -- Cursor to select all savings accounts
    DECLARE cur CURSOR FOR
        SELECT AccountID, Balance FROM Accounts
        WHERE AccountType = 'Savings';

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO v_account_id, v_balance;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Update account balance with 1% interest
        UPDATE Accounts
        SET Balance = v_balance + (v_balance * 0.01)
        WHERE AccountID = v_account_id;
    END LOOP;

    CLOSE cur;
END;
//

DELIMITER ;

CALL ProcessMonthlyInterest();