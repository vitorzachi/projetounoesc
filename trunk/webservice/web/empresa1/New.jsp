<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Empresa</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>New Empresa</h1>
        <h:form>
            <h:inputHidden id="validateCreateField" validator="#{empresa.validateCreate}" value="value"/>
            <h:panelGrid columns="2">
                <h:outputText value="Senha:"/>
                <h:inputText id="senha" value="#{empresa.empresa.senha}" title="Senha" />
                <h:outputText value="Cnpj:"/>
                <h:inputText id="cnpj" value="#{empresa.empresa.cnpj}" title="Cnpj" required="true" requiredMessage="The cnpj field is required." />
                <h:outputText value="Cidade:"/>
                <h:selectOneMenu id="cidade" value="#{empresa.empresa.cidade}" title="Cidade" >
                    <f:selectItems value="#{cidade.cidadeItemsAvailableSelectOne}"/>
                </h:selectOneMenu>
                <h:outputText value="Endereco:"/>
                <h:inputText id="endereco" value="#{empresa.empresa.endereco}" title="Endereco" />
                <h:outputText value="NomePessoa:"/>
                <h:inputText id="nomePessoa" value="#{empresa.empresa.nomePessoa}" title="NomePessoa" required="true" requiredMessage="The nomePessoa field is required." />

            </h:panelGrid>
            <br />
            <h:commandLink action="#{empresa.create}" value="Create"/>
            <br />
            <br />
            <h:commandLink action="#{empresa.listSetup}" value="Show All Empresa Items" immediate="true"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
