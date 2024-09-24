package aula1209;


import java.time.LocalDate;
import java.time.Period;


public class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate nascimento;
    public Pessoa(String nome, String cpf, String email, String telefone, LocalDate nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.nascimento = nascimento;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNascimento(LocalDate data){
        this.nascimento = data;
    }
    public LocalDate getNascimento(){
        return this.nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public boolean validarCPF(String cpf) {
        // remover caracteres não numericos
        cpf = cpf.replaceAll("\\D", "");
        
        // verificar se o CPF tem 11 digitos
        if (cpf.length() != 11){
            return false;
        }
        // verificar se todos os digitoss sao iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        // calculo de digitos verificadores
        int[] pesos1 = {10,9,8,7,6,5,4,3,2};
        int [] pesos2 = {11,10,9,8,7,6,5,4,3,2};
        
        try {
            int soma1 = 0, soma2 = 0;
            for (int i = 0; i < 9; i++) {
                
                int num = Character.getNumericValue(cpf.charAt(i));
                soma1 += num * pesos1[i];
                soma2 += num * pesos2[i];
            }
            
            // calculo do primeiro ddigito verificador
            int digito1 = (soma1 % 11 < 2) ? 0: 11 - (soma1 % 11);
            
            // Adiciona o primeiro digito verificador À soma para o segundo calculo
            soma2 += digito1 * pesos2[9];
            int digito2 = (soma2 % 11 < 2) ? 0 : 11 - (soma2 % 11);
            
            // verificar se os digitos calculados sao iguais aos ddo cpf
            return digito1 == Character.getNumericValue(cpf.charAt(9)) &&
                    digito2 == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        char[] eMail = email.toCharArray();
        int contArr = 0;
        for(int i=0; i<=eMail.length-1 ;i++){
            if(eMail[i]=='@'){
                contArr++;
            }
        }
        if(contArr==1){
            this.email = email;
        }else{
            System.out.println("e-mail inválido");
        }
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        boolean saoDigitos = true;
        char[] caracteres = telefone.toCharArray();
        for(int i = 0; i < caracteres.length; i++){
            saoDigitos &= Character.isDigit(caracteres[i]);
            
        }
        if(saoDigitos && telefone.length()==11){
            this.telefone = telefone;
        }else{
            System.out.println("Formato ou telefone invalido");
        }
    }
    public int getIdade(){
        Period periodo = Period.between(this.nascimento,LocalDate.now());
        return periodo.getYears();
    }
    public void exibirDados() {
        System.out.println("Idade: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Idade: " + getIdade() + "anos");
    }
}
