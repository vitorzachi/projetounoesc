<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Estado Detail</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Estado Detail</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Id:"/>
                <h:outputText value="#{estado.estado.id}" title="Id" />
                <h:outputText value="NomeEstado:"/>
                <h:outputText value="#{estado.estado.nomeEstado}" title="NomeEstado" />
                <h:outputText value="SiglaEstado:"/>
                <h:outputText value="#{estado.estado.siglaEstado}" title="SiglaEstado" />


            </h:panelGrid>
            <br />
            <h:commandLink action="#{estado.destroy}" value="Destroy">
                <f:param name="jsfcrud.currentEstado" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][estado.estado][estado.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{estado.editSetup}" value="Edit">
                <f:param name="jsfcrud.currentEstado" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][estado.estado][estado.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <h:commandLink action="#{estado.createSetup}" value="New Estado" />
            <br />
            <h:commandLink action="#{estado.listSetup}" value="Show All Estado Items"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
