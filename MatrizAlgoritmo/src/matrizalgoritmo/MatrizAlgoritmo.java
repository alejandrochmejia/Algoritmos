
package matrizalgoritmo;
import java.math.*;

public class MatrizAlgoritmo {
    
    public static void main(String[] args) {
        Ventana vent = new Ventana(); //Hace referencia a la ventana creada en la variable vent
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
    
    public static int[][] matriz(int numero){ //Metodo que crea una matriz y la rellena con numeros aleatorios
        //Metodo que crea una matriz cuadrada
        int[][] matriz = new int[numero][numero];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (int) Math.floor(Math.random()*1000);
            }
        }
        return matriz;
    }
    
    public static String resultado(int[][] matriz){ //Metodo que pasa la matriz int a string
        String resultado = "\n \t";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] < 10) resultado = resultado + "00" + Integer.toString(matriz[i][j]) + " ";
                else if (matriz[i][j]>9 && matriz[i][j]<100) resultado = resultado + "0" + Integer.toString(matriz[i][j]) + " ";
                else resultado = resultado + Integer.toString(matriz[i][j]) + " ";
            }
            resultado = resultado + "\n\t";
        }
        return resultado;
    }
    public static String ordenarD(int matriz[][]){ //Metodo que ordena la diagonal principal
        String principal = "";
        int Dp[] = new int[matriz.length];
        for(int i = 0; i < matriz.length;i++){
            for (int j = 0; j < Dp.length; j++) {
                if(i==j){
                    Dp[i] = matriz[i][j];
                }
            }
        }
        int tem;
        for (int x = 0; x < matriz.length-1; x++) {
            for (int y = 0; y < matriz.length-1; y++) {
                if (Dp[y+1] > Dp[y]){
                    tem = Dp[y + 1];
                    Dp[y + 1] = Dp[y];
                    Dp[y] = tem;
                }
            }
        }
        for (int i = 0; i < Dp.length; i++) {
            if(i < (Dp.length-1))principal= principal + Integer.toString(Dp[i]) + ", ";
            else principal= principal + Integer.toString(Dp[i]);
        }
        return principal;
    }
    public static String promedioDs(int matriz[][]){ //Metodo que determina el promedio de la diagonal secundaria
        int Ds[] = new int[matriz.length];
        String promedio;
        int suma = 0;
        double prom = 0;
        for(int i = 0; i < matriz.length;i++){
            for(int j = 0; j < matriz[0].length;j++){
                if(i+j == matriz.length - 1){
                    Ds[i] = matriz[i][j];
                }
            }
        }
        for(int i = 0; i < Ds.length;i++){
            suma += Ds[i];
            prom = (double)suma / Ds.length;
        }
        promedio = "El promedio es " + Double.toString(prom);
        return promedio;
    }
    
    public static String potencia(int matriz[][]){ //Metodo que determina la potencia del numero menor de la matrizal mayor de la matriz
        String potencia = "";
        int menor = 0;
        int mayor = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (i == 0) menor = matriz[i][0];
            else {
                if(menor > matriz[i][0]) menor = matriz[i][0];
            }
        }
        for (int j = 0; j < matriz.length; j++) {
            if (j == 0) mayor = matriz[j][matriz.length-1];
            else{
                if (mayor < matriz[j][matriz.length-1]) mayor = matriz[j][matriz.length-1];
            }
        }
        BigInteger resultado = new BigInteger(BigInteger.valueOf(menor).pow(mayor).toByteArray());
        
        potencia = Integer.toString(menor) + " ^ " + Integer.toString(mayor) + " = " + resultado;
        return potencia;
    }
    
    public static String SucesionFibonacci(int matriz[][]){ //Metodo que nos muestra la sucesión de Fibonacci
        String fibonacci = "";
        int mayor = -9999999;
        for(int i = 0; i < matriz.length;i++){
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] > mayor){
                    mayor = matriz[i][j];
                }
            }
        }
        int a = 0; int b = 1;
        while(a < mayor){
            if (a!=0) fibonacci = fibonacci + ", ";
            fibonacci = fibonacci + Integer.toString(a);
            int c = a + b;
            a = b;
            b = c;
        }
        return fibonacci;
    }
    
    
}
