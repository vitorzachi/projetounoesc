<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Novo Usuario</title>
            <link rel="stylesheet" type="text/css" href="/webService/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>New Usuario</h1>
        <h:form>
            <h:inputHidden id="validateCreateField" validator="#{usuario.validateCreate}" value="value"/>
            <h:panelGrid columns="2">
                <h:outputText value="Senha:"/>
                <h:inputText id="senha" value="#{usuario.usuario.senha}" title="Senha" required="true" requiredMessage="The senha field is required." />
                <h:outputText value="Usuario:"/>
                <h:inputText id="usuario" value="#{usuario.usuario.usuario}" title="Usuario" required="true" requiredMessage="The usuario field is required." />

            </h:panelGrid>
            <br />
            <h:commandLink action="#{usuario.create}" value="Create"/>
            <br />
            <br />
            <h:commandLink action="#{usuario.listSetup}" value="Show All Usuario Items" immediate="true"/>
            <br />

        </h:form>
        </body>
    </html>
</f:view>
