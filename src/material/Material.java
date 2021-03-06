package material;

import java.util.ArrayList;

import reserva.Reserva;



public class Material {
	
	protected String codigo;
	protected String titulo;
	protected int anoPublicacao;
	protected ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	protected Exemplar[] exemplares;
	
	public void setExemplares(Exemplar[] exemplares) {
		this.exemplares = exemplares;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public void addReserva(Reserva r){
		this.reservas.add(r);
	}

	public int contReservas(){
		return this.reservas.size();
	}

	public Exemplar[] getExemplares() {
		return exemplares;
	}
	
	public int contExemplaresDisp(){
		int cont=0;

		for(int i = 0;i<this.exemplares.length;i++){
			if(exemplares[i].getStatus().equals("Disponível")){
				cont++;
			}
		}
		return cont;
	}
	
	public void excuirReserva(String codUsr){
		
		for (int i=0; i< reservas.size();i++){
			if(reservas.get(i).getUserCod().equals(codUsr)){
				reservas.remove(i);
				return;
			}
		}
		
		
	}
	
	public Exemplar verificaMaterialDisp(){
		for(int i = 0;i<this.exemplares.length;i++){
			if(exemplares[i].getStatus().equals("Disponível")){
				exemplares[i].setStatus("Indisponível");
				return exemplares[i];
			}
		}
		return null;
	}
	
	public int verificaReservaUsr(String usrCod){
		for(int i=0; i<this.reservas.size();i++){
			if(reservas.get(i).getUserCod().equals(usrCod)){
				return i;
			}
		}
		
		return -1;
	}
	
	public void consulta(){
		System.out.println("Material: "+this.titulo);
		int cont = contReservas();
		if(cont==0){
			System.out.println("Reservas = 0");
		}
		else{
			System.out.println(cont+" reservas:");
			for(int i = 0;i<reservas.size();i++){
				reservas.get(i).printaDadosReserva();
			}
		}
		
		System.out.println("Exemplares:");
		if(exemplares==null){
			System.out.println("Não há exemplares deste material.");
			return;
		}
		for(int i=0; i<exemplares.length;i++){
			System.out.println("Código: "+exemplares[i].getCodEx());
			
			if(exemplares[i].getStatus().equals("Indisponível")){
				System.out.println("Emprestado para: "+exemplares[i].getUserName());
			}
		}
	}
	
	public void setMatExemplares(){
		if(this.exemplares != null){
			for(int i=0; i<exemplares.length;i++){
				exemplares[i].setMaterial(this);
			}
		}
	}
	

	
	
}
