<%@ include file="/common/taglibs.jsp" %>

<title>Vehicle Maintenance Form Example</title>

<p>Please use the form below to modify a Vehicle Maintenance record.</p>

<s:form name="vehicleMaintenanceForm" action="vehicleMaintenance" method="post" validate="true">
    <s:hidden name="vehicleMaintenance.id" value="%{vehicleMaintenance.id}"/>

    <s:textfield label="Name" name="vehicleMaintenance.name"
                 value="%{vehicleMaintenance.name}" required="true" cssClass="text medium"/>

    <s:textfield label="AlarmDate" name="vehicleMaintenance.alarmDate"
                 value="%{vehicleMaintenance.alarmDate}" required="true" cssClass="text medium"/>

    <s:textfield label="StartDate" name="vehicleMaintenance.startDate"
                 value="%{vehicleMaintenance.startDate}" required="false" cssClass="text medium"/>

    <s:textfield label="EndDate" name="vehicleMaintenance.endDate"
                 value="%{vehicleMaintenance.endDate}" required="false" cssClass="text medium"/>



    <li class="buttonBar left">
        <s:submit method="save" value="Save" cssClass="button"/>
        <s:submit method="delete" value="Delete" cssClass="button"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement('contact');
</script>

<div style="margin-top: 50px">
    <s:action name="vehicleMaintenance!list" id="action" namespace="default"/>
    <display:table name="action.vehicleMaintenances" id="row" cellspacing="0" cellpadding="0"
        defaultsort="1" class="table" pagesize="50" requestURI="">

        <%-- Table columns --%>
        <display:column titleKey="vehicleMaintenance.description" sortable="true">
            <s:a href="vehicleMaintenance.html?id=${row.id}"><c:out value="${row.name}" escapeXml="true"/></s:a>
        </display:column>

        <display:setProperty name="paging.banner.item_name" value="vehicleMaintenance" />
        <display:setProperty name="paging.banner.items_name" value="vehicleMaintenances" />
    </display:table>
</div>

</html>