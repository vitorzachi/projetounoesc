<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ include file="/cabecalho.jsp"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Lista de Produtores</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Lista de Produtores</h1>
        <h:form styleClass="jsfcrud_list_form">
            <h:outputText escape="false" value="(Nenhum Produtor Cadastrado)<br />" rendered="#{produtor.pagingInfo.itemCount == 0}" />
            <h:panelGroup rendered="#{produtor.pagingInfo.itemCount > 0}">
                <h:outputText value="Item #{produtor.pagingInfo.firstItem + 1}..#{produtor.pagingInfo.lastItem} de #{produtor.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{produtor.prev}" value="Anterior #{produtor.pagingInfo.batchSize}" rendered="#{produtor.pagingInfo.firstItem >= produtor.pagingInfo.batchSize}"/>&nbsp;
                <h:commandLink action="#{produtor.next}" value="Próximo #{produtor.pagingInfo.batchSize}" rendered="#{produtor.pagingInfo.lastItem + produtor.pagingInfo.batchSize <= produtor.pagingInfo.itemCount}"/>&nbsp;
                <h:commandLink action="#{produtor.next}" value="Restante #{produtor.pagingInfo.itemCount - produtor.pagingInfo.lastItem}"
                               rendered="#{produtor.pagingInfo.lastItem < produtor.pagingInfo.itemCount && produtor.pagingInfo.lastItem + produtor.pagingInfo.batchSize > produtor.pagingInfo.itemCount}"/>
                <h:dataTable value="#{produtor.produtorItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Cpf"/>
                        </f:facet>
                        <h:outputText value="#{item.cpf}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Cidade"/>
                        </f:facet>
                        <h:outputText value="#{item.cidade}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Endereco"/>
                        </f:facet>
                        <h:outputText value="#{item.endereco}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Id"/>
                        </f:facet>
                        <h:outputText value="#{item.id}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="NomePessoa"/>
                        </f:facet>
                        <h:outputText value="#{item.nomePessoa}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText escape="false" value="&nbsp;"/>
                        </f:facet>
                        <h:commandLink value="Mostrar" action="#{produtor.detailSetup}">
                            <f:param name="jsfcrud.currentProdutor" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][produtor.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Editar" action="#{produtor.editSetup}">
                            <f:param name="jsfcrud.currentProdutor" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][produtor.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Excluir" action="#{produtor.destroy}">
                            <f:param name="jsfcrud.currentProdutor" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][produtor.converter].jsfcrud_invoke}"/>
                        </h:commandLink>
                    </h:column>

                </h:dataTable>
            </h:panelGroup>
            <br />
            <h:commandLink action="#{produtor.createSetup}" value="Novo Produtor"/>
            <br />
            <br />
            <h:commandLink value="Início" action="welcome" immediate="true" />


        </h:form>
        </body>
    </html>
</f:view>
<%@ include file="/rodape.jsp"%>