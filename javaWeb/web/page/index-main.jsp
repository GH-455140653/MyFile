<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'main.jsp' starting page</title>
<style type="text/css">
	
    div{
	border:#9C6 1px dotted;/*��ӱ߿�*/
	margin-left:10px;/*�������߾����*/
	font-size:14px;
	}
	a{
	text-decoration:none;/*����ȥ���»���*/
	}
	table{
	font-size:12px;/*����ı�ͳһΪ12px*/
		}

</style>
  </head>
  
  <body>
    <div>
<div monkey="rank-top100" style="width:200px; float:left;">
  <div>
    <h2><a href="http://list.mp3.baidu.com/top/top100.html">�¸�TOP100</a></h2>
  </div>
  <table>
    <tbody>
      <tr>
        <th><em>1</em></th>
        <td><a onclick="return omb(10,'�¸�TOP100',0)" href="#">��ĺ��ں�</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/����.html" target="_blank">����</a></td>
      </tr>
      <tr>
        <th><em>2</em></th>
        <td><a title="����·�ںη�" onclick="return omb(10,'�¸�TOP100',1)" href="#">����·�ں�...</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/����.html" target="_blank">����</a></td>
      </tr>
      <tr>
        <th><em>3</em></th>
        <td><a onclick="return omb(10,'�¸�TOP100',2)" href="#">����ħ��</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/��ɯ.html" target="_blank">��ɯ</a></td>
      </tr>
      <tr>
        <th><em>4</em></th>
        <td><a onclick="return omb(10,'�¸�TOP100',3)" href="#">ȼ��</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/����.html" target="_blank">����</a></td>
      </tr>
      <tr>
        <th><em>5</em></th>
        <td><a onclick="return omb(10,'�¸�TOP100',4)" href="#">���˽�</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/����.html" target="_blank">����</a></td>
      </tr>
      <tr>
        <th><em>6</em></th>
        <td><a title="û��Ŀ�ĵذ���" onclick="return omb(10,'�¸�TOP100',5)" href="#">û��Ŀ�ĵ�...</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/��ǧ��.html" target="_blank">��ǧ��</a></td>
      </tr>
      <tr>
        <th><em>7</em></th>
        <td><a onclick="return omb(10,'�¸�TOP100',6)" href="#">����</a></td>
        <td><a title="�ν�,�³���" href="http://mp3.baidu.com/singerlist/�ν�,�³���.html" target="_blank">�ν�,...</a></td>
      </tr>
      <tr>
        <th><em>8</em></th>
        <td><a title="�����ϵİ���" onclick="return omb(10,'�¸�TOP100',7)" href="#">�����ϵİ�...</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/����.html" target="_blank">����</a></td>
      </tr>
      <tr>
        <th><em>9</em></th>
        <td><a title="���˽ڵ�ҹ��" onclick="return omb(10,'�¸�TOP100',8)" href="#">���˽ڵ�ҹ...</a></td>
        <td><a title="����,С��" href="http://mp3.baidu.com/singerlist/����,С��.html" target="_blank">����,...</a></td>
      </tr>
      <tr>
        <th><em>10</em></th>
        <td><a onclick="return omb(10,'�¸�TOP100',9)" href="#">�������˽�</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/����Ȼ.html" target="_blank">����Ȼ</a></td>
      </tr>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="2"><a href="http://list.mp3.baidu.com/top/top100.html">����&gt;&gt;</a></td>
        <td><a onclick="return omb(10,'�¸�TOP100',0)" href="#">����ȫ��</a></td>
      </tr>
    </tfoot>
  </table>
</div>
<div monkey="rank-top500" style="width:200px;float:left;">
  <div>
    <h2><a href="http://list.mp3.baidu.com/top/top500.html">����TOP500</a></h2>
  </div>
  <table>
    <tbody>
      <tr>
        <th><em>1</em></th>
        <td><a onclick="return omb(10,'����TOP500',0)" href="#">��Ϊ����</a></td>
        <td><a title="����,����Ѹ" href="http://mp3.baidu.com/singerlist/����,����Ѹ.html" target="_blank">����,...</a></td>
      </tr>
      <tr>
        <th><em>2</em></th>
        <td><a onclick="return omb(10,'����TOP500',1)" href="#">�δ�</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/٩٩.html" target="_blank">٩٩</a></td>
      </tr>
      <tr>
        <th><em>3</em></th>
        <td><a onclick="return omb(10,'����TOP500',2)" href="#">�˲���</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/����.html" target="_blank">����</a></td>
      </tr>
      <tr>
        <th><em>4</em></th>
        <td><a title="i will always love you" onclick="return omb(10,'����TOP500',3)" href="#">i will alw...</a></td>
        <td><a title="whitney houston" href="http://mp3.baidu.com/singerlist/whitney houston.html" target="_blank">whitne...</a></td>
      </tr>
      <tr>
        <th><em>5</em></th>
        <td><a onclick="return omb(10,'����TOP500',4)" href="#">���к�</a></td>
        <td><a title="�����ֵ�" href="http://mp3.baidu.com/singerlist/�����ֵ�.html" target="_blank">������...</a></td>
      </tr>
      <tr>
        <th><em>6</em></th>
        <td><a onclick="return omb(10,'����TOP500',5)" href="#">�ټ��ഺ</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/����.html" target="_blank">����</a></td>
      </tr>
      <tr>
        <th><em>7</em></th>
        <td><a onclick="return omb(10,'����TOP500',6)" href="#">�¹������</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/�����.html" target="_blank">�����</a></td>
      </tr>
      <tr>
        <th><em>8</em></th>
        <td><a onclick="return omb(10,'����TOP500',7)" href="#">���Ĺ���</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/����.html" target="_blank">����</a></td>
      </tr>
      <tr>
        <th><em>9</em></th>
        <td><a onclick="return omb(10,'����TOP500',8)" href="#">��������</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/����.html" target="_blank">����</a></td>
      </tr>
      <tr>
        <th><em>10</em></th>
        <td><a onclick="return omb(10,'����TOP500',9)" href="#">׷����</a></td>
        <td><a href="http://mp3.baidu.com/singerlist/��ɷ�.html" target="_blank">��ɷ�</a></td>
      </tr>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="2"><a href="http://list.mp3.baidu.com/top/top500.html">����&gt;&gt;</a></td>
        <td><a onclick="return omb(10,'����TOP500',0)" href="#">����ȫ��</a></td>
      </tr>
    </tfoot>
  </table>
</div>
<div monkey="rank-top200" style="width:200px;float:left">
  <div>
    <h2><a href="http://list.mp3.baidu.com/top/top200.html">����TOP200</a></h2>
  </div>
  <table>
    <tbody>
      <tr>
        <th><em>1</em></th>
        <td><a href="http://mp3.baidu.com/singerlist/���»�.html">���»�</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1224?fr=mp3-top200">ta���ȸ�</a></td>
      </tr>
      <tr>
        <th><em>2</em></th>
        <td><a href="http://mp3.baidu.com/singerlist/����.html">����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/45561?fr=mp3-top200">ta���ȸ�</a></td>
      </tr>
      <tr>
        <th><em>3</em></th>
        <td><a href="http://mp3.baidu.com/singerlist/��˴���.html">��˴���</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1490?fr=mp3-top200">ta���ȸ�</a></td>
      </tr>
      <tr>
        <th><em>4</em></th>
        <td><a href="http://mp3.baidu.com/singerlist/�Ž�.html">�Ž�</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1035?fr=mp3-top200">ta���ȸ�</a></td>
      </tr>
      <tr>
        <th><em>5</em></th>
        <td><a href="http://mp3.baidu.com/singerlist/����Ѹ.html">����Ѹ</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1077?fr=mp3-top200">ta���ȸ�</a></td>
      </tr>
      <tr>
        <th><em>6</em></th>
        <td><a href="http://mp3.baidu.com/singerlist/�ܽ���.html">�ܽ���</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/7994?fr=mp3-top200">ta���ȸ�</a></td>
      </tr>
      <tr>
        <th><em>7</em></th>
        <td><a href="http://mp3.baidu.com/singerlist/S.H.E.html">S.H.E</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/2511?fr=mp3-top200">ta���ȸ�</a></td>
      </tr>
      <tr>
        <th><em>8</em></th>
        <td><a href="http://mp3.baidu.com/singerlist/��ɷ�.html">��ɷ�</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1293?fr=mp3-top200">ta���ȸ�</a></td>
      </tr>
      <tr>
        <th><em>9</em></th>
        <td><a href="http://mp3.baidu.com/singerlist/����.html">����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1056?fr=mp3-top200">ta���ȸ�</a></td>
      </tr>
      <tr>
        <th><em>10</em></th>
        <td><a href="http://mp3.baidu.com/singerlist/������.html">������</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1091?fr=mp3-top200">ta���ȸ�</a></td>
      </tr>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="2"><a href="http://list.mp3.baidu.com/top/top200.html">����&gt;&gt;</a></td>
      </tr>
    </tfoot>
  </table>
</div>
<div style="width:200px; clear:both; float:left;">
<table>
  <tbody>
    <tr>
      <th><em>11</em></th>
      <td><a title="Whitney Houston" href="http://mp3.baidu.com/singerlist/Whitney Houston.html">Whitne...</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/11698?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>12</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/��ѧ��.html">��ѧ��</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/2507?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>13</em></th>
      <td><a title="Lady GaGa" href="http://mp3.baidu.com/singerlist/Lady GaGa.html">Lady G...</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/6792?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>14</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/С����.html">С����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/55198?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>15</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/�����.html">�����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1078?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>16</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/Adele.html">Adele</a></td>
    </tr>
    <tr>
      <th><em>17</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/������.html">������</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1107?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>18</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/����.html">����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1157?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>19</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/����.html">����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1557?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>20</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/�ֿ���.html">�ֿ���</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1052?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <th></th>
      <td><a href="http://list.mp3.baidu.com/top/singer/A.html">ȫ������</a></td>
    </tr>
  </tfoot>
</table>
</div>

<div style="width:200px; float:left;">
<table>
  <tbody>
    <tr>
      <th><em>11</em></th>
      <td><a title="Whitney Houston" href="http://mp3.baidu.com/singerlist/Whitney Houston.html">Whitne...</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/11698?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>12</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/��ѧ��.html">��ѧ��</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/2507?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>13</em></th>
      <td><a title="Lady GaGa" href="http://mp3.baidu.com/singerlist/Lady GaGa.html">Lady G...</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/6792?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>14</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/С����.html">С����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/55198?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>15</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/�����.html">�����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1078?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>16</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/Adele.html">Adele</a></td>
    </tr>
    <tr>
      <th><em>17</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/������.html">������</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1107?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>18</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/����.html">����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1157?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>19</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/����.html">����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1557?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>20</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/�ֿ���.html">�ֿ���</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1052?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <th></th>
      <td><a href="http://list.mp3.baidu.com/top/singer/A.html">ȫ������</a></td>
    </tr>
  </tfoot>
</table>
</div><div style="width:200px;float:left">
<table>
  <tbody>
    <tr>
      <th><em>11</em></th>
      <td><a title="Whitney Houston" href="http://mp3.baidu.com/singerlist/Whitney Houston.html">Whitne...</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/11698?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>12</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/��ѧ��.html">��ѧ��</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/2507?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>13</em></th>
      <td><a title="Lady GaGa" href="http://mp3.baidu.com/singerlist/Lady GaGa.html">Lady G...</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/6792?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>14</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/С����.html">С����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/55198?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>15</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/�����.html">�����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1078?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>16</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/Adele.html">Adele</a></td>
    </tr>
    <tr>
      <th><em>17</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/������.html">������</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1107?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>18</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/����.html">����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1157?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>19</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/����.html">����</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1557?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
    <tr>
      <th><em>20</em></th>
      <td><a href="http://mp3.baidu.com/singerlist/�ֿ���.html">�ֿ���</a><a title="ta���ȸ�" href="http://ting.baidu.com/artist/1052?fr=mp3-top200">ta���ȸ�</a></td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <th></th>
      <td><a href="http://list.mp3.baidu.com/top/singer/A.html">ȫ������</a></td>
    </tr>
  </tfoot>
</table>
</div>

</div>
  </body>
</html>
