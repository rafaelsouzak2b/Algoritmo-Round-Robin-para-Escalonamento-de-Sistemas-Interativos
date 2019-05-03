package fronhonhom;

import java.util.Scanner;

public class Fronhonhom {

    public static void main(String[] args) {
        int process[] = new int[3];
        int valor_process[] = new int[3];
        int quantum;
        int tempoTotal[] = new int[3];
        int chaveamento[] = new int[3];

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o tempo do Processo " + (i + 1) + ": ");
            process[i] = scan.nextInt();
            valor_process[i] = process[i];
        }

        System.out.print("Digite o Quantum: ");
        quantum = scan.nextInt();

        int x[] = new int[3];
        int soma = 0;
        int tempTotal = 0;

        for (int i = 0; i < 3; i++) {
            x[i] = (process[i] / quantum) + (process[i] % quantum);
            soma += x[i];
            tempTotal += process[i];
            // System.out.println(x[i]);
        }

        int vet[] = new int[soma];
        int ultima_posicao[] = new int[3];
        int qtd = 0;

        do {
            for (int i = 0; i < process.length; i++) {
                if (process[i] >= quantum) {
                    process[i] -= quantum;
                    tempTotal -= quantum;
                    vet[qtd] = quantum;
                    if (process[i] == 0) {
                        ultima_posicao[i] = qtd;
                    }
                    qtd++;

                } else if (process[i] != 0) {
                    ultima_posicao[i] = qtd;
                    tempTotal -= process[i];
                    vet[qtd] = process[i];
                    process[i] = 0;
                    qtd++;

                }

            }

        } while (tempTotal > 0);

        /*
        for(int i=0; i<vet.length; i++){
            System.out.println(vet[i] + " ");
        }
         */
        int posicao = 0;
        for (int i = 0; i < tempoTotal.length; i++) {

            for (int j = posicao; j <= ultima_posicao[i]; j++) {
                tempoTotal[i] += vet[j];
                //System.out.println(vet[j]);
            }
            posicao++;
            chaveamento[i] = tempoTotal[i] - valor_process[i];
            System.out.println("------------------");
            System.out.printf("Tempo Total P%d: %d\n", i + 1, tempoTotal[i]);
            System.out.printf("Chaveamento P%d: %d\n", i + 1, chaveamento[i]);
            System.out.println("------------------");

        }

    }

}
