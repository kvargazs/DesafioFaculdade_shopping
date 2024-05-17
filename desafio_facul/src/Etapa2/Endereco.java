package Etapa2;

//CLASSE ENREDECO
public class Endereco {
    String nomeDaRua;
    String cidade;
    String estado;
    String pais;
    String cep;
    String numero;
    String complemento;

    //CONSTRUTOR 1
    public Endereco (String nomeDaRua, String cidade, String estado, String pais, String cep, String numero, String complemento) {
        this.nomeDaRua = nomeDaRua;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    //GETTERS E SETTERS
    public String getNomeDaRua() {
        return nomeDaRua;
    }
    public void setNomeDaRua(String nomeDaRua) {
        this.nomeDaRua = nomeDaRua;
    }


    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }


    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }


    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    //MÉTODO TOSTRING: TRANSFORMA O OBJETO EM STRING
    @Override
    public String toString() {
        return ("Rua "+nomeDaRua+", "+numero+"\nCidade: "+cidade+"\nUF: "+estado+"\nPaís: "+pais+"\nCep: "+cep+"\nComplemento: "+complemento);
    }
}
