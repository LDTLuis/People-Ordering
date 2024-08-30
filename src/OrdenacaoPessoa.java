import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoPessoa {

    private List<Pessoa> pessoaList;

    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List <Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorAltura, new ComparatorPorALtura());
        return pessoasPorAltura;

    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();

        ordenacaoPessoa.adicionarPessoa("Carlos Alberto", 20, 1.80);
        ordenacaoPessoa.adicionarPessoa("Gustavo", 24, 1.76);
        ordenacaoPessoa.adicionarPessoa("Ribeiro", 18, 1.75);
        ordenacaoPessoa.adicionarPessoa("Angélica", 28, 1.56);
        ordenacaoPessoa.adicionarPessoa("Paulo", 31, 1.92);

        System.out.println(ordenacaoPessoa.ordenarPorIdade());

    }
}

class ComparatorPorALtura implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p1.getAltura(), p2.getAltura());
    }
}