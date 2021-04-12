package model;

import java.io.Serializable;

import model.dao.Dto;

public class TypeVehicle implements Dto, Serializable
{
	private static final long serialVersionUID = 1L;

	private int codigo;
	private String descripcion;


	public TypeVehicle() 
	{

	}

	public TypeVehicle(int codigo, String descripcion) 
	{
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	@Override
	public String insert() 
	{
		String sql = "INSERT INTO tipovehiculo(codigo, descripcion) VALUES ("
				+ codigo+", '"
				+ descripcion.trim()
				+ "');";
		System.out.println(sql);
		return sql;
	}

	@Override
	public String read()
	{
		return "SELECT * FROM tipovehiculo";
	}

	@Override
	public String update() 
	{
		String sql = "UPDATE tipovehiculo SET descripcion= ' "+ descripcion.trim() + " ' WHERE codigo =  " + codigo;
		return sql;
	}

	@Override
	public String delete() 
	{
		return "DELETE FROM tipovehiculo WHERE codigo = " + codigo;
	}

	@Override
	public String findByPlaca()
	{
		return "SELECT * FROM tipovehiculo WHERE codigo = " + codigo;
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}

	@Override
	public String toString() 
	{
		return "tipoDeVehiculo [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}


}
