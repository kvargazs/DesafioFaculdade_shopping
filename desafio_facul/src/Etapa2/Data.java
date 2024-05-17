package Etapa2;

//CLASSE DATA
public class Data {
    int dia;
    int mes;
    int ano;

    //CONSTRUTOR 1
    public Data(int dia, int mes, int ano) {
        if (validarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Etapa2.Data inválida! Alterando para a data padrão: 1/1/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    //VERIFICA SE O ANO É BISSEXTO
    public boolean verificaAnoBissexto() {
        return (ano % 4 == 0) || (ano % 400 == 0 && ano % 100 != 0);
    }

    //VERIFICA A DATA
    private boolean validarData(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12 || dia < 1) {
            return false;
        }
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (verificaAnoBissexto() && mes == 2) {
            diasPorMes[1] = 29;//TROCA O VALOR DO MES 2 PARA 29
        }
        return dia <= diasPorMes[mes - 1];//SUBTRAI DO PARAMETRO DADO, FORNECENDO O INDICE CORRETO DO ARRAY
    }

    //GETTERS E SETTERS
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }


    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }


    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }


    //MÉTODO TOSTRING: TRANSFORMA O OBJETO EM STRING
    @Override
    public String toString() {
        return ("Etapa2.Data: "+dia+"/"+mes+"/"+ano);
    }
}
