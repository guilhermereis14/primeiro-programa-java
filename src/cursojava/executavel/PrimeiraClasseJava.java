package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {
	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<Aluno>(); // criando a lista de alunos

		/*
		 * List<Aluno> alunosAprovados = new ArrayList<Aluno>(); // criando a lista de
		 * alunos Aprovados List<Aluno> alunosReprovados = new ArrayList<Aluno>(); //
		 * criando a lista de alunos Reprovados List<Aluno> alunosRecuperacao = new
		 * ArrayList<Aluno>(); // criando a lista de alunos em Recuperaddão
		 */

		/*
		 * Utilizado um mapa para armezenar os valores dos alunos aprovados, reprovados
		 * e em recuperação
		 * 
		 */
		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

		for (int qtd = 1; qtd <= 5; qtd++) { // definindo o total de 2 alunos

			Aluno aluno1 = new Aluno(); /* instanciando o obj aluno */

			String nome = JOptionPane.showInputDialog("Nome do aluno " + qtd + ": ");

			aluno1.setNome(nome);

			/*
			 * Rotina para adicionar as diciplinas e suas respectivas notas dinamicamente
			 */

			for (int i = 1; i <= 1; i++) {

				/*
				 * Recebendo os valores pelo usuário
				 */
				String nomeDisciplina = JOptionPane.showInputDialog("Informe a Disciplina " + i + ":");
				String notaDisciplina = JOptionPane.showInputDialog("Informe a nota da Disciplina " + i + ":");

				/*
				 * Instanciando o objeto disciplina, adicionando os valores informados no
				 * teclado
				 */
				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.valueOf(notaDisciplina));

				/*
				 * Adicionado os valores na lista
				 */
				aluno1.getDisciplinas().add(disciplina);
			}

			/*
			 * Rotina para remover uma disciplina da lista
			 */

			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
			if (escolha == 0) {/* 0 - SIM / 1 - NÃO */
				int continuarRemover = 0;
				int posicao = 1;
				while (continuarRemover == 0) {
					String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina? 1, 2, 3 ou 4");
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
					posicao++;
					continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar remover?");
				}
			}

			alunos.add(aluno1); // adicionando o registro do aluno na lista "alunos"
		}
		/*
		 * 
		 * for (int pos = 0; pos < alunos.size(); pos++) {//percorrendo a lista por
		 * posição f Aluno aluno = alunos.get(pos);
		 * System.out.println(aluno.toString()); System.out.println("Média: " +
		 * aluno.getMediaNota()); System.out.println("Resultado: "
		 * +aluno.getAlunoAprovado2()); System.out.println(
		 * "--------------------------------------------------------------------------")
		 * ; }
		 */

		/*
		 * Inicializando o "mapa" com as listas de aprovados, reprovados e em
		 * recuperação
		 * 
		 */

		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

		for (Aluno aluno : alunos) { /* Separando os alunos em listas */
			if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				// alunosAprovados.add(aluno);
				maps.get(StatusAluno.APROVADO).add(aluno);// add aluno aprovado no maps
			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				// alunosRecuperacao.add(aluno);
				maps.get(StatusAluno.RECUPERACAO).add(aluno);// add aluno em recuperação no maps
			} else {
				// alunosReprovados.add(aluno);
				maps.get(StatusAluno.REPROVADO).add(aluno);// add aluno reprovado no maps
			}
		}
		/* Apresentando a lista de alunos na tela para o usário */

		System.out.println("----------- ALUNOS APROVADOS --------------");
		for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
			System.out.println("Aluno: " + aluno.getNome() + " Média: " + aluno.getMediaNota() + " Status: "
					+ aluno.getAlunoAprovado2());
		}

		System.out.println("----------- ALUNOS REPROVADOS --------------");
		for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
			System.out.println("Aluno: " + aluno.getNome() + " Média: " + aluno.getMediaNota() + " Status: "
					+ aluno.getAlunoAprovado2());
		}

		System.out.println("----------- ALUNOS EM RECUPERAÇÃO --------------");
		for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
			System.out.println("Aluno: " + aluno.getNome() + " Média: " + aluno.getMediaNota() + " Status: "
					+ aluno.getAlunoAprovado2());
		}
	}

}
