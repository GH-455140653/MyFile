<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="LimitRole.aspx.cs" Inherits="WebUI.LimitRole" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div>
        <asp:Image ID="Image2" runat="server" ImageUrl="~/images/404.jpg" />
        <br />
        请确认你的访问权限，点击
    <a href="javascript:window.history.back();">这里</a>返回!
    <br />
    </div>
</asp:Content>
