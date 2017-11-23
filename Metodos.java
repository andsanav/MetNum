import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

//read file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class Metodos {
	public static void MetodoGauss() throws FileNotFoundException, UnsupportedEncodingException{

		//read file, lee el archivo que genera el php

		String FILENAME = "solve.dat";

		BufferedReader br = null;
		FileReader fr = null;

		//input list matrix
//		StringBuilder strB = new StringBuilder();
		ArrayList<Double> matrix = new ArrayList<Double>();

		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				matrix.add(Double.valueOf(sCurrentLine));
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

//		String finalMatrix = strB.toString();
//		System.out.println(finalMatrix);

		int c=0;

		//es el archivo que genera el programa que sera leido para 
		PrintWriter writer = new PrintWriter("Gauss.txt", "UTF-8");
		int i,j,k;
		double m;
		double a[][] = new double [5][6];
		double cte,x1 = 0,x2,x3;
		//No. de incognitas (maximo 5)
		//n = Integer.parseInt(scan.nextLine());
		m = matrix.get(c);
		int n = (int)m;
		c++;
		for(i=0;i<n;i++)
		{
			for(j=0;j<=n;j++)
			{
				//a[i][j] = Integer.parseInt(scan.nextLine());
				a[i][j] = matrix.get(c);
				if(c >= (n*2)){
					break;
				}
				c++;
			}
		}
		for(i=0;i<n-1;i++){
		  for(j=i+1;j<=n;j++){
			 cte=(-a[j][i])/(a[i][i]);
		      for(k=i;k<n+1;k++){
			 a[j][k]=((a[i][k])*cte)+a[j][k];
			 }
		   }
		}
	 	x3=a[n-1][n]/a[n-1][n-1];
	 	x2=(a[n-2][n]-x3*a[n-2][n-1])/a[n-2][n-2];
	 	if(n>2)
	 	x1=(a[n-3][n]-x2*a[n-3][n-2]-x3*a[n-3][n-1])/a[n-3][n-3];
		System.out.println("x0= "+x1+" \nx1= " +x2+" \nx2= " +x3);
	 	writer.println("x0= "+x1+" \nx1= " +x2+" \nx2= " +x3);
	 	writer.close();

/*		for(int e=0;e<((n*2)+1);e++){
			System.out.println(matrix.get(e));
		}*/

	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Metodos Proyecto = new Metodos();
		MetodoGauss();



	}

}

