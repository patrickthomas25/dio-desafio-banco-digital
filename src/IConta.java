
public interface IConta {
	void sacar(double valor) throws IllegalArgumentException;
    
    void depositar(double valor) throws IllegalArgumentException;
    
    void transferir(double valor, Conta contaDestino) throws IllegalArgumentException;

	void imprimirExtrato();
}
