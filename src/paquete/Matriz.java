package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import exceptions.DimensionException;

public class Matriz {
	private double [][] cord;
	private int f,c,dim;
	
	public Matriz(File file) throws FileNotFoundException{
		Scanner in = new Scanner(file);
		f = in.nextInt();
		c = in.nextInt();
		dim= f*c;
		int auxf,auxc;
		for(int i =0;i<dim;i++){
			//cord[in.nextInt()][in.nextInt()]=in.nextDouble();
			auxf=in.nextInt();
			auxc=in.nextInt();
			cord[auxf][auxc]=in.nextDouble();
		}
	}
	public Matriz(int f, int c) {
		this.f=f;
		this.c=c;
		dim=f*c;
		cord = new double [f][c];
	}
	public Matriz add(Matriz o) throws DimensionException{
		if(dim!=o.dim)
			throw new DimensionException("no esta bien");
		Matriz aux= new Matriz(f,c);
		for(int i=0;i<f;i++){
			for(int j=0;j<c;j++){
				aux.cord[i][j]=cord[i][j]+o.cord[i][j];
			}
		}
		return aux;
	}
	public void add(double n, int f, int c){
		cord[f][c]=n;
	}
	public Matriz substract(Matriz o) throws DimensionException{
		if(dim!=o.dim)
			throw new DimensionException("no esta bien");
		Matriz aux= new Matriz(f,c);
		for(int i=0;i<f;i++){
			for(int j=0;j<c;j++){
				aux.cord[i][j]=cord[i][j]-o.cord[i][j];
			}
		}
		return aux;
	}
	public Matriz product(Matriz o) throws DimensionException{
		if(dim!=o.dim||f!=c)
			throw new DimensionException("no esta bien");
		Matriz aux= new Matriz(f,c);
		for(int i=0;i<f;i++){
			for(int j=0;j<c;j++){
				for(int k= 0;k<c;k++){
					aux.cord[i][j]+=cord[i][k]*o.cord[k][j];
				}
			}
		}
		return aux;
	}
	public void show(){
		for(int i=0;i<f;i++){
			for(int j=0;j<c;j++){
				System.out.print(cord[i][j]+" ");
			}
			System.out.print(System.lineSeparator());
		}
	}
}
