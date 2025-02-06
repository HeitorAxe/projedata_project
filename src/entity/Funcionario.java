package entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {

    private String funcao;
    private BigDecimal salario;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String nascimentoFormatado = this.getDataNascimento().format(formatter);
        String salarioFormatado = String.format("%,.2f", salario)
                .replace(",", "@")
                .replace(".", ",")
                .replace("@", ".");
        return String.format(
             """
            Nome: %s
            Data de Nascimento: %s
            Salário: R$%s
            Função: %s""",
            this.getNome(),
            nascimentoFormatado,
            salarioFormatado,
            this.getFuncao()
        );

    }

}
