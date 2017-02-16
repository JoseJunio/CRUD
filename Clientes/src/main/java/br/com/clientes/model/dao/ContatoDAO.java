
package br.com.clientes.model.dao;
import br.com.contatovirtual.model.entities.Contato;
import br.com.contatovirtual.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="contato")
@SessionScoped
public class ContatoDAO implements Serializable{
    private static final long serialVerisonUID = 1L;
    
    private Contato contato = new Contato();
    private List<Contato> contatos;
    
    public ContatoDAO(){     
    }
    
    private InterfaceDAO<Contato> contatoDAO(){
        InterfaceDAO<Contato> contatoDAO = new HibernateDAO<Contato>(Contato.class, FacesContextUtil.getRequestSession());
        return contatoDAO;
    }
    
     public String limpaContato() {
        contato= new Contato();
        return editContato();
    }
    
    public String editContato(){
        return "/restrict/cadastracontato.faces";
    }
    
    public String addContato(){
        if(contato.getIdContato()==null || contato.getIdContato()==0){
            insertContato();
        }else{
            updateContato();
        }
        limpContato();
        return null;
    }
    
    private void insertContato(){
        contatoDAO().save(contato);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }
    
    private void updateContato(){
        contatoDAO().update(contato);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
   public List<Contato> getContato() {
         contatos = contatoDAO().getEntities();
        return contatos;
    }
    
    public void deleteContato(){
        contatoDAO().remove(contato);
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
    
    
}