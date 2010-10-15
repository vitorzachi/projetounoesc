<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Produtor</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Editing Produtor</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Cpf:"/>
                <h:inputText id="cpf" value="#{produtor.produtor.cpf}" title="Cpf" required="true" requiredMessage="The cpf field is required." />
                <h:outputText value="Cidade:"/>
                <h:selectOneMenu id="cidade" value="#{produtor.produtor.cidade}" title="Cidade" >
                    <f:selectItems value="#{cidade.cidadeItemsAvailableSelectOne}"/>
                </h:selectOneMenu>
                <h:outputText value="Endereco:"/>
                <h:inputText id="endereco" value="#{produtor.produtor.endereco}" title="Endereco" />
                <h:outputText value="Id:"/>
                <h:outputText value="#{produtor.produtor.id}" title="Id" />
                <h:outputText value="NomePessoa:"/>
                <h:inputText id="nomePessoa" value="#{produtor.produtor.nomePessoa}" title="NomePessoa" required="true" requiredMessage="The nomePessoa field is required." />

            </h:panelGrid>
            <br />
            <h:commandLink action="#{produtor.edit}" value="Save">
                <f:param name="jsfcrud.currentProdutor" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][produtor.produtor][produtor.converter].jsfcrud_invoke}"/>
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{produtor.detailSetup}" value="Show" immediate="true">
                <f:param name="jsfcrud.currentProdutor" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][produtor.produtor][produtor.converter].jsfcrud_invoke}"/>
            </h:commandLink>
            <br />
            <h:commandLink action="#{produtor.listSetup}" value="Show All Produtor Items" immediate="true"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>