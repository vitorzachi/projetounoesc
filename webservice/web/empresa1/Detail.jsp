<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Empresa Detail</title>
            <link rel="stylesheet" type="text/css" href="/webservice/jsfcrud.jsf" />
        </head>
        <body>
        <h:panelGroup id="messagePanel" layout="block">
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
        </h:panelGroup>
        <h1>Empresa Detail</h1>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Senha:"/>
                <h:outputText value="#{empresa.empresa.senha}" title="Senha" />
                <h:outputText value="Cnpj:"/>
                <h:outputText value="#{empresa.empresa.cnpj}" title="Cnpj" />
                <h:outputText value="Cidade:"/>
                <h:panelGroup>
                    <h:outputText value="#{empresa.empresa.cidade}"/>
                    <h:panelGroup rendered="#{empresa.empresa.cidade != null}">
                        <h:outputText value=" ("/>
                        <h:commandLink value="Show" action="#{cidade.detailSetup}">
                            <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][empresa.empresa][empresa.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][empresa.empresa.cidade][cidade.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.relatedController" value="empresa"/>
                            <f:param name="jsfcrud.relatedControllerType" value="br.unoesc.ws.configs.EmpresaController1"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Edit" action="#{cidade.editSetup}">
                            <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][empresa.empresa][empresa.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][empresa.empresa.cidade][cidade.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.relatedController" value="empresa"/>
                            <f:param name="jsfcrud.relatedControllerType" value="br.unoesc.ws.configs.EmpresaController1"/>
                        </h:commandLink>
                        <h:outputText value=" "/>
                        <h:commandLink value="Destroy" action="#{cidade.destroy}">
                            <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][empresa.empresa][empresa.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.currentCidade" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][empresa.empresa.cidade][cidade.converter].jsfcrud_invoke}"/>
                            <f:param name="jsfcrud.relatedController" value="empresa"/>
                            <f:param name="jsfcrud.relatedControllerType" value="br.unoesc.ws.configs.EmpresaController1"/>
                        </h:commandLink>
                        <h:outputText value=" )"/>
                    </h:panelGroup>
                </h:panelGroup>
                <h:outputText value="Endereco:"/>
                <h:outputText value="#{empresa.empresa.endereco}" title="Endereco" />
                <h:outputText value="Id:"/>
                <h:outputText value="#{empresa.empresa.id}" title="Id" />
                <h:outputText value="NomePessoa:"/>
                <h:outputText value="#{empresa.empresa.nomePessoa}" title="NomePessoa" />


            </h:panelGrid>
            <br />
            <h:commandLink action="#{empresa.destroy}" value="Destroy">
                <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][empresa.empresa][empresa.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <br />
            <h:commandLink action="#{empresa.editSetup}" value="Edit">
                <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['br.unoesc.ws.configs.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][empresa.empresa][empresa.converter].jsfcrud_invoke}" />
            </h:commandLink>
            <br />
            <h:commandLink action="#{empresa.createSetup}" value="New Empresa" />
            <br />
            <h:commandLink action="#{empresa.listSetup}" value="Show All Empresa Items"/>
            <br />
            <br />
            <h:commandLink value="Index" action="welcome" immediate="true" />

        </h:form>
        </body>
    </html>
</f:view>
