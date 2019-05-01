package fronhonhom;
import java.util.Scanner;

public class Fronhonhom {

    public static void main(String[] args) {
        int process[] = new int[3];
	int quantum;
	int tempoTotal[] = new int[3];
        
        Scanner scan = new Scanner(System.in);

	for (int i=0; i<3; i++){
            System.out.print("Digite o tempo do Processo " + (i+1) + ": ");
            process[i] = scan.nextInt();
	}
        
	System.out.print("Digite o Quantum: ");
        quantum = scan.nextInt();
        
	int x[] = new int[3];
        int soma = 0;

	for (int i=0; i<3; i++){
		x[i] = (process[i]/quantum) + (process[i]%quantum);
                soma += x[i];
	}
        
        int vet[] = new int[soma];
        int aux =0 ;
        int qtd =0;
        
        for(int i=0; i<2; i++){
            for(int z=0; z<3; z++){
                aux = process[z] - aux;
                if(aux > quantum){
                    vet[qtd]= quantum;
                    aux += quantum;
                }else{
                    vet[qtd] = aux;
                }
                qtd++;
            }
        }
        
        
        for(int i=0; i<vet.length; i++){
            System.out.println(vet[i]);
        }
        
    }
    
}
