import java.io.*;
import java.util.ArrayList;

public class gaussJordan1{

   static void intercambio(double[][] A, int i, int k, int j){
      int m = A[0].length - 1;
      double temp;
      for(int q=j; q<=m; q++){
         temp = A[i][q];
         A[i][q] = A[k][q];
         A[k][q] = temp;
      }
   }
   
   static void division(double[][] A, int i, int j){
      int m = A[0].length - 1;
      for(int q=j+1; q<=m; q++) A[i][q] /= A[i][j];
      A[i][j] = 1;
   }
   
   static void eliminacion(double[][] A, int i, int j){
      int n = A.length - 1;
      int m = A[0].length - 1;
      for(int p=1; p<=n; p++){
         if( p!=i && A[p][j]!=0 ){
            for(int q=j+1; q<=m; q++){
               A[p][q] -= A[p][j]*A[i][q];
            }
            A[p][j] = 0;
         }
      }
   }
   
   public static void main(String[] args) throws IOException {
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
		
      int n, m, i, j, k;
      
      double z = matrix.get(c);
      c++;
	  n = (int)z;
      m = n+1;

      double A[][] = new double [n+1][m+1];

      for(i=1; i<=n; i++){
         for(j=1; j<=m; j++){
            A[i][j] = matrix.get(c);
            c++;
         }
      }
      
      i = 1;
      j = 1;
      while( i<=n && j<=m ){
    	  
         k = i;
         while( k<=n && A[k][j]==0 ) k++;

         if( k<=n ){

            if( k!=i ) {
               intercambio(A, i, k, j);
            }

            if( A[i][j]!=1 ){
               division(A, i, j);
            }

            eliminacion(A, i, j);
            i++;
         }
         j++;
      }
      PrintWriter writer = new PrintWriter("gaussJordan1.txt", "UTF-8");
      n = A.length - 1;
      m = A[0].length - 1;
      for(i=1;i<=n;i++)
		{
			writer.println("Renglon "+(i+1));
			for(j=1;j<=m;j++)
			{
				writer.println(" a "+(i+1)+" "+(j+1)+" =" +A[i][j]);
			}
		}
      writer.close();
   }
}
