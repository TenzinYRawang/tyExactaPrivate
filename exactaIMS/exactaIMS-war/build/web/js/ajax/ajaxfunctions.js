function loadeditclient(i)
{
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function()
    {
        if (this.readyState == 4 && this.status == 200)
        {
            document.getElementById("clientform").innerHTML = this.responseText;
            loadeditclientform(i);
        }
    };
    
    xhttp.open("GET", "xml/editclientform.xml", true);
    xhttp.send();
}

function loadeditclientform(i)
{
    var id = new String(i);
    
    var hiddenform = document.getElementById(id);
    var hiddenformnodes = hiddenform.childNodes;

    document.getElementById("editid").value = i;
    document.getElementById("editname").value = hiddenformnodes[0].value;
    document.getElementById("editcss").value = hiddenformnodes[1].value;
    document.getElementById("editlogo").value = hiddenformnodes[2].value;
    document.getElementById("editemail").value = hiddenformnodes[3].value;
    document.getElementById("editurl").value = hiddenformnodes[4].value;
    document.getElementById("editphonenumber").value = hiddenformnodes[5].value;
}

function loadaddclient()
{
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function()
    {
        if (this.readyState == 4 && this.status == 200)
        {
            document.getElementById("clientform").innerHTML = this.responseText;
            loadeditclientform(i);
        }
    };
    
    xhttp.open("GET", "xml/addclientform.xml", true);
    xhttp.send();
}

