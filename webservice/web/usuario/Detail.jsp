<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Usuario Detail</title>
            <link rel="stylesheet" type="text/css" href="/webService/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Usuario Detail</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Id:"/>
                <h:outputText value="#{usuario.usuario.id}" title="Id" />
                <h:outputText value="Senha:"/>
                <h:outputText value="#{usuario.usuario.senha}" title="Senha" />
                <h:outputText value="Usuario:"/>
                <h:outputText value="#{usuario.usuario.usuario}" title="Usuario" />


            </h:panelGrid>
            <br />
            <h:commandLink action="#{usuario.destroy}" value="Destroy">
                <f:param name="jsfcrud.currentUsuario" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][usuario.usuario][usuario.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{usuario.editSetup}" value="Edit">
                <f:param name="jsfcrud.currentUsuario" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][usuario.usuario][usuario.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <h:commandLink action="#{usuario.createSetup}" value="New Usuario" />
            <br />
            <h:commandLink action="#{usuario.listSetup}" value="Show All Usuario Items"/>
            <br />

        </h:form>
        </body>
    </html>
</f:view>
