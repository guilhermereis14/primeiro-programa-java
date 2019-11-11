package cursojava.classes;

import cursojava.interfaces.PermitrAcesso; //importando a interface criada "PermitrAcesso"

public class Secretario extends Pessoa implements PermitrAcesso {
	private String registro;
	private String nivelCargo;
	private String experiencia;
	

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNivelCargo() {
		return nivelCargo;
	}

	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public String toString() {
		return "Secretario [registro=" + registro + ", nivelCargo=" + nivelCargo + ", experiencia=" + experiencia
				+ ", nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", numeroCpf="
				+ numeroCpf + ", registroGeral=" + registroGeral + ", nomePai=" + nomePai + ", nomeMae=" + nomeMae
				+ "]";
	}

	/*
	 * Método do contrato de autenticação
	 */
	@Override
	public boolean autenticar(String login, String senha) {
		// TODO Auto-generated method stub
		return login.equals("admin") && senha.equals("admin");
	}

}
