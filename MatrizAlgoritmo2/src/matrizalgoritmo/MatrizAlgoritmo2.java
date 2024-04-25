
package matrizalgoritmo;
import java.math.*;

public class MatrizAlgoritmo2 {
    
    public static void main(String[] args) {
        Ventana2 vent = new Ventana2(); //Hace referencia a la ventana creada en la variable vent
        vent.setVisible(true); //Muestra la ventana
        vent.setLocationRelativeTo(null); //Cambia la posicion de la ventana al aparecer en el centro
    }
    
    public static boolean verificacion(String tam){ //Metodo que comprueba que el numero dado forma parte del rango de 3 a 10
        boolean verificacion;
        try {
            int numero = Integer.parseInt(tam);
            if (numero < 3 || numero > 10) verificacion = false;
            else verificacion = true;
        }catch (java.lang.NumberFormatException e){
            verificacion = false;
        }
        return verificacion;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //-----------------------------------------------METODOS RECURSIVOS -----------------------------------------------------------------//
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static int[][] matrizCreacion(int[][] matriz, int i, int j){ //Metodo que crea una matriz y la rellena con numeros aleatorios
        //Metodo que crea una matriz cuadrada
        if (i == matriz.length) {
            return matriz;
        }
        if (j == matriz[0].length) {
            return matrizCreacion(matriz, i + 1, 0);
        }
        matriz[i][j] = (int)(Math.random() * 1000);
        return matrizCreacion(matriz, i, j + 1);
    }
    
    public static void resultado(int[][] matriz, String[] resultado, int i,int j){ //Metodo que pasa la matriz int a string
        if(i < matriz.length){
            if(j < matriz.length - 1){
                if (matriz[i][j] < 10) resultado[0] = resultado[0] + "00" + Integer.toString(matriz[i][j]) + " ";
                else if (matriz[i][j]>9 && matriz[i][j]<100) resultado[0] = resultado[0] + "0" + Integer.toString(matriz[i][j]) + " ";
                else resultado[0] = resultado[0] + Integer.toString(matriz[i][j]) + " ";
                resultado(matriz,resultado,i,j+1);
            }
            else{
                if (matriz[i][j] < 10) resultado[0] = resultado[0] + "00" + Integer.toString(matriz[i][j]) + " ";
                else if (matriz[i][j]>9 && matriz[i][j]<100) resultado[0] = resultado[0] + "0" + Integer.toString(matriz[i][j]) + " ";
                else resultado[0] = resultado[0] + Integer.toString(matriz[i][j]) + " ";
                resultado[0] = resultado[0] + "\n\t";
                resultado(matriz,resultado,i+1,0);
            }
        }
    }
    
    public static void diagonalP(int matriz[][],int i,int dp[]){
        if(i < matriz.length - 1){
            diagonalP(matriz,i+1,dp);
        }
        dp[i] = matriz[i][i];
    }
    
    public static void ordenarP(int dp[], int i, int n) {
        int temp;
        if (n == 1 || i >= n - 1) {
            return;
        }
        if (dp[i] > dp[i + 1]) {
            temp = dp[i];
            dp[i] = dp[i + 1];
            dp[i + 1] = temp;
        }
        ordenarP(dp, i + 1, n);

        // Llamar recursivamente con un elemento menos
        ordenarP(dp, 0, n - 1);
    }
    
    public static void diagonalS(int matriz[][],int i,int ds[]){
        if(i < matriz.length-1){
            diagonalS(matriz,i+1,ds);
        }
        ds[i] = matriz[i][matriz.length-1-i];
    }
    
    public static int sumadiaS(int matriz[][],int ds[],int i){

        int suma = 0;
        if(i == ds.length){
            return 0;
        }else{
            suma = ds[i] + sumadiaS(matriz,ds,i+1);
        }
        return suma;
    }
    
    public static double promediodiagoS(int suma,int matriz[][])  {
        double prom = 0;
        prom = (double) suma / matriz.length;
        return prom;
    }

public static int menordelaPC(int matriz[][], int i) {
    if (i < matriz.length) {
        int actual = matriz[i][0];
        int menorRestante = menordelaPC(matriz, i + 1);

        if (actual < menorRestante) {
            return actual;
        } else {
            return menorRestante;
        }
    }
    return Integer.MAX_VALUE;
}
    
public static int mayordelaUC(int matriz[][], int i) {
    if (i < matriz.length) {
        int actual = matriz[i][matriz[i].length - 1];
        int mayorRestante = mayordelaUC(matriz, i + 1);

        if (actual > mayorRestante) {
            return actual;
        } else {
            return mayorRestante;
        }
    }
    return Integer.MIN_VALUE;
}
    
    public static String potencia(int max, int min){
        BigInteger resultado = new BigInteger(BigInteger.valueOf(min).pow(max).toByteArray());
        String str = Integer.toString(min) + " ^ " + Integer.toString(max) + " = " + resultado;
        return str;
    }
    
    public static int mayordelaMatriz(int matriz[][],int i,int j,int mayor){
        if (i == matriz.length) {
            return mayor;
        }
        if (j == matriz[0].length) {
            return mayordelaMatriz(matriz, i + 1, 0, mayor);
        }
        if (matriz[i][j] > mayor) {
            mayor = matriz[i][j];
        }
        return mayordelaMatriz(matriz, i, j + 1, mayor);
    }

    public static String Fibonacci(int a, int b, int max) {
        if (a <= max) {
            return a + " " + Fibonacci(b, a + b, max);
        } else {
            return "";
        }
    }
    
}
