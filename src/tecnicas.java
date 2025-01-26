import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
     // 1) Calcular o valor de SOMA
    public static void main(String[] args) {
        int indice = 13, soma = 0, k = 0;
        while (k < indice) {
            k = k + 1;
            soma = soma + k;
        }
        System.out.println("1) O valor da variável SOMA é: " + soma);

      

        // 2) Verificar se um número pertence à sequência de Fibonacci
        Scanner scanner = new Scanner(System.in);
        System.out.print("2) Informe um número para verificar se pertence à sequência de Fibonacci: ");
        int num = scanner.nextInt();
        if (pertenceFibonacci(num)) {
            System.out.println("O número " + num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + num + " não pertence à sequência de Fibonacci.");
        }

      
        // 3) Análise de faturamento diário
        double[] faturamento = {0, 150.5, 0, 200.0, 300.0, 0, 0, 400.0, 100.0, 0, 50.0}; 
        calcularFaturamento(faturamento);

      
        // 4) Percentual de faturamento por estado
        double sp = 67836.43, rj = 36678.66, mg = 29229.88, es = 27165.48, outros = 19849.53;
        calcularPercentualFaturamento(sp, rj, mg, es, outros);

      
        // 5) Inverter uma string
        System.out.print("5) Informe uma string: ");
        String str = scanner.next();
        String invertida = inverterString(str);
        System.out.println("String invertida: " + invertida);

        scanner.close();
    }

    public static boolean pertenceFibonacci(int num) {
        if (num < 0) return false;
        int a = 0, b = 1;
        while (a <= num) {
            if (a == num) return true;
            int temp = a;
            a = b;
            b = temp + b;
        }
        return false;
    }

    public static void calcularFaturamento(double[] faturamento) {
        double menor = Double.MAX_VALUE, maior = Double.MIN_VALUE, soma = 0;
        int diasComFaturamento = 0, diasAcimaDaMedia = 0;

        for (double valor : faturamento) {
            if (valor > 0) {
                if (valor < menor) menor = valor;
                if (valor > maior) maior = valor;
                soma += valor;
                diasComFaturamento++;
            }
        }

        double media = soma / diasComFaturamento;
        for (double valor : faturamento) {
            if (valor > media) diasAcimaDaMedia++;
        }

        System.out.println("3) Menor valor de faturamento: " + menor);
        System.out.println("   Maior valor de faturamento: " + maior);
        System.out.println("   Dias com faturamento acima da média: " + diasAcimaDaMedia);
    }

    public static void calcularPercentualFaturamento(double sp, double rj, double mg, double es, double outros) {
        double total = sp + rj + mg + es + outros;
        System.out.printf("4) Percentual de faturamento por estado:\n");
        System.out.printf("   SP: %.2f%%\n", (sp / total) * 100);
        System.out.printf("   RJ: %.2f%%\n", (rj / total) * 100);
        System.out.printf("   MG: %.2f%%\n", (mg / total) * 100);
        System.out.printf("   ES: %.2f%%\n", (es / total) * 100);
        System.out.printf("   Outros: %.2f%%\n", (outros / total) * 100);
    }

    public static String inverterString(String str) {
        char[] chars = str.toCharArray();
        String invertida = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            invertida += chars[i];
        }
        return invertida;
    }
}
