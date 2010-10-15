<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ include file="/cabecalho.jsp"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Cidade</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>New Cidade</h1>
        <h:form>
            <h:inputHidden id="validateCreateField" validator="#{cidade.validateCreate}" value="value"/>
            <h:panelGrid columns="2">
                <h:outputText value="Estado:"/>
                <h:selectOneMenu id="estado" value="#{cidade.cidade.estado}" title="Estado" >
                    <f:selectItems value="#{estado.estadoItemsAvailableSelectOne}"/>
                </h:selectOneMenu>
                <h:outputText value="NomeCidade:"/>
                <h:inputText id="nomeCidade" value="#{cidade.cidade.nomeCidade}" title="NomeCidade" required="true" requiredMessage="The nomeCidade field is required." />

            </h:panelGrid>
            <br />
            <h:commandLink action="#{cidade.create}" value="Create"/>
            <br />
            <br />
            <h:commandLink action="#{cidade.listSetup}" value="Show All Cidade Items" immediate="true"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
<%@ include file="/rodape.jsp"%>