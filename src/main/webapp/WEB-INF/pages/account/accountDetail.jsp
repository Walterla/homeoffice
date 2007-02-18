<%@ include file="/common/taglibs.jsp" %>

<head>
    <title>Account Detail</title>
    <%-- Calendar Setup - put in decorator if needed in multiple pages --%>
    <link  href="<c:url value='/styles/calendar.css'/>"  type="text/css"  rel="stylesheet"/>
    <script type="text/javascript" src="<c:url value='/scripts/calendar.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/calendar-setup.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lang/calendar-en.js'/>"></script>
</head>

<p>Please use the form below to modify an account detail's information.</p>

<s:form name="accountDetailForm" action="accountDetail" method="post" validate="true">
    <s:hidden name="accountDetail.id" value="%{accountDetail.id}"/>

    <table>
    <tr><td><s:textfield label="Sequence Number" name="accountDetail.sequenceNumber"
                 value="%{accountDetail.sequenceNumber}" required="true" cssClass="text medium"/></td></tr>

    <tr><td><s:textfield label="Description" name="accountDetail.description"
                 value="%{accountDetail.description}" required="true" cssClass="text medium"/></td></tr>

    <tr><td><s:textfield label="Amount" name="accountDetail.amount"
                 value="%{accountDetail.amount}" required="true" cssClass="text medium"/></td></tr>

    <tr><td><s:textfield label="Transaction Date " name="accountDetail.transDate" id="transDate"
                 value="%{accountDetail.transactionDate}" required="true" cssClass="text medium" /></td>
    <td><img src="images/calendar1.gif" alt="calendar" id="transCal"/></td>
    </tr>
    </table>
    <li class="buttonBar left">
        <s:submit method="save" value="Save" cssClass="button"/>
        <s:submit method="delete" value="Delete" cssClass="button"/>
    </li>


</s:form>

<script type="text/javascript">
    Form.focusFirstElement('accountDetail');
</script>
<script type="text/javascript">
    Form.focusFirstElement('accountDetail');
    Calendar.setup(
        {
            inputField  : "transDate",      // id of the input field
            ifFormat    : "%m/%d/%Y",      // the date format
            button      : "transCal"    // id of the button
        }
            );
</script>

<div style="margin-top: 50px">
    <s:action name="accountDetail!list" id="action" namespace="default"/>
    <display:table name="action.accountDetails" id="row" cellspacing="0" cellpadding="0"
        defaultsort="1" class="table" pagesize="50" requestURI="">
        <%-- Table columns --%>
        <display:column titleKey="accountDetail.description" sortable="true">
            <s:a href="accountDetail.html?id=${row.id}"><c:out value="${row.description}" escapeXml="true"/></s:a>
        </display:column>

        <display:setProperty name="paging.banner.item_name" value="accountDetail" />
        <display:setProperty name="paging.banner.items_name" value="accountDetails" />
    </display:table>
</div>
