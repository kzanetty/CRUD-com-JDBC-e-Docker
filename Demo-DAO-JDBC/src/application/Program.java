package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
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



    }
}
