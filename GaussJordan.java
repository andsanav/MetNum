import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class GaussJordan {

	public static void MetodoGaussJordan() throws FileNotFoundException, UnsupportedEncodingException{
		Scanner scan = new Scanner(System.in);
		PrintWriter writer = new PrintWriter("GaussJordan.txt", "UTF-8");
		int i,j,k,n;
		double a[][] = new double [5][6];
		double cte;
		double x[] = new double [5];
		//Incógnitas, max 5
		n=Integer.parseInt(scan.nextLine());
		//Coeficientas
		for(i=0;i<n;i++)
		{
			for(j=0;j<=n;j++)
			{
				a[i][j]=Integer.parseInt(scan.nextLine());
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
