package view;

import java.util.Arrays;
import controller.DataSource;
import model.Vehicle;
import model.dao.DaoVehicle;

public class Test 
{
	@SuppressWarnings("unused")
	private DataSource data;
	public static void main(String[] args) 
	{
		new Test();
	}
	

	@SuppressWarnings("unchecked")
	public Test()
	{
		data = new DataSource();
		
		java.util.List<Vehicle> personList =  Arrays.asList(
				new Vehicle("HSQ123" ,"Mazda",2005,"Mazda 3","Gris",1,18000000.0,1007473945),
				new Vehicle("ICK443" ,"Nissan",2012,"Sentra","Gris",2,26000000.0,1005912401),
				new Vehicle("SLW782" ,"Toyota",2017,"TXL","Blanco",3,180000000.0,1110466606),
				new Vehicle("OFN754" ,"Chevrolet",2015,"Tracker","Negro",4,40000000.0,65550145));
		
        DaoVehicle personaDao = new DaoVehicle();
        personList.forEach(person -> 
        {
            personaDao.insert(person);
        });
        personList = (java.util.List<Vehicle>) personaDao.read();
        personList.forEach(System.out::println);	
	}

}
