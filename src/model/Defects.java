package model;

import java.io.Serializable;

import model.dao.Dto;

public class Defects implements Dto,Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String placa;
	private int orden;
	private String descripcion;
	
	
	public Defects() 
	{

	}

	public Defects(String placa, int orden, String descripcion) 
	{
		this.placa = placa;
		this.orden = orden;
		this.descripcion = descripcion;
	}

	@Override
	public String insert() 
	{
		String sql = "INSERT INTO defectos(placa, orden, descripcion) VALUES ("
                + placa.trim()+", '"
                + orden+ "','"
                + descripcion.trim()
                + "');";
        System.out.println(sql);
        return sql;
	}
	
	@Override
	public String read() 
	{
		 return "SELECT * FROM defectos";
	}

	@Override
	public String update() 
	{
		String sql = "UPDATE defectos SET marca= ' "+ orden + " ', modelo= ' " 
		        + descripcion.trim()  +  " ' WHERE placa =  " + placa;
		        return sql;
	}

	@Override
	public String delete() 
	{
		return "DELETE FROM defectos WHERE placa = " + placa;
	}

	@Override
	public String findByPlaca() 
	{
		return "SELECT * FROM defectos WHERE placa = " + placa;
	}
	
	
	public String getPlaca() 
	{
		return placa;
	}

	public void setPlaca(String placa) 
	{
		this.placa = placa;
	}

	public int getOrden() 
	{
		return orden;
	}

	public void setOrden(int orden) 
	{
		this.orden = orden;
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
		return "Defectos [placa=" + placa + ", orden=" + orden + ", descripcion=" + descripcion + "]";
	}

	
	
	
	
}
