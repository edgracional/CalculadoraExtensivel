package calculadoraExtensivel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class calculadora {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
       
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite a opera��o desejada(Padr�es: Adicao, Subtracao, Multiplicacao, Divisao): ");
        String op = scan.nextLine();
        
        System.out.println("Digite o primeiro n�mero: ");
        double a = Double.parseDouble(scan.nextLine());
        
        System.out.println("Digite o segundo n�mero: ");
        double b = Double.parseDouble(scan.nextLine());
        
        scan.close();
        
        Object classInstance = Class.forName("calculadoraExtensivel."+op).getDeclaredConstructor().newInstance();
        Method operation = Class.forName("calculadoraExtensivel."+op).getDeclaredMethod("result", new Class[] {Double.class, Double.class});
        operation.invoke(classInstance, a, b);

}}
