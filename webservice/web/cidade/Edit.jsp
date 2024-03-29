<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ include file="/cabecalho.jsp"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editar Cidade</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Editar Cidade</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Estado:"/>
                <h:selectOneMenu id="estado" value="#{cidade.cidade.estado}" title="Estado" >
                    <f:selectItems value="#{estado.estadoItemsAvailableSelectOne}"/>
                </h:selectOneMenu>
                <h:outputText value="Id:"/>
                <h:outputText value="#{cidade.cidade.id}" title="Id" />
                <h:outputText value="NomeCidade:"/>
                <h:inputText id="nomeCidade" value="#{cidade.cidade.nomeCidade}" title="NomeCidade" required="true" requiredMessage="O Campo nomeCidade é Necessário." />

            </h:panelGrid>
            <br />
            <h:commandLink action="#{cidade.edit}" value="Salvar">
                <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cidade.cidade][cidade.converter].jsfcrud_invoke}"/>
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{cidade.detailSetup}" value="Mostrar" immediate="true">
                <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][cidade.cidade][cidade.converter].jsfcrud_invoke}"/>
            </h:commandLink>
            <br />
            <h:commandLink action="#{cidade.listSetup}" value="Mostrar Todas as Cidades" immediate="true"/>
            <br />
            <br />
            <h:commandLink value="Início" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
<%@ include file="/rodape.jsp"%>