
package br.unoesc.ws.webModelEntrada;

/**classe utilizada para entrada de parametros dos metodos de inclusao de produtor.
 *recebe as chaves de pesquisa dos parametros contidos na classe Produtor
 * e mais outras informacoes necessarias para sua validacao
 *
 * @author vitor
 */
public class ProdutorSampleModel {

    private String nome,cpf,endereco;
    private Long idCidade;

    public ProdutorSampleModel() {
    }

    public ProdutorSampleModel(String nome, String cpf, String endereco, Long idCidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idCidade = idCidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
