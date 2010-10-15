<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ include file="/cabecalho.jsp"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Cidade Detail</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Cidade Detail</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Estado:"/>
                <h:panelGroup>
                    <h:outputText value="#{cidade.cidade.estado}"/>
                    <h:panelGroup rendered="#{cidade.cidade.estado != null}">
                        <h:outputText value=" ("/>
                        <h:commandLink value="Show" action="#{estado.detailSetup}">
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cidade.cidade][cidade.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.currentEstado" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cidade.cidade.estado][estado.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.relatedController" value="cidade"/>
                            <f:param name="jsfcrud.relatedControllerType" value="br.unoesc.ws.configs.CidadeController"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Edit" action="#{estado.editSetup}">
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cidade.cidade][cidade.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.currentEstado" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cidade.cidade.estado][estado.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.relatedController" value="cidade"/>
                            <f:param name="jsfcrud.relatedControllerType" value="br.unoesc.ws.configs.CidadeController"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Destroy" action="#{estado.destroy}">
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cidade.cidade][cidade.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.currentEstado" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cidade.cidade.estado][estado.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.relatedController" value="cidade"/>
                            <f:param name="jsfcrud.relatedControllerType" value="br.unoesc.ws.configs.CidadeController"/>
                        </h:commandLink>
                        <h:outputText value=" )"/>
                    </h:panelGroup>
                </h:panelGroup>
                <h:outputText value="Id:"/>
                <h:outputText value="#{cidade.cidade.id}" title="Id" />
                <h:outputText value="NomeCidade:"/>
                <h:outputText value="#{cidade.cidade.nomeCidade}" title="NomeCidade" />


            </h:panelGrid>
            <br />
            <h:commandLink action="#{cidade.destroy}" value="Destroy">
                <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cidade.cidade][cidade.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{cidade.editSetup}" value="Edit">
                <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cidade.cidade][cidade.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <h:commandLink action="#{cidade.createSetup}" value="New Cidade" />
            <br />
            <h:commandLink action="#{cidade.listSetup}" value="Show All Cidade Items"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
<%@ include file="/rodape.jsp"%>