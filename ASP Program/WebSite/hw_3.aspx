<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="hw_3.aspx.cs" Inherits="WebSite.hw_3" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="ID" DataSourceID="SqlDataSource1" Height="329px" HorizontalAlign="Center" Width="624px">
                <Columns>
                    <asp:CommandField SelectText="详细信息" ShowSelectButton="True" />
                    <asp:BoundField DataField="ID" HeaderText="ID" InsertVisible="False" ReadOnly="True" SortExpression="ID" />
                    <asp:BoundField DataField="StuName" HeaderText="StuName" SortExpression="StuName" />
                </Columns>
            </asp:GridView>
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:pubs %>" SelectCommand="SELECT * FROM [Students]"></asp:SqlDataSource>
            <br />
            <br />
            <asp:GridView ID="GridView2" runat="server" Height="208px" HorizontalAlign="Center" Width="383px">
            </asp:GridView>
        </div>
    </form>
</body>
</html>
