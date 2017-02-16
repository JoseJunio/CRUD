package br.com.clientes.model.dao;
import br.com.clientes.model.entities.Cliente;
import br.com.clientes.model.entities.Contato;
import br.com.clientes.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="cliente")
@SessionScoped
public class ClienteDAO implements Serializable{
    private static final long serialVerisonUID = 1L;
    
    private Cliente cliente = new Cliente();
    private List<Cliente> clientes;
    
    public ClienteDAO(){     
    }
    
    private InterfaceDAO<Cliente> clienteDAO(){
        InterfaceDAO<Cliente> clienteDAO = new HibernateDAO<Cliente>(Cliente.class, FacesContextUtil.getRequestSession());
        return clienteDAO;
    }
    
     public String limpCliente() {
        cliente = new Cliente();
        return editCliente();
    }
    
    public String editCliente(){
        return "/restrict/cadastracliente.faces";
    }
    
    public String addCliente(){
        if(cliente.getId()==null || cliente.getId()==0){
            insertCliente();
        }else{
            updateCliente();
        }
        limpCliente();
        return null;
    }
    
    private void insertCliente(){
        clienteDAO().save(cliente);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }
    
    private void updateCliente(){
        clienteDAO().update(cliente);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
   public List<Cliente> getClientes() {
         clientes = clienteDAO().getEntities();
        return clientes;
    }
    
    public void deleteCliente(){
        clienteDAO().remove(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}

