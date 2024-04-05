package pres;

import Dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("config.txt"));
        String daoClassName= sc.nextLine();
        Class cDao = Class.forName(daoClassName);
        cDao.newInstance();
        IDao dao =(IDao) cDao.newInstance();


        String metierClassName =sc.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();

        Method method= cMetier.getMethod("setDao", IDao.class);
        //metier.setDao(dao);
        method.invoke(metier,dao);


        System.out.println("resultat " +metier.calcul());


    }
}
