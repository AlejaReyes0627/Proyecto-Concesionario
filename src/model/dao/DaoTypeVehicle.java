package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DataSource;
import model.TypeVehicle;
import model.container.List;

public class DaoTypeVehicle extends Dao<TypeVehicle>
{

	public DaoTypeVehicle()
	{
		super(DataSource.getInstance());
	}


	@Override
	public List<TypeVehicle> read() 
	{
		DataSource        dataSource =  DataSource.getInstance();
		TypeVehicle             data       = new TypeVehicle();
		ResultSet          resultSet  = dataSource.runQuery(data.read());
		List<TypeVehicle> personList = new List<TypeVehicle>();
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
	public TypeVehicle findByPlaca(Dto data) 
	{
		DataSource dataSource =  DataSource.getInstance();
		ResultSet  resultSet  = dataSource.runQuery(data.findByPlaca());
		TypeVehicle    person     = null;
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

	private TypeVehicle getData(ResultSet resultSet) throws SQLException 
	{
		return new TypeVehicle(resultSet.getInt("codigo"),   // resultSet.getString(1)
				resultSet.getString("descripcion"));             //resultSet.getInt(9)
	}
}
