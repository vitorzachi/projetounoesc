<%--
    Document   : trabComJSF
    Created on : 09/10/2010, 16:16:10
    Author     : leandro
--%>

<%@taglib uri="http://java.sun.com/jsf/html" prefix = "h" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix = "f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FORMULÁRIO EM JSF</title>
    </head>
    <body>

        <f:view>
            <h:form id="formulario">
                Nome:
                <h:inputText id="nome"
                             value="#{produtor.pr.nome}"
                             required="true"/> <br />
                CPF:
                <h:inputText id="cpf"
                               value="#{produtor.pr.cpf}"
                               required="true"/>
                Endereço:
                <h:inputText id="endereco"
                               value="#{produtor.pr.endereco}"
                               required="true"/>

                <h:commandButton
                    action="#{produtor.criarProdutor}"
                    value="Enviar"
                    id="submit"/>

                <br />
                <h:messages />
            </h:form>
        </f:view>
    </body>
</html>
