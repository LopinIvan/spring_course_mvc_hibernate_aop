package com.lopinivan.spring.mvc_hibernate_aop.dao;

import com.lopinivan.spring.mvc_hibernate_aop.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("SELECT e FROM Employee " +
                        "e JOIN FETCH e.empDetails ORDER BY e.id"
                , Employee.class).getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();

        session.merge(employee);

    }

    @Override
    public Employee getEmployeeById(int id) {

        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {

        // Здесь описаны два метода для удаления через Query(HQL),
        // и через CriteriaDelete (Criteria API).
        // С точки зрения современности и типобезопасности,
        // Criteria API считается более предпочтительным подходом,
        // особенно для сложных операций и долгосрочных проектов.
        // ОБА МЕТОДА ПРЕКРАСНО РАБОТАЮТ,,,ПОКА ЧТО XD =)
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

//        // Сначала удаляем связанные записи EmpDetails
//        CriteriaDelete<EmpDetails> empDetailsDelete = criteriaBuilder.createCriteriaDelete(EmpDetails.class);
//        Root<EmpDetails> empDetailsRoot = empDetailsDelete.from(EmpDetails.class);
//        empDetailsDelete.where(criteriaBuilder.equal(empDetailsRoot.get("employee").get("id"), id));
//        session.createQuery(empDetailsDelete).executeUpdate();

        // Теперь удаляем запись Employee
        CriteriaDelete<Employee> employeeDelete = criteriaBuilder.createCriteriaDelete(Employee.class);
        Root<Employee> employeeRoot = employeeDelete.from(Employee.class);
        employeeDelete.where(criteriaBuilder.equal(employeeRoot.get("id"), id));
        session.createQuery(employeeDelete).executeUpdate();

//        // Второй метод удаления
//        Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

    }
}
