package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DataSource;
import model.Defects;
import model.container.List;

public class DaoDefects extends Dao<Defects>
{

	public DaoDefects()
	{
		super(DataSource.getInstance());
	}
	

    @Override
    public List<Defects> read() 
    {
        DataSource        dataSource =  DataSource.getInstance();
        Defects             data       = new Defects();
        ResultSet          resultSet  = dataSource.runQuery(data.read());
        List <Defects> personList = new List<Defects>();
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
    public Defects findByPlaca(Dto data) 
    {
    	 DataSource dataSource =  DataSource.getInstance();
        ResultSet  resultSet  = dataSource.runQuery(data.findByPlaca());
        Defects    person     = null;
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

    private Defects getData(ResultSet resultSet) throws SQLException 
    {
        return new Defects(resultSet.getString("placa"),   // resultSet.getString(1)
                resultSet.getInt("consecutivos"),               //resultSet.getInt(9)
                resultSet.getString("descripcion"));              //resultSet.getString(2)
    }
}
