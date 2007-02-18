<%@ include file="/common/taglibs.jsp" %>

<head>
    <title>Account</title>
    <%-- Calendar Setup - put in decorator if needed in multiple pages --%>
    <link  href="<c:url value='/styles/calendar.css'/>"  type="text/css"  rel="stylesheet"/>
    <script type="text/javascript" src="<c:url value='/scripts/calendar.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/calendar-setup.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lang/calendar-en.js'/>"></script>
</head>

<p>Please use the form below to modify an account's information.</p>

<s:form name="accountForm" action="account" method="post" validate="true">
    <s:hidden name="account.id" value="%{account.id}"/>

    <s:textfield label="Account Name" name="account.accountName"
                 value="%{account.accountName}" required="true" cssClass="text medium"/>

    <s:textfield label="Account Number" name="account.accountNumber"
                 value="%{account.accountNumber}" required="false" cssClass="text medium"/>

    <s:textfield label="Optional Number" name="account.optionalNumber"
                 value="%{account.optionalNumber}" required="false" cssClass="text medium"/>

    <s:textfield label="Balance" name="account.balance"
                 value="%{account.balance}" required="false" cssClass="text medium"/>

    <s:textfield label="Budget Billing" name="account.budgetBilling"
                 value="%{account.budgetBilling}" required="false" cssClass="text medium"/>

    <s:textfield label="Regular Payment" name="account.regularPayment"
                 value="%{account.regularPayment}" required="false" cssClass="text medium"/>

    <table>
    <tr><td>
    <s:textfield label="Due Date" name="account.dueDate" id="dueDate"
                 value="%{account.dueDate}" required="false" cssClass="text medium"/></td>
    <td><img src="images/calendar1.gif" alt="calendar" id="dueCal"/></td></tr>
    </table>

    <li class="buttonBar left">
        <s:submit method="save" value="Save" cssClass="button"/>
        <s:submit method="delete" value="Delete" cssClass="button"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement('account');
    Calendar.setup(
        {
            inputField  : "dueDate",      // id of the input field
            ifFormat    : "%m/%d/%Y",      // the date format
            button      : "dueCal"    // id of the button
        }
            );
</script>

<div style="margin-top: 50px">
    <s:action name="account!list" id="action" namespace="default"/>
    <display:table name="action.accounts" id="row" cellspacing="0" cellpadding="0"
        defaultsort="1" class="table" pagesize="50" requestURI="">
        <%-- Table columns --%>
        <display:column titleKey="account.name" sortable="true">
            <s:a href="account.html?id=${row.id}"><c:out value="${row.accountName}" escapeXml="true"/></s:a>
        </display:column>

        <display:setProperty name="paging.banner.item_name" value="account" />
        <display:setProperty name="paging.banner.items_name" value="accounts" />
    </display:table>
</div>
<div style="margin-top: 50px">
    <s:action name="account!listChildren" id="action2" namespace="default"/>
    <display:table name="action2.accountDetails" id="row2" cellspacing="0" cellpadding="0"
        defaultsort="1" class="table" pagesize="50" requestURI="">

        <%-- Table columns --%>
        <display:column titleKey="accountDetail.description" sortable="true">
            <s:a href="accountDetail.html?id=${row2.id}"><c:out value="${row2.sequenceNumber} - ${row2.description}" escapeXml="true"/></s:a>
        </display:column>

        <display:setProperty name="paging.banner.item_name" value="accountDetail" />
        <display:setProperty name="paging.banner.items_name" value="accountDetails" />
    </display:table>
</div>
</html>