<%@ include file="/common/taglibs.jsp" %>

<title>Contact List Example</title>

<p>Select a contact to update or delete:</p>

<div style="margin-top: 50px">
    <display:table name="action.contacts" id="row" cellspacing="0" cellpadding="0"
        defaultsort="1" class="table" pagesize="50" requestURI="">

        <%-- Table columns --%>
        <display:column titleKey="contacts.fullName" sortable="true">
            <s:a href="contact.html?id=${row.id}"><c:out value="${row.firstName} ${row.lastName}" escapeXml="true"/></s:a>
        </display:column>

        <display:setProperty name="paging.banner.item_name" value="contact" />
        <display:setProperty name="paging.banner.items_name" value="contacts" />
    </display:table>
</div>