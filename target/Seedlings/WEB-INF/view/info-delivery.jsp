<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.06.2022
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

<h1 style="text-align: center">Правила доставки и оплаты заказа товара в магазине www.seedlings.by</h1>


<table style="text-align: center;width: 100%;" border="0" cellspacing="50" frame="border" rules="all">
<tbody><tr><td>
<div style="text-align: center;">Сроки рассылки "<b>Весна-2022</b>":</div>
<div>1. Семена - <b>круглогодично</b><br>
2. Луковицы и корневища цветов - <b>с 1 марта</b><br>
3. Саженцы декоративных растений - <b>с 10 марта</b><br>
4. Саженцы плодовых культур - <b>с 1 апреля</b></div>
</td>
<td>
<div style="text-align: center;"><b>Оплата товара только по факту получения!</b><br><br>
При получении заказа <b>ЛЮБЫМ</b> способом<br> оплатить можно наличными и по карточке.</div>
</td>
</tr>
</tbody>
</table>
<br>


<table style="width: 100%;" border="0" frame="box" rules="all">
<tbody>
<div style="text-align: center;"><b>Виды доставки</b></div>
<tr>
<td style="text-align: left;">#1. Самовывоз&nbsp;<a href="#1">>>></a></td>
<td style="text-align: center;color: #ff0000;"><b>БЕСПЛАТНО</b></td>
</tr>
<tr>
<td style="text-align: left;">#2. Курьером на дом <a href="#2">>>></a></td>
<td style="text-align: center;"><b>13,99</b> (<span style="color: #ff0000;"><b>БЕСПЛАТНО</b></span> от 150 руб.)</td>
</tr>
</tbody>
</table>

<br>

<br>Отправка посадочного материала осуществляется с учетом погодных условий и рекомендуемых сроков посадки. Отправка товаров с разными сроками рассылки в одном заказе производится&nbsp;одной посылкой по сроку рассылки товара с более поздней отправкой.<br>
    <div style="text-align: center;font-size: large"><b>Минимальная сумма заказа не ограничена! <br></b></div>
<br>
        <table style="width: 100%;">
            <tbody><tr>
                <td style="text-align: center;font-size: large;"><b>#1. Самовывоз в г. Минске</b><br>
                    (Вы оплачиваете только товар + упаковочные работы<b>2,99 руб.</b>)<br>
                    Заказы с пометкой "Самовывоз" выдаются ТОЛЬКО после нашего звонка заказчику. <br>
                    Пункт самовывоза находятся по адресам: <br>
                    <c:forEach var="address" items="${allPickupAddresses}">
                        <b>${address.id}</b>.   ${address.address}. Режим работы:${address.workingHours}<br>
            </c:forEach><br>
                    Непосредственно перед получением заказа Вам позвонит оператор. После звонка товар необходимо забрать в <a name="2"></a>ближайший срок, для исключения порчи "живого" материала в упакованном виде.</td>
            </tr></tbody></table><br>

        <table style="width: 100%;">
            <tbody>
            <tr>
                <td style="text-align: center;font-size: large;"><b>#2. Курьером на дом</b><br>
                    <span style="font-size: medium;">(Вы оплачиваете товар + упаковочные работы <b> 2,99</b> руб.)<br>Доставка осуществляется в любой населенный пункт Республики Беларусь адрес названный вами после телефонного звонка. Время доставки также согласовывается заранее по телефону. По факту формирования отправления с Вами свяжется опеторатор. Все отправления выдаются на основании документа, удостоверяющего личность.<br>Стоимость доставки по Беларуси - <b>13,99</b> руб. (<span style="color: #ff0000;"><b>БЕСПЛАТНО</b></span> от 150 руб.)<a name="2"></a><br></span></td>
            </tr>
            </tbody>
        </table>
<br>
            <div style="text-align: left;"><b>Фирма оставляет за собой право:
                <ul>
                    <li>корректировки цены в случае значительного изменения курса валют</li>
                    <li>не высылать посадочный материал, если такового не окажется на складе</li>
                </ul>

        </b></div>
</body>
</html>
