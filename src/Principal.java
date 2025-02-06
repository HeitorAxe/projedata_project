import entity.Funcionario;
import utils.FuncionarioUtils;

import java.math.BigDecimal;
import java.security.KeyPair;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        funcionarios.removeIf(f -> f.getNome().equals("João"));

        System.out.println("Funcionários: ");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
            System.out.println();
        }
        System.out.println("==========================================");

        FuncionarioUtils.aumentarSalario(funcionarios, 10);

        Map<String, List<Funcionario>> funcionariosPorFuncao = FuncionarioUtils.agruparPorFuncao(funcionarios);
        FuncionarioUtils.imprimirFuncionariosPorFuncao(funcionariosPorFuncao);

        List<Funcionario> funcionariosOutubroDezembro = FuncionarioUtils.getFuncionariosAniversarioOutubroDezembro(funcionarios);
        System.out.println("\nFuncionários Nascidos em Outubro e Dezembro: \n");
        FuncionarioUtils.imprimirFuncionarios(funcionariosOutubroDezembro);

        Funcionario funcionarioMaisVelho = FuncionarioUtils.getFuncionarioMaisVelho(funcionarios);
        FuncionarioUtils.imprimirFuncionarioMaisVelho(funcionarioMaisVelho);

        FuncionarioUtils.ordenarPorNome(funcionarios);
        System.out.println("\nFuncionarios em Ordem Alfabética: \n");
        FuncionarioUtils.imprimirFuncionarios(funcionarios);

        BigDecimal totalSalarios = FuncionarioUtils.calcularTotalSalarios(funcionarios);
        System.out.println("\nSalários combinados: R$" + totalSalarios + "\n");

        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        FuncionarioUtils.imprimirSalariosMinimos(funcionarios, salarioMinimo);
    }
}
