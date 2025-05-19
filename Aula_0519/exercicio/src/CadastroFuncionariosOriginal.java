import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CadastroFuncionariosOriginal {
	private List<Funcionario> lstf;

	public CadastroFuncionariosOriginal() {
		lstf = new LinkedList<>();

		Random r = new Random();

		for (int i = 0; i < 40; i++) {
			int matricula = r.nextInt(1000) + 100;
			String nome = "Fulano" + i;
			boolean insalubridade = r.nextBoolean();
			int nroDep = r.nextInt(3);
			double salBase = (r.nextDouble() * 15000) + 500;
			Funcionario f = new Funcionario(matricula, nome, salBase, nroDep, insalubridade);
			lstf.add(f);
		}
	}

	public List<Funcionario> getFuncionarios() {
		return Collections.unmodifiableList(lstf);
	}

	@Override
	public String toString() {
		return "CadastroFuncionarios [lstf=" + lstf + "]";
	}

	// 2a
	public List<Funcionario> getInsalubridadeDependentes() {
		List<Funcionario> lstResult = lstf.stream()
										  .filter(f->f.getInsalubridade())
										  .filter(f->f.getNroDependentes()>0)
										  .toList();
		return lstResult;
	}

	// 2b
	public long quantidadeFuncionariosComDependentes() {
		return lstf.stream().filter(f->f.getNroDependentes()>0).count();
	}

	// 2c
	public double somatorioSalarioBruto() {		
		return lstf.stream()
		           .filter(f->f.getSalarioBruto()>5000)
				   .mapToDouble(f->f.getSalarioBruto())
				   .sum();
	}

	// 2d
	public void aumentaSalarioInsalubres() {
		lstf.stream().filter(f->f.getInsalubridade()).forEach(f->f.aumentaSalBase(1.2));
	}

	// 2e
	public List<String> getNomeMatriculaSalarioBrutoMaiorQueBase() {
		return lstf.stream()
		           .filter(f-> (f.getSalarioBase()*1.1) >= f.getSalarioBruto())
				   .map(f -> (String) (f.getNome()+ " - " + f.getMatricula() +" -> SB:R$ "+f.getSalarioBruto()+"; SL:R$ "+f.getSalarioBase() ))
				   .toList();
	}

	// 2f
	public double mediaSalarialDosQueNaoTemInsalubridade() {
		return 0;
	}

	// 2g
	public List<String> nomesDosQueTemMatriculaMenorQue500() {
		return new ArrayList<String>();
	}

	// 2h
	public double getSalarioLiquido(int matricula) {
		return 0;
	}
}
