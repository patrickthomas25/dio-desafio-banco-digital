
public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");

        Conta contaCorrente = new ContaCorrente(cliente1);
        Conta contaPoupanca = new ContaPoupanca(cliente2);

        // Depósitos
        contaCorrente.depositar(1000.0);
        contaPoupanca.depositar(500.0);

        // Saques
        try {
            contaCorrente.sacar(200.0);
            contaPoupanca.sacar(100.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Transferências
        try {
            contaCorrente.transferir(300.0, contaPoupanca);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Impressão de extratos
        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();

    }
}

