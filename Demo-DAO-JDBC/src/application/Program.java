package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== FindById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("==== ==== ==== ====");



        System.out.println("==== FindByDeparment ====");
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
        for(Seller sel: list){
            System.out.println(sel);
        }
        System.out.println("==== ==== ==== ====");



        System.out.println("==== FindAll ====");
        list = sellerDao.findAll();
        for(Seller sel: list){
            System.out.println(sel);
        }
        System.out.println("==== ==== ==== ====");



        System.out.println("==== Insert ====");
        Department dep = new Department(2, null);
        Seller addSeller = new Seller(null, "Vinicius", "Vinicius@gmail.com", new Date(), 4500.32, dep);
        sellerDao.insert(addSeller);
        System.out.println("Finish!");
        System.out.println(addSeller);
        System.out.println("==== ==== ==== ====");



        System.out.println("==== Update ====");
        seller = sellerDao.findById(2);
        seller.setBaseSalary(7000.11);
        seller.setName("MariaDB");
        sellerDao.update(seller);
        System.out.println("Finish update!");
        System.out.println("==== ==== ==== ====");



        System.out.println("==== Delete ====");
        int x = 1;
        sellerDao.deleteById(x);
        System.out.println("Already deleted.");
        System.out.println("==== ==== ==== ====");



    }
}
