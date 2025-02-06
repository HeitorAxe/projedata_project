package utils;
import entity.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioUtils {

    public static void aumentarSalario(List<Funcionario> funcionarios, double percentual) {
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(BigDecimal.valueOf(1 + percentual / 100))));
    }

    public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public static void imprimirFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFuncionários com função: " + funcao);
            lista.forEach(f -> System.out.println("\n\t" + f.toString().replace("\n", "\n\t")));
            System.out.println("\n==========================================");
        });
    }

    public static List<Funcionario> getFuncionariosAniversarioOutubroDezembro(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .toList();
    }

    public static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(f -> {
            System.out.println(f);
            System.out.println();
        });
        System.out.println("==========================================");
    }

    public static Funcionario getFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        return funcionarios.stream().min(Comparator.comparing(Funcionario::getDataNascimento)).orElse(null);
    }

    public static void imprimirFuncionarioMaisVelho(Funcionario funcionarioMaisVelho) {
        if (funcionarioMaisVelho != null) {
            System.out.println("\nFuncionário mais velho: " + funcionarioMaisVelho.getNome() + "\nIdade: " +
                    (LocalDate.now().getYear() - funcionarioMaisVelho.getDataNascimento().getYear()));
            System.out.println("\n==========================================");
        }
    }

    public static void ordenarPorNome(List<Funcionario> funcionarios) {
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
    }

    public static BigDecimal calcularTotalSalarios(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        funcionarios.forEach(f -> System.out.println(f.getNome() + " recebe " +
                f.getSalario().divide(salarioMinimo, BigDecimal.ROUND_HALF_UP) + " salários mínimos"));
    }
}
