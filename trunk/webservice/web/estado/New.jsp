<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<%@ include file="/cabecalho.jsp"%>

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Estado</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>New Estado</h1>
        <h:form>
            <h:inputHidden id="validateCreateField" validator="#{estado.validateCreate}" value="value"/>
            <h:panelGrid columns="2">
                <h:outputText value="NomeEstado:"/>
                <h:inputText id="nomeEstado" value="#{estado.estado.nomeEstado}" title="NomeEstado" required="true" requiredMessage="The nomeEstado field is required." />
                <h:outputText value="SiglaEstado:"/>
                <h:inputText id="siglaEstado" value="#{estado.estado.siglaEstado}" title="SiglaEstado" required="true" requiredMessage="The siglaEstado field is required." />

            </h:panelGrid>
            <br />
            <h:commandLink action="#{estado.create}" value="Create"/>
            <br />
            <br />
            <h:commandLink action="#{estado.listSetup}" value="Show All Estado Items" immediate="true"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
<%@ include file="/rodape.jsp"%>