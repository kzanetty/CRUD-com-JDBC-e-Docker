package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class ProgramDepartment {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        jumpLine();
        System.out.println("==== FindById ====");
        Department dep = departmentDao.findById(5);
        System.out.println(dep);
        System.out.println("==== ==== ==== ====");

        jumpLine();
        System.out.println("==== FindAll ====");
        List<Department> list = departmentDao.findAll();
        for(Department d: list){
            System.out.println(d);
        }
        System.out.println("==== ==== ==== ====");

        jumpLine();
        System.out.println("==== Update ====");
        Department updateDep = new Department(2, "Eletronics");
        departmentDao.update(updateDep);
        System.out.println("Updated finished.");
        System.out.println("==== ==== ==== ====");

        jumpLine();
        System.out.println("==== Insert ====");
        Department insertDep = new Department(null, "Developer");
        departmentDao.insert(insertDep);
        System.out.println("insert concluded.");
        System.out.println("==== ==== ==== ====");

        jumpLine();
        System.out.println("==== DeleteById ====");
        int x = 6;
        departmentDao.deleteById(x);
        System.out.println("Already deleted.");
        System.out.println("==== ==== ==== ====");
    }
    public static void jumpLine(){
        System.out.println("\n\n");
    }
}
