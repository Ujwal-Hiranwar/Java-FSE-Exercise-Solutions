DELIMITER //

CREATE PROCEDURE SendLoanDueReminders()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_loan_id INT;
    DECLARE v_customer_id INT;
    DECLARE v_end_date DATE;
    DECLARE v_customer_name VARCHAR(100);

    -- Cursor to select loans due within next 30 days
    DECLARE cur CURSOR FOR
        SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO v_loan_id, v_customer_id, v_end_date, v_customer_name;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Print reminder message 
        SELECT CONCAT('Reminder: Dear ', v_customer_name, 
                      ', your loan ID ', v_loan_id, 
                      ' is due on ', v_end_date) AS ReminderMessage;
    END LOOP;

    CLOSE cur;
END;
//

DELIMITER ;

CALL SendLoanDueReminders();
