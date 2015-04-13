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

<form action="/action/move" method="GET">
    Player Name: <input type="text" name="username">
    x: <input type="text" name="x">
    y: <input type="text" name="y">
    <input type="submit" value="Submit"/>
</form>

</body>
</html>