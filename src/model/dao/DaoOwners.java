package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DataSource;
import model.Owners;
import model.container.List;

public class DaoOwners extends Dao<Owners>
{

	public DaoOwners()
	{
		 super(DataSource.getInstance());
	}
	
	 @Override
	    public List<Owners> read() 
	    {
	        DataSource        dataSource =  DataSource.getInstance();
	        Owners             data       = new Owners();
	        ResultSet          resultSet  = dataSource.runQuery(data.read());
	        List<Owners> personList = new List<Owners>();
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
	    public Owners findByPlaca(Dto data) 
	    {
	    	 DataSource dataSource =  DataSource.getInstance();
	        ResultSet  resultSet  = dataSource.runQuery(data.findByPlaca());
	        Owners   person     = null;
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

	    private Owners getData(ResultSet resultSet) throws SQLException 
	    {
	        return new Owners(resultSet.getInt("cedula"),   // resultSet.getString(1)
	                resultSet.getString("nombre"),                //resultSet.getString(2)
	                resultSet.getString("apellido"),            //resultSet.getInt(3)
	                resultSet.getInt("telefono"),     //resultSet.getString(4)
	                resultSet.getString("email"));             //resultSet.getInt(9)
	    }
}
