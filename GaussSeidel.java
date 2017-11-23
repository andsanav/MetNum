import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
public class GaussSeidel {

	public static void MetodoGaussSeidel() throws FileNotFoundException, UnsupportedEncodingException{
		
		//read file, lee el archivo que genera el php

				String FILENAME = "solve.dat";

				BufferedReader br = null;
				FileReader fr = null;

				//input list matrix
//				StringBuilder strB = new StringBuilder();
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

//				String finalMatrix = strB.toString();
//				System.out.println(finalMatrix);

				int c=0;

				//es el archivo que genera el programa que sera leido para 
		PrintWriter writer = new PrintWriter("GaussSeidel.txt", "UTF-8");
		double x0,x1,x2,tol,e;
		int i,j;
		double a[][]= new double [3][4];
		//GaussSeidel para tres ecuaciones
		//Tolerancia:
		tol= matrix.get(c);
		//Coeficientes
		for(i=0;i<3;i++)
		{
			for(j=0;j<=3;j++)
			{
				a[i][j] = matrix.get(c);
			}
		}
		x1=0.0;
		x2=0.0;
		do{
			e=x1;
			x0=(a[0][3]-x1*a[0][1]-x2*a[0][2])/a[0][0];
			x1=(a[1][3]-x0*a[1][0]-x2*a[1][2])/a[1][1];
			x2=(a[2][3]-x0*a[2][0]-x1*a[2][1])/a[2][2];
		}while(Math.abs(e-x1)>tol);
		writer.println("x0= "+x0+" \nx1= " +x1+" \nx2= " +x2);
		writer.close();
		}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Metodos Proyecto = new Metodos();
		MetodoGaussSeidel();



	}


	}


