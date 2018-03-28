function validateEditClient()
{
    var clientName = document.forms["AdminEditClient"]["clientName"].value;
    var clientCss = document.forms["AdminEditClient"]["clientCSS"].value;
    var clientLogo = document.forms["AdminEditClient"]["clientLogo"].value;
    var clientEmail = document.forms["AdminEditClient"]["clientEmail"].value;
    var clientUrl = document.forms["AdminEditClient"]["clientEmail"].value;
    var clientPhoneNumber = document.forms["AdminEditClient"]["clientPhoneNumber"].value;
    var emailRegex = /\S+@\S+\.\S+/;
    //var urlRegex = /\S+\.\S+/;
    var phoneRegex = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;
    if (clientName.length > 30 || clientName.indexOf('<') > -1)
    {
      alert("Client name too long or invalid.");
      return false;
    }
    else if (clientCss.length > 25 || clientCss.indexOf('<') > -1)
    {
        alert("CSS file name is too long or invalid.");
        return false;
    }
    else if (clientLogo.length > 25 || clientLogo.indexOf('<') > -1)
    {
        alert("Logo file name is too long or invalid.");
        return false;
    }
    else if (clientEmail.length > 50 || !clientEmail.match(emailRegex) || clientEmail.indexOf('<') > -1)
    {
        alert("Email is too long or invalid.");
        return false;
    }
    /**
    else if (clientUrl.length > 100 || !clientUrl.match(urlRegex) || clientUrl.indexOf('<') > -1)
    {
        alert("URL is too long or invalid.");
        return false;
    }
    */
    else if (clientPhoneNumber.length > 15 || !clientPhoneNumber.match(phoneRegex) || clientPhoneNumber.indexOf('<') > -1)
    {
        alert("Phone Number is too long or invalid.");
        return false;
    }
    else
    {
        document.AdminEditClient.submit();
    }
}