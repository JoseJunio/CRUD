<html>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <f:view>
        <head>
            <title>Login</title>
        </head>
        <body background="resources/restrict/images/background.png">
            <div id="topo">                
            </div>  
            
            <div style="padding: 100px 0 0 470px;">
                <h:form>
                    <h1>Administrador</h1>
                    <table>
                        <tr>
                            <td>Usuario:</td>
                            <td><h:inputText size="35" value="#{usuarioBean.nome}"/></td>
                        </tr>
                        <tr>
                            <td>Senha:</td>
                            <td><h:inputSecret size="35" value="#{usuarioBean.senha}"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><h:commandButton value="Acessar" 
                                             action="#{usuarioBean.verificarUsuario}"/></td>
                        </tr>
                    </table>
                </h:form>
            </div>
        </body>
    </f:view>
</html>