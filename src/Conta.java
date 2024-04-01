public class Conta {

    Cliente dono = new Cliente();
    double saldo;
    int numero;
    String agencia;
    double limite;
    Operacao[] operacoes = new Operacao[1000];
    boolean depositar(double valor) {
        if(valor > 0.0) {
            this.saldo += valor;
            operacoes[].tipo = 'd';
            operacoes[].valor = valor;
            return true;
        } else {
            return false;
        }
    }


    boolean sacar(double valor) {
        if(valor > 0.0 && valor <= this.saldo) {
            this.saldo -= valor;

            operacoes[].tipo = 's';
            operacoes[].valor = valor;
            return true;
        } else {
            return false;
        }
    }


    boolean transferir(Conta contaDestino, double valor) {
        boolean saqueRealizado = this.sacar(valor);
        if(saqueRealizado) {
            boolean depositoRealizado = contaDestino.depositar(valor);
            return depositoRealizado;
        } else {
            return false;
        }
    }


    void imprimirConta(){
        dono.imprimirCliente();
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);

    }
}