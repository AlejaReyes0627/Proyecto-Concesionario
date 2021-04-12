package model;

import java.io.Serializable;

import model.dao.Dto;

public class Owners implements Dto, Serializable
{
	private static final long serialVersionUID = 1L;

	private int cedula;
	private String nombre;
	private String apellido;
	private int telefono;
	private String email;

	public Owners() 
	{

	}

	public Owners(int cedula, String nombre, String apellido, int telefono, String email) 
	{
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
	}


	@Override
	public String insert() 
	{
		String sql = "INSERT INTO propietarios(cedula, nombre, apellido, telefono, email) VALUES ("
				+ cedula +", '"
				+ nombre.trim()+ "','"
				+ apellido.trim() + "','" 
				+ telefono + "','" 
				+ email.trim()
				+ "');";
		System.out.println(sql);
		return sql;
	}

	@Override
	public String read() 
	{
		return "SELECT * FROM propietarios";
	}

	@Override
	public String update() 
	{
		String sql = "UPDATE propietarios SET nombre= ' "  + nombre.trim() + " ', apellido= ' " 
				+ apellido.trim() +  " ', telefono= ' "+telefono + " ', email= ' " + email.trim() 
				+  " ' WHERE cedula =  " + cedula;
		return sql;
	}

	@Override
	public String delete()
	{
		return "DELETE FROM propietarios WHERE cedula = " + cedula;
	}

	@Override
	public String findByPlaca() 
	{
		 return "SELECT * FROM propietarios WHERE cedula = " + cedula;
	}

	public int getCedula() 
	{
		return cedula;
	}

	public void setCedula(int cedula) 
	{
		this.cedula = cedula;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido() 
	{
		return apellido;
	}

	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}

	public int getTelefono() 
	{
		return telefono;
	}

	public void setTelefono(int telefono) 
	{
		this.telefono = telefono;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	@Override
	public String toString() 
	{
		return "propietarios [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
				+ telefono + ", email=" + email + "]";
	}

}
