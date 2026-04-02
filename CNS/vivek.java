<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diffie Hellman Key Exchange</title>

<style>
body{
    font-family: Arial, sans-serif;
    background-color:#f2f2f2;
}

.box{
    background-color:white;
    width:420px;
    margin:40px auto;
    padding:20px;
    border-radius:10px;
    box-shadow:2px 2px 10px gray;
}

h2{
    text-align:center;
    color:#2c3e50;
}

.row{
    margin:10px 0;
}

label{
    display:inline-block;
    width:170px;
}

input{
    width:180px;
    padding:5px;
}

button{
    margin-top:10px;
    padding:8px 15px;
    background-color:blue;
    color:white;
    border:none;
    border-radius:5px;
    cursor:pointer;
}

button:hover{
    background-color:darkblue;
}

#result{
    margin-top:15px;
    font-weight:bold;
}
</style>

</head>

<body>

<div class="box">

<h2>Diffie-Hellman Key Exchange</h2>

<div class="row">
<label>Prime number (p):</label>
<input type="number" id="p" value="23">
</div>

<div class="row">
<label>Generator (g):</label>
<input type="number" id="g" value="5">
</div>

<div class="row">
<label>Alice Private Key (a):</label>
<input type="number" id="a" value="6">
</div>

<button onclick="compute()">Compute</button>

<p id="result"></p>

</div>

<script>

function modPow(base, exp, mod)
{
    let result = 1;
    base = base % mod;

    while(exp > 0)
    {
        if(exp % 2 === 1)
        {
            result = (result * base) % mod;
        }

        exp = Math.floor(exp / 2);
        base = (base * base) % mod;
    }

    return result;
}

function compute()
{
    let p = Number(document.getElementById("p").value);
    let g = Number(document.getElementById("g").value);
    let a = Number(document.getElementById("a").value);

    if(!p || !g || !a)
    {
        document.getElementById("result").innerHTML = "Please enter valid numbers.";
        return;
    }

    let b = Math.floor(Math.random() * (p - 2)) + 1;

    let A = modPow(g, a, p);
    let B = modPow(g, b, p);

    let Ka = modPow(B, a, p);
    let Kb = modPow(A, b, p);

    let output = "";
    output += "Alice private key = " + a + "<br>";
    output += "Bob private key = " + b + "<br><br>";
    output += "Alice public key A = " + A + "<br>";
    output += "Bob public key B = " + B + "<br><br>";
    output += "Alice secret key = " + Ka + "<br>";
    output += "Bob secret key = " + Kb + "<br>";

    document.getElementById("result").innerHTML = output;
}

</script>

</body>
</html>
