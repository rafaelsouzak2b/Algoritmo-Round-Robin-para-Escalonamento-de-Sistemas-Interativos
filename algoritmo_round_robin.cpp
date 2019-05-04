#include <iostream>
using namespace std;

int main(){
    setlocale(LC_ALL, "Portuguese");

    int process[3], aux[3] ,ttp[3] = {0, 0, 0};
    int quantum;

    cout << "Digite o quantum: ";
    cin >> quantum;

    for(int i=0; i<3; i++){
        cout << "Digite o p" << (i+1) << ": ";
        cin >> process[i];
        aux[i] = process[i];

        //Retirando os valores de time slice que antecedem cada processo
        if(i == 0){
            if(aux[0] >= quantum){
                ttp[1] -= quantum;
                ttp[2] -= quantum;

            }else {
                ttp[1] -= aux[0];
                ttp[2] -= aux[0];
            }
        }

        if(i == 1){
            if(aux[1] >= quantum)
                ttp[2] -= quantum;

            else 
                ttp[2] -= aux[1];
            
        }
    }

    //verificando qual processo vai ter mais rodada
    int maior = aux[0];
    int rodada = (aux[0]/quantum) + 1;

    for(int i=0; i<3; i++){

        if(aux[i] > maior){

            if((aux[i]%quantum) == 0)
                rodada = (aux[i]/quantum);

            else
                rodada = (aux[i]/quantum) + 1;
            
        }
    }

    //repetindo ate que todas as rodadas sejam realizadas
    while(rodada > 0){

        for(int i=0; i<3; i++){
            if(aux[i] >= quantum){
                //só vai deixar entrar o valor de time slice se o processo não foi finalizado
                if(aux[0] != 0)
                    ttp[0] += quantum;

                if(aux[1] != 0)    
                    ttp[1] += quantum;

                if(aux[2] != 0)   
                    ttp[2] += quantum;

                aux[i] -= quantum;
            
            }else {
                //só vai deixar entrar o valor de time slice se o processo não foi finalizado
                if(aux[0] != 0)
                    ttp[0] += aux[i];

                if(aux[1] != 0)
                    ttp[1] += aux[i];

                if(aux[2] != 0)
                    ttp[2] += aux[i];

                aux[i] -= aux[i];
            }
        }

        rodada--;
    }

    cout << endl;

    //Exibição e Chaveamento
    for(int i=0; i<3; i++){
        cout << endl << "==================================================" << endl;
        cout << "Processo P" << (i+1) << ":" << endl;
        cout << "Tempo Total de Duração: " << ttp[i] << endl;
        cout << "Chaveamento: " << (ttp[i] - process[i]) << endl;
    }

    cout << endl << endl;

    system("pause");
    return 0;
}