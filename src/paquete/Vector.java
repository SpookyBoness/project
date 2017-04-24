package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import exceptions.DimensionException;

public class Vector {
	private double [] cord;
	private int dim;
	
	public Vector(int dim){
		this.dim=dim;
	}
	public Vector (File f) throws FileNotFoundException{
		Scanner in = new Scanner(f);
		dim = in.nextInt();
		for(int i=0;i<dim;i++){
			cord[i]=in.nextDouble();
		}
	}
	public void load(double n, int i){
		cord[i]=n;
	}
	public Vector add(Vector o) throws DimensionException{
		if(dim!=o.dim)
			throw new DimensionException("Se rompio todo");
		Vector aux = new Vector(dim);
		for(int i =0;i<dim; i++){
			aux.cord[i]=cord[i]+o.cord[i];
		}
		return aux;
	}
	public Vector substract(Vector o)throws DimensionException{
		if(dim!=o.dim)
			throw new DimensionException("Se rompio todo");
		Vector aux = new Vector(dim);
		for(int i =0;i<dim; i++){
			aux.cord[i]=cord[i]-o.cord[i];
		}
		return aux;
	}
	public double product(Vector o)throws DimensionException{
		if(dim!=o.dim)
			throw new DimensionException("Se rompio todo");
		double n=0;
		for(int i =0;i<dim; i++){
			n+=cord[i]*o.cord[i];
		}
		return n;
	}
	public Vector product(double n){
		Vector aux = new Vector(dim);
		for(int i =0;i<dim; i++){
			aux.cord[i]*=n;
		}
		return aux;
	}
	public double normaUno(){
		double n=0;
		for(int i=0;i<dim;i++){
			n+=cord[i]*cord[i];	
		}
		return n;
	}
	public double normaDos(){
		double n=0;
		for(int i=0;i<dim;i++){
			n+=cord[i]*cord[i];	
		}
		return Math.sqrt(n);
	}
	public double normalInfinito(){
		double max=0;
		for(int i=0;i<dim;i++){
			if(cord[i]>max)
				max=cord[i];
		}
		return max;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (!Arrays.equals(cord, other.cord))
			return false;
		if (dim != other.dim)
			return false;
		return true;
	}
	
}
