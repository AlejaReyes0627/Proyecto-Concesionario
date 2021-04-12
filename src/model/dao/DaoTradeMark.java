package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DataSource;
import model.TradeMark;
import model.container.List;

public class DaoTradeMark extends Dao<TradeMark> 
{

	public DaoTradeMark()
	{
		super(DataSource.getInstance());
	}

	  public List<TradeMark> read() 
	    {
	        DataSource        dataSource =  DataSource.getInstance();
	        TradeMark            data       = new TradeMark();
	        ResultSet          resultSet  = dataSource.runQuery(data.read());
	        List<TradeMark> personList = new List<TradeMark>();
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
	    public TradeMark findByPlaca(Dto data) 
	    {
	    	 DataSource dataSource =  DataSource.getInstance();
	        ResultSet  resultSet  = dataSource.runQuery(data.findByPlaca());
	        TradeMark    person     = null;
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

	    private TradeMark getData(ResultSet resultSet) throws SQLException 
	    {
	        return new TradeMark(resultSet.getString("codigo"),   // resultSet.getString(1)
	                resultSet.getString("nombre"));             //resultSet.getInt(9)
	    }
}
