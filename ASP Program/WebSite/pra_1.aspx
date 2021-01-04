<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="pra_1.aspx.cs" Inherits="WebSite.pra_1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:FileUpload ID="FUL" runat="server" />
            <br />
            <asp:Button ID="btn_upload" runat="server" OnClick="btn_upload_Click" Text="上传" />
            <asp:Label ID="uploadLB" runat="server"></asp:Label>
        </div>
    </form>
</body>
</html>
