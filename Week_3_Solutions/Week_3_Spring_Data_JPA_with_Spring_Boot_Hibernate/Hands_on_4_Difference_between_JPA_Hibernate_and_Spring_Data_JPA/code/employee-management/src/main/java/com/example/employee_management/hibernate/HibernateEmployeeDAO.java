package com.example.employee_management.hibernate;

import com.example.employee_management.model.Employee;
import org.hibernate.*;

public class HibernateEmployeeDAO {
    private static final SessionFactory factory = HibernateUtil.getSessionFactory();

    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return employeeID;
    }
}
