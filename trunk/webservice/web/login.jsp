<%-- 
    Document   : login
    Created on : 16/10/2010, 11:43:47
    Author     : leandro
--%>

<%@ include file="/cabecalho.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix = "h" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix = "f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="default.css" rel="stylesheet" type="text/css" />
        
            </head>
            <body>
            <div id="login">

                <h:form id="formulario">

            <h2>Acesso ao sistema</h2>

            <fieldset>

            <legend> Entre com seu usuário e senha </legend>
            <br />
            <label>Usuário</label>


            <h:inputText id="login"
                             value="#{loginBean.login}"
                             required="true"/>
            <br />
            <label>Senha</label>

            <h:inputSecret id="senha"
                        value="#{loginBean.senha}"
                             required="true"/>



           <h:commandButton
                    action="#{loginBean.acao}"
                    value="Enviar"
                    id="submit"/>

            </fieldset>
           <h:messages />
            </h:form>
            </div>
            </body>
            </html>
            <%@ include file="/rodape.jsp"%>
            </f:view>