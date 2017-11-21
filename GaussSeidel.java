import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class GaussSeidel {

	public static void MetodoGaussSeidel() throws FileNotFoundException, UnsupportedEncodingException{
		Scanner scan = new Scanner(System.in);
		PrintWriter writer = new PrintWriter("GaussSeidel.txt", "UTF-8");
		double x0,x1,x2,tol,e;
		int i,j;
		double a[][]= new double [3][4];
		//GaussSeidel para tres ecuaciones
		//Tolerancia:
		tol= Integer.parseInt(scan.nextLine());
		//Coeficientes
		for(i=0;i<3;i++)
		{
			for(j=0;j<=3;j++)
			{
				a[i][j]=Integer.parseInt(scan.nextLine());
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


