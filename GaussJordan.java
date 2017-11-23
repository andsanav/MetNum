import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class GaussJordan {

	public static void MetodoGaussJordan() throws FileNotFoundException, UnsupportedEncodingException{

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
		PrintWriter writer = new PrintWriter("GaussJordan.txt", "UTF-8");
		int i,j,k,n;
		double a[][] = new double [5][6];
		double cte;
		//Incógnitas, max 5
		//n debe ser un entero
		double m = matrix.get(c);
		n = (int)m;
		//Coeficientes
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
		for(i=0;i<n;i++)
		{
			writer.println("Renglon "+(i+1));
			for(j=0;j<=n;j++)
			{
				writer.println(" a "+(i+1)+" "+(j+1)+" =" +a[i][j]);
			}
		}
		writer.close();
		}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Metodos Proyecto = new Metodos();
		MetodoGaussJordan();



	}


}
