import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class InterLagrange {

	public static void InterpolacionLagrange() throws FileNotFoundException, UnsupportedEncodingException{
		
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
		PrintWriter writer = new PrintWriter("InterLagrange.txt", "UTF-8");
		int n,i;
		double x,y;
		double a[][] = new double [4][2];
		//2-4 puntos
		do{
		//Numero de puntos (int)
		double m = matrix.get(c);
		n = (int)m;
		}while(n<2 || n>4);
		//Pares de puntos (xi y f(x)i)
		for(i=0;i<n;i++){
				a[i][0]= matrix.get(c);
				a[i][1]= matrix.get(c);
				}
		//Valor a interpolar
		x= matrix.get(c);
		switch(n){
			case 2:
			y=(((((x-a[1][0])*a[0][1])/(a[0][0]-a[1][0]))+(((x-a[0][0])*a[1][1])/(a[1][0]-a[0][0]))));
			writer.println("f(x) en ese punto es: "+y);
			writer.close();
			break;
			case 3:
			y=((x-a[1][0])*(x-a[2][0])*a[0][1])/((a[0][0]-a[1][0])*(a[0][0]-a[2][0]))+((x-a[0][0])*(x-a[2][0])*a[1][1])/((a[1][0]-a[0][0])*(a[1][0]-a[2][0]))+((x-a[1][0])*((x-a[0][0])*a[2][1])/((a[2][0]-a[0][0])*(a[2][0]-a[1][0])));
			writer.println("f(x) en ese punto es: "+y);
			writer.close();
			break;
			case 4:
			y=((x-a[1][0])*(x-a[3][0])*(x-a[2][0])*a[0][1])/((a[0][0]-a[1][0])*(a[0][0]-a[2][0])*(a[0][0]-a[3][0]))+((x-a[0][0])*(x-a[2][0])*(x-a[3][0])*a[1][1])/((a[1][0]-a[0][0])*(a[1][0]-a[2][0])*(a[1][0]-a[3][0]))+((x-a[0][0])*(x-a[1][0])*((x-a[3][0])*a[2][1])/((a[2][0]-a[0][0])*(a[2][0]-a[1][0])*(a[2][0]-a[3][0]))+((x-a[0][0])*(x-a[1][0])*((x-a[2][0])*a[
3][1])/((a[3][0]-a[0][0])*(a[3][0]-a[1][0])*(a[3][0]-a[2][0]))));
			writer.println("f(x) en ese punto es: "+y);
			writer.close();
			break;
			default:
			writer.println("INVALIDO");
			writer.close();
			break;	
		}
	}
		
		public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
			Metodos Proyecto = new Metodos();
			InterpolacionLagrange();



		}

	}


