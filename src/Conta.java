
public abstract class Conta implements IConta {
	// Atributos
	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;
	
	protected static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numeroConta = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	
	public int getAgencia() {
		return agencia;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}


	public void sacar(double valor) {
		if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        }
		saldo -= valor;
	}
	
	public void depositar(double valor) {
		if (valor <= 0) {
	            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
	    }
		saldo += valor;
	}

	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));		
		System.out.println(String.format("Agencia: %d", this.agencia));		
		System.out.println(String.format("Número: %d", this.numeroConta));		
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
}
