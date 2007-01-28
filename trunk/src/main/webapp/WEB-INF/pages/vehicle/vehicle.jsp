<%@ include file="/common/taglibs.jsp" %>

<title>Vehicle Form Example</title>

<p>Please use the form below to modify a Vehicle's information.</p>

<s:form name="vehicleForm" action="vehicle" method="post" validate="true">
    <s:hidden name="vehicle.id" value="%{vehicle.id}"/>

    <s:textfield label="Name" name="vehicle.name"
                 value="%{vehicle.name}" required="true" cssClass="text medium"/>

    <s:textfield label="Make" name="vehicle.make"
                 value="%{vehicle.make}" required="true" cssClass="text medium"/>

    <s:textfield label="Model" name="vehicle.model"
                 value="%{vehicle.model}" required="false" cssClass="text medium"/>

    <s:textfield label="Year" name="vehicle.year"
                 value="%{vehicle.year}" required="false" cssClass="text medium"/>

    <s:textfield label="VIN" name="vehicle.VIN"
                 value="%{vehicle.VIN}" required="false" cssClass="text medium"/>


    <li class="buttonBar left">
        <s:submit method="save" value="Save" cssClass="button"/>
        <s:submit method="delete" value="Delete" cssClass="button"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement('contact');
</script>

<div style="margin-top: 50px">
    <s:action name="vehicle!list" id="action" namespace="default"/>
    <display:table name="action.vehicles" id="row" cellspacing="0" cellpadding="0"
        defaultsort="1" class="table" pagesize="50" requestURI="">

        <%-- Table columns --%>
        <display:column titleKey="vehicle.description" sortable="true">
            <s:a href="vehicle.html?id=${row.id}"><c:out value="${row.year} ${row.make} ${row.model}" escapeXml="true"/></s:a>
        </display:column>

        <display:setProperty name="paging.banner.item_name" value="vehicle" />
        <display:setProperty name="paging.banner.items_name" value="vehicles" />
    </display:table>
</div>

</html>