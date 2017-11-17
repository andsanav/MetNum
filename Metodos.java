import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Metodos {
	
	public static void MetodoGauss() throws FileNotFoundException, UnsupportedEncodingException{
		Scanner scan = new Scanner(System.in);
		PrintWriter writer = new PrintWriter("Gauss.txt", "UTF-8");
		int i,j,k,n;
		double a[][] = new double [5][6];
		double cte,x1 = 0,x2,x3;
		double x[] = new double [5];
		//No. de incognitas (maximo 5)
		n = Integer.parseInt(scan.nextLine());
		for(i=0;i<n;i++)
		{
			for(j=0;j<=n;j++)
			{
				a[i][j] = Integer.parseInt(scan.nextLine());
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
	 	writer.println("x0= "+x1+" \nx1= " +x2+" \nx2= " +x3);
	 	writer.close();
		}


	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Metodos Proyecto = new Metodos();
		MetodoGauss();



	}

}
