<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.06.2022
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Доставка Seedlings.by</title>
</head>
<body>
<jsp:include page="header.jsp" />

<h1 class="title title_center">Правила доставки и оплаты заказа товара в магазине www.seedlings.by</h1>
<div class="article_text_block">
    <div><span style="font-size: medium;">
<table style="text-align: center;width: 80%;" border="0" cellspacing="50" frame="border" rules="all">
<tbody>
<tr>
<td>
<div style="text-align: center;"><span style="font-size: medium;">Сроки рассылки "<b>Весна-2022</b>":</span></div>
<div><span style="font-size: medium;">&nbsp;1. Семена&nbsp; -&nbsp; <b>круглогодично</b></span></div>
<div><span style="font-size: medium;">&nbsp;2. Луковицы и корневища цветов - <b>с <b>1 марта</b></b></span></div>
<div><span style="font-size: medium;">&nbsp;3. Саженцы декоративных растений - с <b>10 марта</b></span></div>
<div><span style="font-size: medium;">&nbsp;4. Саженцы плодовых культур - <b>с 1 апреля</b></span></div>
</td>
<td>
<p style="text-align: center;"><span style="font-size: x-small;"><span style="font-size: medium;"><b>Оплата товара только по факту получения!</b></span></span></p>
<p style="text-align: center;"><span style="font-size: medium;">При получении заказа <b>ЛЮБЫМ</b> способом<br /> оплатить можно наличными и по карточке.</span></p>
</td>
</tr>
</tbody>
</table>
</span></div>
    <div><span style="font-size: medium;"><br />
<table style="width: 100%;" border="0" frame="box" rules="all">
<tbody>
<div style="text-align: center;"><b>Виды доставки</b></div>
<tr>
<td style="text-align: left;"><span style="font-size: medium;">#1. Самовывоз&nbsp;<a href="#1">>>></a></span></td>
<td style="text-align: center;"><span style="font-size: medium;"><span style="color: #ff0000;"><b>БЕСПЛАТНО</b></span></span></td>
</tr>
<tr>
<td style="text-align: left;"><span style="font-size: medium;">#2. Курьером на дом <a href="#2">>>></a></span></td>
<td style="text-align: center;"><span style="font-size: medium;"><b>13,99</b> (<span style="color: #ff0000;"><b>БЕСПЛАТНО</b></span> от 150 руб.)</span></td>
</tr>
</tbody>
</table>

<br />

<br />Отправка посадочного материала осуществляется с учетом погодных условий и рекомендуемых сроков посадки.&nbsp;</span><span style="font-size: medium;">Отправка товаров с разными сроками рассылки в одном заказе производится&nbsp;одной посылкой по сроку рассылки товара с более поздней отправкой.&nbsp;<br></span></div>
    <div style="text-align: center;"><span style="font-size: medium;"><span style="font-size: large;"><b>Минимальная сумма заказа </b></span><b><span style="font-size: large;"><b>не ограничена! <br /></b></span><span style="font-weight: normal;">&nbsp;</span></b></span></div>
    <div style="text-align: left;">
        <table style="width: 100%;" border="0" frame="box" rules="all">
            <tbody>
            <tr>
                <td style="text-align: center;"><span style="font-size: large;"><b>#1. Самовывоз в г. Минске</b><br><span style="font-size: medium;">(Вы оплачиваете только товар + упаковочные работы&nbsp;<b>2,99 руб.</b>)<br />Заказы с пометкой "Самовывоз" выдаются ТОЛЬКО после нашего звонка заказчику. <br>
                    Пункт самовывоза находятся по адресам: <br>
                    <c:forEach var="address" items="${allPickupAddresses}">
                        <b>${address.id}</b>.   ${address.address}. Режим работы:${address.workingHours}<br>
            </c:forEach><br>
                    Непосредственно перед получением заказа Вам позвонит оператор. После звонка товар необходимо забрать в <a name="2"></a>ближайший срок, для исключения порчи "живого" материала в упакованном виде.</span></span></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div style="text-align: center;"><span style="font-size: small;">&nbsp;</span></div>
    <div style="text-align: left;">
        <table style="width: 100%;" border="0" frame="box" rules="all">
            <tbody>
            <tr>
                <td style="text-align: center;"><span style="font-size: large;"><span style="font-family: verdana, geneva;"><b>#2. Курьером на дом</b></span></span><br /><span style="font-size: medium;">(Вы оплачиваете товар + упаковочные работы <b>2,99</b> руб.)<br />Доставка осуществляется в любой населенный пункт Республики Беларусь на указанный в заявке адрес. Время доставки согласовывается заранее по телефону. По факту формирования отправления с Вами свяжется опеторатор. Все почтовые отправления выдаются на основании документа, удостоверяющего личность, либо по доверенности. Доставку осуществляют курьерские службы РУП Белпочта и Европочта<br />Стоимость доставки по Беларуси - <b>13,99</b> руб. (<span style="color: #ff0000;"><b>БЕСПЛАТНО</b></span> от 150 руб.)<a name="3"></a><br /></span></td>
            </tr>
            </tbody>
        </table>
    </div>
    <p><b><b><b>&nbsp;</b><span style="font-weight: normal; font-size: medium;">&nbsp;</span></b></b></p>

    <div><b>
        <div>
            <div style="text-align: center;"><span style="font-size: medium;">За что Вы платите при получении заказа почтой:<br />
<table style="width: 100%;" border="0">
<tbody>
<tr>
<td style="width: 50%; border: 1px solid #000000;">
<div style="text-align: center;"><span style="font-size: medium;"><b><span style="font-family: verdana, geneva;">Заказав луковицы, клубни, саженцы:</span></b></span></div>
<div style="text-align: center;"><span style="font-size: medium;"><span style="font-family: verdana, geneva;">&nbsp;а) за посадочный материал согласно ценам каталога (сайта).</span></span></div>
<div style="text-align: center;"><span style="font-size: medium;"><span style="font-family: verdana, geneva;">&nbsp;б) за упаковочные работы <b>2,99</b>&nbsp;рублей за весь заказ.</span></span></div>
<div style="text-align: center;"><span style="font-size: medium;">&nbsp;в)&nbsp;</span><span style="font-family: verdana, geneva;">за услуги почты <b>10,99 рублей</b></span></div>
<div style="text-align: center;"><span style="font-size: medium;">&nbsp;<br /></span></div>
</td>
<td style="width: 50%; border: 1px solid #000000;">
<div style="text-align: center;"><b><span style="font-size: large;"><span style="font-size: medium;"><span style="font-family: verdana, geneva;">Заказав только семена:</span></span></span></b></div>
<div style="text-align: center;"><span style="font-family: verdana, geneva;"><b></b><span style="font-size: medium;">а) за семена &nbsp;согласно ценам каталога (сайта).</span></span></div>
<div style="text-align: center;"><span style="font-size: medium; text-align: left;"><span style="font-family: verdana, geneva;">б) за услуги почты <b>4,99 рублей</b></span></span></div>
</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
</tbody>
</table>
<p><span style="font-size: medium;"><b><span style="white-space: pre;"> </span></b></span></p>
</span></div>
            <div style="text-align: left;"><span style="font-size: medium;"><b>Фирма оставляет за собой право:</b></span></div>
            <div>
                <ul>
                    <li><span style="font-size: medium;">корректировки цены в случае значительного изменения курса валют</span></li>
                    <li><span style="font-size: medium;">не высылать посадочный материал, если такового не окажется на складе</span></li>
                </ul>
            </div>
        </div></b></div></div>
</body>
</html>
