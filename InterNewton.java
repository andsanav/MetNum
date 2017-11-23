import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class InterNewton {

	public static void InterpolacionNewton() throws FileNotFoundException, UnsupportedEncodingException{
		
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
		PrintWriter writer = new PrintWriter("InterNewton.txt", "UTF-8");
		double a[][] = new double [5][2];
		double x,y,fx1x0,fx2x1,fx3x2,fx4x3,fx2x1x0,fx3x2x1,fx4x3x2,fx3x2x1x0,fx4x3x2x1,fx4x3x2x1x0;
		int i;
		//Diferencias de Newton (5 puntos)
		//Valor a interpolar
		x= matrix.get(c);
		//5 pares de puntos
		for(i=0;i<5;i++){
				a[i][0]= matrix.get(c);
				a[i][1]= matrix.get(c);
				}		
		fx1x0=(a[1][1]-a[0][1])/(a[1][0]-a[0][0]);
		fx2x1=(a[2][1]-a[1][1])/(a[2][0]-a[1][0]);
		fx3x2=(a[3][1]-a[2][1])/(a[3][0]-a[2][0]);
		fx4x3=(a[4][1]-a[3][1])/(a[4][0]-a[3][0]);
		fx2x1x0=(fx2x1-fx1x0)/(a[2][0]-a[0][0]);
		fx3x2x1=(fx3x2-fx2x1)/(a[3][0]-a[1][0]);
		fx4x3x2=(fx4x3-fx3x2)/(a[4][0]-a[2][0]);
		fx3x2x1x0=(fx3x2x1-fx2x1x0)/(a[3][0]-a[0][0]);
		fx4x3x2x1=(fx4x3x2-fx3x2x1)/(a[3][0]-a[0][0]);
		fx4x3x2x1x0=(fx4x3x2x1-fx3x2x1x0)/(a[4][0]-a[0][0]);
		y=a[0][1]+fx1x0*(x-a[0][0])+fx2x1x0*(x-a[0][0])*(x-a[1][0])+fx3x2x1x0*(x-a[0][0])*(x-a[1][0])*(x-a[2][0])+fx4x3x2x1x0*(x-a[0][0])*(x-a[1][0])*(x-a[2][0])*(x-a[3][0]);
	    	writer.println("f(x) en ese punto es: "+y);
	        writer.close();
		}
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Metodos Proyecto = new Metodos();
		InterpolacionNewton();



	}

}
