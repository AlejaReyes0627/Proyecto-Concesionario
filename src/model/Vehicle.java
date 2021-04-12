package model;

import java.io.Serializable;

import model.dao.Dto;

public class Vehicle implements Dto, Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String placa;
	private String marca;
	private int modelo;
	private String linea;
	private String color;
	private int tipoDeVehiculo;
	private double precioMinimo;
	private int propietario;
		
	
	public Vehicle() 
	{
		
	}


	public Vehicle(String placa, String marca, int modelo, String linea, String color, int tipoDeVehiculo,
			double precioMinimo, int propietario) 
	{
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.linea = linea;
		this.color = color;
		this.tipoDeVehiculo = tipoDeVehiculo;
		this.precioMinimo = precioMinimo;
		this.propietario = propietario;
	}



	@Override
	public String insert() 
	{
		  String sql = "INSERT INTO vehiculo(placa, marca, modelo, linea, color, tipoDeVehiculo, precioMinimo, propietario) VALUES ("
	                + placa.trim()+", '"
	                + marca.trim()+ "','"
	                + modelo + "','" 
	                + linea.trim() + "','" 
	                + color.trim() + "','" 
	                + tipoDeVehiculo + "','" 
	                + precioMinimo + "','" 
	                + propietario
	                + "');";
	        System.out.println(sql);
	        return sql;
	}


	@Override
	public String read() 
	{
		 return "SELECT * FROM vehiculo";
	}


	@Override
	public String update() 
	{
		String sql = "UPDATE vehiculo SET marca= ' "+ marca.trim() + " ', modelo= ' " 
		        + modelo + " ', linea= ' " + linea.trim() +  " ', color= ' "+color.trim() + " ', tipoDeVehiculo= ' " + tipoDeVehiculo 
		        + " ', precioMinimo= ' " + precioMinimo +  " ', propietario= ' " + propietario 
		        +  " ' WHERE placa =  " + placa;
		        return sql;
	}


	@Override
	public String delete() 
	{
		return "DELETE FROM vehiculo WHERE placa = " + placa;
	}


	@Override
	public String findByPlaca() 
	{
		 return "SELECT * FROM vehiculo WHERE placa = " + placa;
	}
	
	
	
	public String getPlaca() 
	{
		return placa;
	}


	public void setPlaca(String placa) 
	{
		this.placa = placa;
	}


	public String getMarca() 
	{
		return marca;
	}


	public void setMarca(String marca) 
	{
		this.marca = marca;
	}


	public int getModelo() 
	{
		return modelo;
	}


	public void setModelo(int modelo) 
	{
		this.modelo = modelo;
	}


	public String getLinea() 
	{
		return linea;
	}


	public void setLinea(String linea) 
	{
		this.linea = linea;
	}


	public String getColor() 
	{
		return color;
	}


	public void setColor(String color) 
	{
		this.color = color;
	}


	public int getTipoDeVehiculo() 
	{
		return tipoDeVehiculo;
	}


	public void setTipoDeVehiculo(int tipoDeVehiculo) 
	{
		this.tipoDeVehiculo = tipoDeVehiculo;
	}


	public double getPrecioMinimo() 
	{
		return precioMinimo;
	}


	public void setPrecioMinimo(double precioMinimo)
	{
		this.precioMinimo = precioMinimo;
	}


	public int getPropietario() 
	{
		return propietario;
	}


	public void setPropietario(int propietario) 
	{
		this.propietario = propietario;
	}




	@Override
	public String toString() 
	{
		return "vehiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", linea=" + linea + ", color="
				+ color + ", tipoDeVehiculo=" + tipoDeVehiculo + ", precioMinimo=" + precioMinimo + ", propietario="
				+ propietario + ", stock=" +  "]";
	}


	
	
	
	
}
