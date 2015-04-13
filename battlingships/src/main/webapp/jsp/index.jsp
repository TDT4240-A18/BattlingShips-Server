<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>

<form action="create" method="GET">
    Player Name: <input type="text" name="username">
    Create a Game
    <input type="submit" value="Submit"/>
</form>

<form action="join" method="GET">
    Player Name: <input type="text" name="username">
    join Game
    <input type="submit" value="Submit"/>
</form>

<form action="ready" method="GET">
    Player Name: <input type="text" name="username">
    ready for play the Game
    <input type="submit" value="Submit"/>
</form>

<form action="check" method="GET">
    Player Name: <input type="text" name="username">
    Check
    <input type="submit" value="Submit"/>
</form>
<p></p>

<p>actions:</p>

<form action="/action/move" method="GET">
    Player Name: <input type="text" name="username">
    Move to:
    x: <input type="text" name="x">
    y: <input type="text" name="y">
    <input type="submit" value="Submit"/>
</form>

<form action="/action/shoot" method="GET">
    Player Name: <input type="text" name="username">
    Shoot to:
    x: <input type="text" name="x">
    y: <input type="text" name="y">
    <input type="submit" value="Submit"/>
</form>

<form action="/action/doNothing" method="GET">
    Player Name: <input type="text" name="username">
    no nothing:
    <input type="submit" value="Submit"/>
</form>
<p></p>

<p>Finish:</p>

<form action="finish" method="GET">
    Player Name: <input type="text" name="username">
    finish:
    <input type="submit" value="Submit"/>
</form>
<p></p>

<p>---------------------------------------------------------</p>

<p>
    ${game.gameInfor()}
</p>
</body>
</html>