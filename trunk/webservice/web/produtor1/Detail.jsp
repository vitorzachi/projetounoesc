<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ include file="/cabecalho.jsp"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Detalhes Produtor</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Detalhes Produtor</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Cpf:"/>
                <h:outputText value="#{produtor.produtor.cpf}" title="Cpf" />
                <h:outputText value="Cidade:"/>
                <h:panelGroup>
                    <h:outputText value="#{produtor.produtor.cidade}"/>
                    <h:panelGroup rendered="#{produtor.produtor.cidade != null}">
                        <h:outputText value=" ("/>
                        <h:commandLink value="Mostrar" action="#{cidade.detailSetup}">
                            <f:param name="jsfcrud.currentProdutor" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][produtor.produtor][produtor.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][produtor.produtor.cidade][cidade.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.relatedController" value="produtor"/>
                            <f:param name="jsfcrud.relatedControllerType" value="br.unoesc.ws.configs.ProdutorController1"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Editar" action="#{cidade.editSetup}">
                            <f:param name="jsfcrud.currentProdutor" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][produtor.produtor][produtor.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][produtor.produtor.cidade][cidade.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.relatedController" value="produtor"/>
                            <f:param name="jsfcrud.relatedControllerType" value="br.unoesc.ws.configs.ProdutorController1"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Excluir" action="#{cidade.destroy}">
                            <f:param name="jsfcrud.currentProdutor" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][produtor.produtor][produtor.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][produtor.produtor.cidade][cidade.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.relatedController" value="produtor"/>
                            <f:param name="jsfcrud.relatedControllerType" value="br.unoesc.ws.configs.ProdutorController1"/>
                        </h:commandLink>
                        <h:outputText value=" )"/>
                    </h:panelGroup>
                </h:panelGroup>
                <h:outputText value="Endereco:"/>
                <h:outputText value="#{produtor.produtor.endereco}" title="Endereco" />
                <h:outputText value="Id:"/>
                <h:outputText value="#{produtor.produtor.id}" title="Id" />
                <h:outputText value="NomePessoa:"/>
                <h:outputText value="#{produtor.produtor.nomePessoa}" title="NomePessoa" />


            </h:panelGrid>
            <br />
            <h:commandLink action="#{produtor.destroy}" value="Excluir">
                <f:param name="jsfcrud.currentProdutor" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][produtor.produtor][produtor.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{produtor.editSetup}" value="Edit">
                <f:param name="jsfcrud.currentProdutor" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][produtor.produtor][produtor.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <h:commandLink action="#{produtor.createSetup}" value="Novo Produtor" />
            <br />
            <h:commandLink action="#{produtor.listSetup}" value="Mostrar Todos Produtores"/>
            <br />
            <br />
            <h:commandLink value="Início" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
<%@ include file="/rodape.jsp"%>