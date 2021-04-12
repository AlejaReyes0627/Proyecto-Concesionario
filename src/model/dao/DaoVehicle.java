package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DataSource;
import model.Vehicle;
import model.container.List;

public class DaoVehicle extends Dao<Vehicle> 
{

    public  DaoVehicle() 
    {
        super(DataSource.getInstance());
    }

    @Override
    public List<Vehicle> read() 
    {
        DataSource        dataSource =  DataSource.getInstance();
        Vehicle             data       = new Vehicle();
        ResultSet          resultSet  = dataSource.runQuery(data.read());
        List<Vehicle> personList = new List<Vehicle>();
        try 
        {
            while (resultSet.next()) 
            {
                personList.add(getData(resultSet));
            }
        } 
        catch (SQLException throwables) 
        {
            throwables.printStackTrace();
        }
       return personList;
        //return new ArrayList<>(personList)
    }

    @Override
    public Vehicle findByPlaca(Dto data) 
    {
    	 DataSource dataSource =  DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findByPlaca());
        Vehicle    person     = null;
        try 
        {
            while (resultSet.next()) 
            {
                person = getData(resultSet);
            }
        } 
        catch (SQLException throwables) 
        {
            throwables.printStackTrace();
        }
        return person;
    }

    private Vehicle getData(ResultSet resultSet) throws SQLException 
    {
        return new Vehicle(resultSet.getString("placa"),   // resultSet.getString(1)
                resultSet.getString("marca"),                //resultSet.getString(2)
                resultSet.getInt("modelo"),            //resultSet.getInt(3)
                resultSet.getString("linea"),     //resultSet.getString(4)
                resultSet.getString("colorl"),               //resultSet.getString(5)
                resultSet.getInt("tipoDeVehiculo"),					//resultSet.getInt(6)
                resultSet.getDouble("precioMinimo"), 	//resultSet.getDouble(7)
                resultSet.getInt("propietario"));             //resultSet.getInt(9)
    }
}

