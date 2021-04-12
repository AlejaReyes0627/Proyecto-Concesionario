package model;

import java.io.Serializable;

import model.dao.Dto;

public class TradeMark implements Dto,Serializable
{
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String nombre;

	public TradeMark() 
	{

	}

	public TradeMark(String codigo, String nombre) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
	}

	@Override
	public String insert() 
	{
		String sql = "INSERT INTO marcas(codigo, nombre) VALUES ("
				+ codigo.trim()+", '"
				+ nombre.trim()
				+ "');";
		System.out.println(sql);
		return sql;
	}

	@Override
	public String read() 
	{
		return "SELECT * FROM marcas";
	}

	@Override
	public String update() 
	{
		String sql = "UPDATE marcas SET nombre= ' "+ nombre.trim()+  " ' WHERE codigo =  " + codigo.trim();
		return sql;
	}

	@Override
	public String delete() 
	{
		return "DELETE FROM marcas WHERE codigo = " + codigo.trim();
	}

	@Override
	public String findByPlaca() 
	{
		return "SELECT * FROM marcas WHERE codigo = " + codigo.trim();
	}


	public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	@Override
	public String toString() 
	{
		return "Marcas [codigo=" + codigo + ", nombre=" + nombre + "]";
	}









}
